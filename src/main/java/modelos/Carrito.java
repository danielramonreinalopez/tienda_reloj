package modelos;

import java.util.ArrayList;
import java.util.List;

public class Carrito {
    private ArrayList<Producto> carrito;

    public Carrito() {
        carrito = new ArrayList<>();
    }

    public void agregarProducto(Producto producto) {
        carrito.add(producto);
    }

    public Producto buscarProducto(int i) {
        return carrito.get(i);
    }

    public void quitarProducto(Producto producto) {
        carrito.remove(producto);
    }

    public int size() {
        return carrito.size();
    }

    public void vaciarCarrito() {
        carrito.clear();
    }

    public int total() {
        int total = 0;
        for (int i = 0; i < carrito.size(); i++) {
            Producto aux = carrito.get(i);
            total += aux.getPrecio();
        }
        return total;
    }

    public List<Producto> obtenerProductos() {
        return carrito;
    }
}
