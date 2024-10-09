package validador;

import java.sql.Date;
import java.util.List;

import modelos.Cliente;
import modelos.Factura;
import modelos.Producto;

public class ValidarFactura {
	

    public static boolean validarId(int id) {
        // Validamos que el id sea mayor a 0
        return id > 0;
    }

    public static boolean validarCliente(Cliente cliente) {
        // Validamos que el cliente no sea nulo y sus campos sean válidos
        return cliente != null && ValidarCliente.validarCliente(cliente);
    }

    public static boolean validarProductos(List<Producto> productos) {
        // Validamos que la lista de productos no esté vacía y todos los productos sean válidos
        if (productos == null || productos.isEmpty()) {
            return false;
        }
        for (Producto producto : productos) {
            if (!ValidarProducto.validarProducto(producto)) {
                return false;
            }
        }
        return true;
    }

    public static boolean validarFecha(java.util.Date date) {
        // Validamos que la fecha no sea nula y sea una fecha válida (en el pasado o presente)
        return date != null && date.before(new Date(0)) || date.equals(new Date(0));
    }

    public static boolean validarTotal(double total) {
        // Validamos que el total sea mayor o igual a 0
        return total >= 0;
    }

//    public static boolean validarFactura(Factura factura) {
//        // Validamos todos los campos de la factura
//        return validarId(factura.getId()) &&
//               validarCliente(factura.getCliente()) &&
//               validarProductos(factura.getProducto()) &&
//               validarFecha(factura.getFecha()) &&
//               validarTotal(factura.getTotal());
//    }

}
