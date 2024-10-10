package repositorio;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp; // Para manejar LocalDateTime en la base de datos
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;


import conexionBD.ConfiguracionBaseDatos;
import modelos.Cliente;
import modelos.Factura;
import modelos.Producto;

public class FacturaRepositorio {

    // Método para guardar una nueva factura y relacionarla con múltiples productos
    public void guardarFactura(Factura factura) throws SQLException {
        String consultaFactura = "INSERT INTO factura (fecha, total, cliente_id) VALUES (?, ?, ?)";
        try (Connection conexion = ConfiguracionBaseDatos.getConnection();
             PreparedStatement statementFactura = conexion.prepareStatement(consultaFactura, PreparedStatement.RETURN_GENERATED_KEYS)) {

            // Convertir LocalDateTime a Timestamp para la base de datos
            statementFactura.setTimestamp(1, Timestamp.valueOf(factura.getFecha())); 
            statementFactura.setDouble(2, factura.getTotal());
            statementFactura.setString(3, factura.getCliente().getCorreo()); // Usamos el correo como ID del cliente
            
            // Ejecutar la consulta para insertar la factura y obtener su ID generado
            statementFactura.executeUpdate();

            int facturaId = 0;
            try (ResultSet generatedKeys = statementFactura.getGeneratedKeys()) {
                if (generatedKeys.next()) {
                    facturaId = generatedKeys.getInt(1); // Obtener el ID de la factura generada
                }
            }

            // Guardar cada producto relacionado con la factura en la tabla intermedia factura_producto
            String consultaProducto = "INSERT INTO factura_producto (factura_id, producto_id) VALUES (?, ?)";
            try (PreparedStatement statementProducto = conexion.prepareStatement(consultaProducto)) {
                for (Producto producto : factura.getProductos()) {
                    statementProducto.setInt(1, facturaId); // Establecer el ID de la factura generada
                    statementProducto.setInt(2, producto.getCodigo()); // ID del producto
                    statementProducto.executeUpdate(); // Guardar la relación en la tabla factura_producto
                }
            }
        }
    }

    // Método para buscar facturas usando el ID del cliente y traer productos asociados
    public List<Factura> buscarFacturasPorCliente(Cliente cliente) throws SQLException {
        String clienteId = cliente.getCorreo(); // Usar el correo como identificador del cliente

        String consultaFactura = "SELECT * FROM factura WHERE cliente_id = ?";
        List<Factura> facturas = new ArrayList<>();

        try (Connection conexion = ConfiguracionBaseDatos.getConnection();
             PreparedStatement statement = conexion.prepareStatement(consultaFactura)) {

            // Establecer el correo del cliente en la consulta
            statement.setString(1, clienteId);

            try (ResultSet resultSet = statement.executeQuery()) {
                while (resultSet.next()) {
                    int facturaId = resultSet.getInt("id");
                    LocalDateTime fecha = resultSet.getTimestamp("fecha").toLocalDateTime(); // Convertir a LocalDateTime
                    double total = resultSet.getDouble("total");

                    // Buscar todos los productos asociados a esta factura
                    List<Producto> productos = buscarProductosPorFacturaId(facturaId);

                    // Crear el objeto Factura y añadirlo a la lista
                    Factura factura = new Factura(cliente, productos, fecha);
                    facturas.add(factura);
                }
            }
        }
        return facturas; // Devolver todas las facturas asociadas al cliente
    }

    // Método auxiliar para buscar productos por el ID de la factura en la tabla intermedia factura_producto
    private List<Producto> buscarProductosPorFacturaId(int facturaId) throws SQLException {
        String consultaProducto = "SELECT p.id, p.marca, p.modelo, p.precio, p.descripcion " +
                                  "FROM producto p " +
                                  "JOIN factura_producto fp ON p.id = fp.producto_id " +
                                  "WHERE fp.factura_id = ?";
        List<Producto> productos = new ArrayList<>();

        try (Connection conexion = ConfiguracionBaseDatos.getConnection();
             PreparedStatement statement = conexion.prepareStatement(consultaProducto)) {

            statement.setInt(1, facturaId); // Establecer el ID de la factura en la consulta

            try (ResultSet resultSet = statement.executeQuery()) {
                while (resultSet.next()) {
                    Producto producto = new Producto(
                        resultSet.getString("marca"),
                        resultSet.getString("modelo"),
                        resultSet.getDouble("precio"),
                        resultSet.getString("descripcion") // Eliminado el campo cantidad
                    );
                    productos.add(producto); // Añadir cada producto a la lista
                }
            }
        }
        return productos; // Devolver la lista de productos encontrados para la factura
    }
    
    
    // Método para eliminar todas las facturas de un cliente por su correo
    public void eliminarFacturasPorClienteCorreo(String correoCliente) throws SQLException {
        // Primero, obtenemos los IDs de las facturas asociadas al cliente
        String consultaFacturas = "SELECT id FROM factura WHERE cliente_id = ?";
        try (Connection conexion = ConfiguracionBaseDatos.getConnection();
             PreparedStatement statementFacturas = conexion.prepareStatement(consultaFacturas)) {

            // Establecemos el correo del cliente en la consulta
            statementFacturas.setString(1, correoCliente);

            try (ResultSet resultSet = statementFacturas.executeQuery()) {
                // Recorremos todas las facturas asociadas al cliente
                while (resultSet.next()) {
                    int facturaId = resultSet.getInt("id");
                    // Eliminamos cada factura usando su ID
                    eliminarFactura(facturaId);
                }
            }
        }
    }
    
