package validador;

import excepcion.ErrorTipo;
import excepcion.InvalidoException;
import modelos.Producto;

public class ValidarProducto {

    // Validar el código del producto
    public static void validarCodigo(int codigo) throws InvalidoException {
        if (codigo <= 0) {
            throw new InvalidoException(ErrorTipo.CODIGO_INVALIDO);
        }
    }

    // Validar la marca del producto
    public static void validarMarca(String marca) throws InvalidoException {
        if (marca == null || marca.isBlank()) {
            throw new InvalidoException(ErrorTipo.MARCA_INVALIDA);
        }
    }

    // Validar el modelo del producto
    public static void validarModelo(String modelo) throws InvalidoException {
        if (modelo == null || modelo.isBlank()) {
            throw new InvalidoException(ErrorTipo.MODELO_INVALIDO);
        }
    }

    // Validar el precio del producto
    public static void validarPrecio(double precio) throws InvalidoException {
        if (precio <= 0) {
            throw new InvalidoException(ErrorTipo.PRECIO_INVALIDO);
        }
    }

    // Validar la descripción del producto
    public static void validarDescripcion(String descripcion) throws InvalidoException {
        if (descripcion == null || descripcion.isBlank()) {
            throw new InvalidoException(ErrorTipo.DESCRIPCION_INVALIDA);
        }
    }

    // Validar todos los campos del producto lanzando excepciones
    public static void validarProductoConExcepciones(Producto producto) throws InvalidoException {
        validarCodigo(producto.getCodigo());
        validarMarca(producto.getMarca());
        validarModelo(producto.getModelo());
        validarPrecio(producto.getPrecio());
        validarDescripcion(producto.getDescripcion());
    }

    // Método que valida un producto y devuelve true o false (versión booleana)
    public static boolean validarProducto(Producto producto) {
        // Verificar que el producto no sea nulo y sus atributos sean válidos
        if (producto == null) return false;
        
        return producto.getCodigo() > 0 &&
               producto.getMarca() != null && !producto.getMarca().isBlank() &&
               producto.getModelo() != null && !producto.getModelo().isBlank() &&
               producto.getPrecio() > 0 &&
               producto.getDescripcion() != null && !producto.getDescripcion().isBlank();
    }
}
