package repositorio;

import java.sql.Connection;
import java.sql.Date; // java.sql.Date para la base de datos
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
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

            // Establecer la fecha, total y el ID del cliente en la consulta
            statementFactura.setDate(1, new Date(factura.getFecha().getTime())); // Usar java.sql.Date para la base de datos
            statementFactura.setDouble(2, factura.getTotal());
            statementFactura.setString(3, factura.getCliente().getCorreo()); // Obtener el ID del cliente desde el objeto Cliente
            
            // Ejecutar la consulta para insertar la factura y obtener su ID generado
            statementFactura.executeUpdate();

            int facturaId = 0;
            try (ResultSet generatedKeys = statementFactura.getGeneratedKeys()) {
                if (generatedKeys.next()) {
                    facturaId = generatedKeys.getInt(1); // Asignar el ID generado a la factura
                }
            }

            // Guardar cada producto relacionado con la factura en la tabla intermedia factura_producto
            String consultaProducto = "INSERT INTO factura_producto (factura_id, producto_id) VALUES (?, ?)";
            try (PreparedStatement statementProducto = conexion.prepareStatement(consultaProducto)) {
                for (Producto producto : factura.getProducto()) {
                    statementProducto.setInt(1, facturaId); // Establecer el ID de la factura generada
                    statementProducto.setInt(2, producto.getCodigo()); // ID del producto
                    statementProducto.executeUpdate(); // Guardar la relación en la tabla factura_producto
                }
            }
        }
    }

    // Método para buscar facturas usando el ID del cliente y traer productos asociados
    public List<Factura> buscarFacturasPorCliente(Cliente cliente) throws SQLException {
        String clienteId = cliente.getCorreo();// Usar el ID del cliente desde el objeto Cliente

        String consultaFactura = "SELECT * FROM factura WHERE cliente_id = ?";
        List<Factura> facturas = new ArrayList<>();

        try (Connection conexion = ConfiguracionBaseDatos.getConnection();
             PreparedStatement statement = conexion.prepareStatement(consultaFactura)) {

            // Establecer el ID del cliente en la consulta
            statement.setString(3, clienteId);

            try (ResultSet resultSet = statement.executeQuery()) {
                while (resultSet.next()) {
                    int facturaId = resultSet.getInt("id");
                    Date fecha = resultSet.getDate("fecha");
                    double total = resultSet.getDouble("total");

                    // Buscar todos los productos asociados a esta factura
                    List<Producto> productos = buscarProductosPorFacturaId(facturaId);

                    // Crear el objeto Factura y añadirlo a la lista
                    Factura factura = new Factura(fecha, total, cliente, productos);
                    facturas.add(factura);
                }
            }
        }
        return facturas; // Devolver todas las facturas asociadas al cliente
    }

    // Método auxiliar para buscar productos por el ID de la factura en la tabla intermedia factura_producto
    private List<Producto> buscarProductosPorFacturaId(int facturaId) throws SQLException {
        String consultaProducto = "SELECT p.id, p.marca, p.modelo, p.precio, p.cantidad, p.descripcion " +
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
                        resultSet.getInt("cantidad"),
                        resultSet.getString("descripcion")
                    );
                    productos.add(producto); // Añadir cada producto a la lista
                }
            }
        }
        return productos; // Devolver la lista de productos encontrados para la factura
    }
}