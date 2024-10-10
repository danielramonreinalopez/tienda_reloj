package modelos;

import java.util.Date;
import java.util.List;

public class Factura {
    private int id;
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

   

    // Getters y Setters
   /* public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
*/
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

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public double getTotal() {
        return total;
    }

    public void setTotal(double total) {
        this.total = total;
    }
}
