package servicio;

import excepcion.InvalidoException;
import java.sql.SQLException;
import modelos.Producto;
import repositorio.ProductoRepositorio;
import validador.ValidarProducto;

public class ServicioProducto {

    private ProductoRepositorio productoRepositorio;

    public ServicioProducto() {
        this.productoRepositorio = new ProductoRepositorio(); // Instancia del repositorio
    }
   
    // Método para agregar un nuevo producto
    public void agregarProducto(Producto producto) {
        try {
            ValidarProducto.validarProductoConExcepciones(producto); // Cambiar a método con excepciones
            productoRepositorio.guardarProducto(producto);
            System.out.println("Producto agregado exitosamente.");
        } catch (InvalidoException e) {
            System.out.println("Error de validación: " + e.getMessage());
        } catch (SQLException e) {
            System.out.println("Error de base de datos: " + e.getMessage());
        }
    }

    // Método para eliminar un producto por modelo
    public void eliminarProducto(String modelo) {
        try {
            productoRepositorio.eliminarProducto(modelo);
            System.out.println("Producto eliminado exitosamente.");
        } catch (SQLException e) {
            System.out.println("Error al eliminar producto: " + e.getMessage());
        }
    }

   // Método para editar un producto existente
    public void editarProducto(Producto producto) {
        try {
            ValidarProducto.validarProductoConExcepciones(producto); // Cambiar a método con excepciones
            productoRepositorio.actualizarProducto(producto);
            System.out.println("Producto actualizado exitosamente.");
        } catch (InvalidoException e) {
            System.out.println("Error de validación: " + e.getMessage());
        } catch (SQLException e) {
            System.out.println("Error de base de datos: " + e.getMessage());
        }
    }

    // Método para buscar un producto por modelo
    public Producto buscarProducto(String modelo) {
        try {
            Producto producto = productoRepositorio.buscarProducto(modelo);
            if (producto != null) {
                System.out.println("Producto encontrado: " + producto);
                return producto;
            } else {
                System.out.println("Producto no encontrado.");
                return null;
            }
        } catch (SQLException e) {
            System.out.println("Error al buscar producto: " + e.getMessage());
            return null;
        }
    }

    // Método para obtener la cantidad total de productos
    public int cantidadProducto() {
        try {
            int total = productoRepositorio.contarProductos();
            System.out.println("Cantidad total de productos: " + total);
            return total;
        } catch (SQLException e) {
            System.out.println("Error al contar los productos: " + e.getMessage());
            return 0;
        }
    }
}
