package validador;

import modelos.Producto;

public class ValidarProducto {
	
	public static boolean validarId(int id) {
        // Validamos que el id sea mayor a 0
        return id > 0;
    }

    public static boolean validarMarca(String marca) {
        // Validamos que la marca no esté vacía
        return marca != null && !marca.trim().isEmpty();
    }

    public static boolean validarModelo(String modelo) {
        // Validamos que el modelo no esté vacío
        return modelo != null && !modelo.trim().isEmpty();
    }

    public static boolean validarPrecio(double precio) {
        // Validamos que el precio sea mayor a 0
        return precio > 0;
    }

    public static boolean validarCantidad(int cantidad) {
        // Validamos que la cantidad sea mayor o igual a 0 (permitimos stock 0)
        return cantidad >= 0;
    }

    public static boolean validarDescripcion(String descripcion) {
        // Validamos que la descripción no esté vacía
        return descripcion != null && !descripcion.trim().isEmpty();
    }

    public static boolean validarProducto(Producto producto) {
        // Validamos todos los campos del producto
        return validarId(producto.getId()) &&
               validarMarca(producto.getMarca()) &&
               validarModelo(producto.getModelo()) &&
               validarPrecio(producto.getPrecio()) &&
               validarCantidad(producto.getCantidad()) &&
               validarDescripcion(producto.getDescripcion());
    }

}
