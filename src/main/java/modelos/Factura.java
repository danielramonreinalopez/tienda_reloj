package modelos;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

public class Factura {
    private Cliente cliente;
    private List<Producto> productos;
    private LocalDateTime fecha;
    private double total;

    // Constructor que incluye todos los campos excepto el total
    public Factura(Cliente cliente, List<Producto> productos, LocalDateTime fecha) {
        this.cliente = cliente;
        this.productos = productos;
        this.fecha = fecha;
        this.total = calcularTotal(); // Calcula el total automáticamente
    }

    // Método para calcular automáticamente el total sumando los precios de los productos
    private double calcularTotal() {
        return productos.stream()
                .mapToDouble(Producto::getPrecio)
                .sum();
    }

    // Getters y Setters
    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public List<Producto> getProductos() {
        return productos;
    }

    public void setProductos(List<Producto> productos) {
        this.productos = productos;
        this.total = calcularTotal(); // Recalcula el total al cambiar la lista de productos
    }

    public LocalDateTime getFecha() {
        return fecha;
    }

    public void setFecha(LocalDateTime fecha) {
        this.fecha = fecha;
    }

    public double getTotal() {
        return total;
    }

    // Método para formatear la fecha a una cadena
    public String getFechaFormateada() {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss");
        return fecha.format(formatter);
    }

}
