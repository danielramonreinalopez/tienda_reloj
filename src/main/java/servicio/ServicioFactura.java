package servicio;

import excepcion.InvalidoException;
import modelos.Factura;
import repositorio.FacturaRepositorio;
import validador.ValidarFactura;
import java.sql.SQLException;

public class ServicioFactura {

//    private final FacturaRepositorio facturaRepositorio;
//
//    // Constructor que inyecta el repositorio de facturas
//    public ServicioFactura(FacturaRepositorio facturaRepositorio) {
//        this.facturaRepositorio = facturaRepositorio;
//    }
//
//    // Método para agregar una nueva factura
//    public void agregarFactura(Factura factura) {
//        try {
//            // Validar la factura antes de agregarla
//            ValidarFactura.validarFactura(factura);
//            facturaRepositorio.guardarFactura(factura);
//            System.out.println("Factura agregada exitosamente.");
//        } catch (InvalidoException e) {
//            System.out.println("Error de validación: " + e.getMessage());
//        } catch (SQLException e) {
//            System.out.println("Error de base de datos: " + e.getMessage());
//        }
//    }
//
//    // Método para editar una factura existente
//    public void editarFactura(Factura factura) {
//        try {
//            // Validar la factura antes de editarla
//            ValidarFactura.validarFactura(factura);
//            facturaRepositorio.actualizarFactura(factura);
//            System.out.println("Factura actualizada exitosamente.");
//        } catch (InvalidoException e) {
//            System.out.println("Error de validación: " + e.getMessage());
//        } catch (SQLException e) {
//            System.out.println("Error de base de datos: " + e.getMessage());
//        }
//    }
//
//    // Método para buscar facturas por correo del cliente
//    public void buscarFacturasPorCliente(String correoCliente) {
//        try {
//            var facturas = facturaRepositorio.buscarFacturasPorCliente(correoCliente);
//            if (!facturas.isEmpty()) {
//                System.out.println("Facturas encontradas para el cliente " + correoCliente + ":");
//                facturas.forEach(System.out::println);
//            } else {
//                System.out.println("No se encontraron facturas para el cliente con correo: " + correoCliente);
//            }
//        } catch (SQLException | InvalidoException e) {
//            System.out.println("Error al buscar las facturas: " + e.getMessage());
//        }
//    }
//
//    // Método para eliminar todas las facturas de un cliente por su correo
//    public void eliminarFacturasPorClienteCorreo(String correoCliente) {
//        try {
//            facturaRepositorio.eliminarFacturasPorClienteCorreo(correoCliente);
//            System.out.println("Facturas eliminadas exitosamente para el cliente con correo: " + correoCliente);
//        } catch (SQLException | InvalidoException e) {
//            System.out.println("Error al eliminar las facturas: " + e.getMessage());
//        }
//    }
}