    // Método para eliminar una factura por su ID
    public void eliminarFactura(int facturaId) throws SQLException {
        // Primero, eliminamos las relaciones en la tabla intermedia factura_producto
        String consultaEliminarRelacion = "DELETE FROM factura_producto WHERE factura_id = ?";
        
        try (Connection conexion = ConfiguracionBaseDatos.getConnection();
             PreparedStatement statementRelacion = conexion.prepareStatement(consultaEliminarRelacion)) {

            // Establecemos el ID de la factura a eliminar en la tabla intermedia
            statementRelacion.setInt(1, facturaId);
            statementRelacion.executeUpdate();
        }

        // Luego, eliminamos la factura de la tabla factura
        String consultaEliminarFactura = "DELETE FROM factura WHERE id = ?";

        try (Connection conexion = ConfiguracionBaseDatos.getConnection();
             PreparedStatement statementFactura = conexion.prepareStatement(consultaEliminarFactura)) {

            // Establecemos el ID de la factura a eliminar
            statementFactura.setInt(1, facturaId);
            statementFactura.executeUpdate();
        }
    }
    
    
    // Método para actualizar una factura existente
    public void actualizarFactura(Factura factura) throws SQLException {
        String consulta = "UPDATE factura SET fecha = ?, total = ?, cliente_id = ? WHERE id = ?";

        try (Connection conexion = ConfiguracionBaseDatos.getConnection();
             PreparedStatement statement = conexion.prepareStatement(consulta)) {

            // Establecer los valores para la actualización
            statement.setTimestamp(1, java.sql.Timestamp.valueOf(factura.getFecha())); // Fecha de la factura
            statement.setDouble(2, factura.getTotal()); // Total de la factura
            statement.setString(3, factura.getCliente().getCorreo()); // ID del cliente (correo)
            
            // Ejecutar la actualización
            statement.executeUpdate();
        }
    }
    
    
    // Método para buscar facturas por cliente (usando el cliente_id o correo)
    public List<Factura> buscarFacturasPorCliente(String clienteCorreo) throws SQLException {
        String consulta = "SELECT * FROM factura WHERE cliente_id = ?";
        List<Factura> facturas = new ArrayList<>();

        try (Connection conexion = ConfiguracionBaseDatos.getConnection();
             PreparedStatement statement = conexion.prepareStatement(consulta)) {

            // Establecer el correo del cliente como parámetro
            statement.setString(1, clienteCorreo);

            try (ResultSet resultSet = statement.executeQuery()) {
                while (resultSet.next()) {
                    // Crear una nueva factura para cada resultado encontrado
                    Factura factura = new Factura(
                        resultSet.getInt("id"),
                        obtenerClientePorId(resultSet.getString("cliente_id")),
                        null, // Aquí puedes obtener los productos asociados si es necesario
                        resultSet.getTimestamp("fecha").toLocalDateTime(),
                        resultSet.getDouble("total")
                    );
                    facturas.add(factura); // Añadir cada factura a la lista
                }
            }
        }
        return facturas; // Devolver la lista de facturas asociadas al cliente
    }

    // Método auxiliar para obtener el cliente por su ID o correo (puedes usar tu propio ClienteRepositorio)
    private Cliente obtenerClientePorId(String clienteId) throws SQLException {
        // Implementar lógica para obtener el cliente por su ID o correo (consulta al ClienteRepositorio)
        return new Cliente(); // Sustituir con la lógica real
    }
}
