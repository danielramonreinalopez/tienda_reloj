package repositorio;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import conexionBD.ConfiguracionBaseDatos;
import excepcion.ErrorTipo;
import modelos.Cliente;
import modelos.Factura;
import modelos.Producto;
import excepcion.InvalidoException;

public class FacturaRepositorio {

//    private final ClienteRepositorio clienteRepositorio;
//
//    // Constructor para inyectar el repositorio de Cliente
//    public FacturaRepositorio(ClienteRepositorio clienteRepositorio) {
//        this.clienteRepositorio = clienteRepositorio;
//    }
//
//    // Método para guardar una nueva factura y relacionarla con múltiples productos
////    public void guardarFactura(Factura factura) throws SQLException {
////        String consultaFactura = "INSERT INTO factura (fecha, total, cliente_correo) VALUES (?, ?, ?)";
////        try (Connection conexion = ConfiguracionBaseDatos.getConnection();
////             PreparedStatement statementFactura = conexion.prepareStatement(consultaFactura)) {
////
////            statementFactura.setTimestamp(1, Timestamp.valueOf(factura.getFecha()));
////            statementFactura.setDouble(2, factura.getTotal());
////            statementFactura.setString(3, factura.getCliente().getCorreo()); // Usar correo como identificador
////            statementFactura.executeUpdate();
//
//            // Guardar los productos relacionados
////            guardarProductosRelacionados(factura.getCliente().getCorreo(), factura.getCarrito(), conexion);
////        }
//    }
//
//    // Método auxiliar para guardar la relación de productos con la factura usando el correo del cliente
//    private void guardarProductosRelacionados(String clienteCorreo, List<Producto> productos, Connection conexion) throws SQLException {
//        String consultaProducto = "INSERT INTO factura_producto (cliente_correo, producto_id) VALUES (?, ?)";
//        try (PreparedStatement statementProducto = conexion.prepareStatement(consultaProducto)) {
//            for (Producto producto : productos) {
//                statementProducto.setString(1, clienteCorreo); // Usar correo en lugar de ID de factura
//                statementProducto.setInt(2, producto.getCodigo());
//                statementProducto.executeUpdate();
//            }
//        }
//    }
//
//    // Método para buscar facturas por correo del cliente
//    public List<Factura> buscarFacturasPorCliente(String clienteCorreo) throws SQLException, InvalidoException {
//        // Reutilizamos el método buscarCliente del ClienteRepositorio
//        Cliente cliente = clienteRepositorio.buscarCliente(clienteCorreo);
//
//        if (cliente == null) {
//            throw new InvalidoException( ErrorTipo.CLIENTE_NO_ENCONTRADO);
//        }
//
//        String consultaFactura = "SELECT * FROM factura WHERE cliente_correo = ?";
//        List<Factura> facturas = new ArrayList<>();
//
//        try (Connection conexion = ConfiguracionBaseDatos.getConnection();
//             PreparedStatement statement = conexion.prepareStatement(consultaFactura)) {
//
//            statement.setString(1, clienteCorreo);
//
//            try (ResultSet resultSet = statement.executeQuery()) {
//                while (resultSet.next()) {
//                    LocalDateTime fecha = resultSet.getTimestamp("fecha").toLocalDateTime();
//                    double total = resultSet.getDouble("total");
//
//                    List<Producto> productos = buscarProductosPorClienteCorreo(clienteCorreo, conexion);
//
//                    // Crear una nueva factura y agregarla a la lista
//                    Factura factura = new Factura(cliente, carrito, fecha);
//                    facturas.add(factura);
//                }
//            }
//        }
//        return facturas;
//    }
//
//    // Método auxiliar para buscar productos asociados a una factura usando el correo del cliente
//    private List<Producto> buscarProductosPorClienteCorreo(String clienteCorreo, Connection conexion) throws SQLException {
//        String consultaProducto = "SELECT p.id, p.marca, p.modelo, p.precio, p.descripcion " +
//                                  "FROM producto p " +
//                                  "JOIN factura_producto fp ON p.id = fp.producto_id " +
//                                  "WHERE fp.cliente_correo = ?";
//        List<Producto> productos = new ArrayList<>();
//
//        try (PreparedStatement statement = conexion.prepareStatement(consultaProducto)) {
//            statement.setString(1, clienteCorreo);
//
//            try (ResultSet resultSet = statement.executeQuery()) {
//                while (resultSet.next()) {
//                    Producto producto = new Producto(
//                        resultSet.getString("marca"),
//                        resultSet.getString("modelo"),
//                        resultSet.getInt("precio"),
//                        resultSet.getString("descripcion")
//                    );
//                    productos.add(producto);
//                }
//            }
//        }
//        return productos;
//    }
//
//    // Método para eliminar todas las facturas de un cliente por su correo
//    public void eliminarFacturasPorClienteCorreo(String correoCliente) throws SQLException, InvalidoException {
//        // Reutilizamos el método buscarCliente del ClienteRepositorio
//        Cliente cliente = clienteRepositorio.buscarCliente(correoCliente);
//
//        if (cliente == null) {
//            throw new InvalidoException(ErrorTipo.CLIENTE_NO_ENCONTRADO);
//        }
//
//        // Primero eliminar las relaciones de productos
//        String consultaEliminarRelacion = "DELETE FROM factura_producto WHERE cliente_correo = ?";
//        try (Connection conexion = ConfiguracionBaseDatos.getConnection();
//             PreparedStatement statementRelacion = conexion.prepareStatement(consultaEliminarRelacion)) {
//
//            statementRelacion.setString(1, correoCliente);
//            statementRelacion.executeUpdate();
//        }
//
//        // Luego, eliminar las facturas del cliente
//        String consultaEliminarFactura = "DELETE FROM factura WHERE cliente_correo = ?";
//        try (PreparedStatement statementFactura = ConfiguracionBaseDatos.getConnection().prepareStatement(consultaEliminarFactura)) {
//            statementFactura.setString(1, correoCliente);
//            statementFactura.executeUpdate();
//        }
//    }
//
//    // Método para actualizar una factura
//    public void actualizarFactura(Factura factura) throws SQLException, InvalidoException {
//        // Reutilizamos el método buscarCliente del ClienteRepositorio
//        Cliente cliente = clienteRepositorio.buscarCliente(factura.getCliente().getCorreo());
//
//        if (cliente == null) {
//            throw new InvalidoException(ErrorTipo.CLIENTE_NO_ENCONTRADO);
//        }
//
//        String consulta = "UPDATE factura SET fecha = ?, total = ? WHERE cliente_correo = ?";
//        try (Connection conexion = ConfiguracionBaseDatos.getConnection();
//             PreparedStatement statement = conexion.prepareStatement(consulta)) {
//
//            statement.setTimestamp(1, Timestamp.valueOf(factura.getFecha()));
//            statement.setDouble(2, factura.getTotal());
//            statement.setString(3, factura.getCliente().getCorreo()); // Usar correo del cliente
//            statement.executeUpdate();
//        }
//    }
}
