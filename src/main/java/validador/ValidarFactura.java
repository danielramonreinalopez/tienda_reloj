package validador;

import excepcion.ErrorTipo;
import excepcion.InvalidoException;
import java.time.LocalDateTime;
import java.util.List;

import modelos.Cliente;
import modelos.Factura;
import modelos.Producto;

public class ValidarFactura {

    public static void validarCliente(Cliente cliente) throws InvalidoException {
        if (cliente == null || !ValidarCliente.validarCliente(cliente)) {
            throw new InvalidoException(ErrorTipo.CLIENTE_NO_ENCONTRADO);
        }
    }

    public static void validarProductos(List<Producto> productos) throws InvalidoException {
        if (productos == null || productos.isEmpty()) {
            throw new InvalidoException(ErrorTipo.PRODUCTO_NO_DISPONIBLE);
        }
        for (Producto producto : productos) {
            if (!ValidarProducto.validarProducto(producto)) {
                throw new InvalidoException(ErrorTipo.ERROR_VALIDACION);
            }
        }
    }

    public static void validarFecha(LocalDateTime fecha) throws InvalidoException {
        if (fecha == null || fecha.isAfter(LocalDateTime.now())) {
            throw new InvalidoException(ErrorTipo.ERROR_VALIDACION);
        }
    }

    public static void validarTotal(double total) throws InvalidoException {
        if (total < 0) {
            throw new InvalidoException(ErrorTipo.PRECIO_INVALIDO);
        }
    }

//    public static void validarFactura(Factura factura) throws InvalidoException {
//        if (factura == null) {
//            throw new InvalidoException(ErrorTipo.ERROR_GENERAL);
//        }
//        validarCliente(factura.getCliente());
//        validarProductos(factura.getProductos());
//        validarFecha(factura.getFecha());
//        validarTotal(factura.getTotal());
//    }
}
