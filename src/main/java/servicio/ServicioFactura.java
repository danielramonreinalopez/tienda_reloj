package servicio;

import excepcion.InvalidoException;
import modelos.Factura;
import repositorio.FacturaRepositorio;
import validador.ValidarFactura;

import java.sql.SQLException;

public class ServicioFactura {

    private FacturaRepositorio facturaRepositorio;

    public ServicioFactura() {
        this.facturaRepositorio = new FacturaRepositorio(); // Instancia del repositorio
    }

    // Método para agregar una nueva factura
    public void agregarFactura(Factura factura) {
        try {
            // Validar la factura antes de agregarla
            ValidarFactura.validarFactura(factura);
            facturaRepositorio.guardarFactura(factura);
            System.out.println("Factura agregada exitosamente.");
        } catch (InvalidoException e) {
            System.out.println("Error de validación: " + e.getMessage());
        } catch (SQLException e) {
            System.out.println("Error de base de datos: " + e.getMessage());
        }
    }

    // Método para editar una factura existente
    public void editarFactura(Factura factura) {
        try {
            // Validar la factura antes de editarla
            ValidarFactura.validarFactura(factura);
            facturaRepositorio.actualizarFactura(factura);
            System.out.println("Factura actualizada exitosamente.");
        } catch (InvalidoException e) {
            System.out.println("Error de validación: " + e.getMessage());
        } catch (SQLException e) {
            System.out.println("Error de base de datos: " + e.getMessage());
        }
    }

    // Método para buscar una factura por el ID
    public Factura buscarFactura(int idFactura) {
        try {
            Factura factura = facturaRepositorio.buscarFacturas(idFactura);
            if (factura != null) {
                System.out.println("Factura encontrada: " + factura);
                return factura;
            } else {
                System.out.println("Factura no encontrada.");
                return null;
            }
        } catch (SQLException e) {
            System.out.println("Error al buscar la factura: " + e.getMessage());
            return null;
        }
    }

    // Método para eliminar una factura por ID
    public void eliminarFactura(int idFactura) {
        try {
            facturaRepositorio.eliminarFactura(idFactura);
            System.out.println("Factura eliminada exitosamente.");
        } catch (SQLException e) {
            System.out.println("Error al eliminar la factura: " + e.getMessage());
        }
    }
}
