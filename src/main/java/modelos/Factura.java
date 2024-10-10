package modelos;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

public class Factura {
    private Cliente cliente;
    private Carrito carrito;
    private Date fecha;
    private double total;


    // Constructor que incluye todos los campos, incluido el id
    public Factura( Date fecha, double total, Cliente cliente, Carrito carrito) {
    	this.fecha = fecha;
        this.total = total;
    	this.cliente = cliente;
        this.carrito = carrito;

    }

    // Método para calcular automáticamente el total sumando los precios de los productos
//    private double calcularTotal() {
//        return productos.stream()
//                .mapToDouble(Producto::getPrecio)
//                .sum();
//    }

    // Getters y Setters
    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public Carrito getCarrito() {
        return carrito;
    }

    public void setCarrito(Carrito carrito) {
        this.carrito = carrito;

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
