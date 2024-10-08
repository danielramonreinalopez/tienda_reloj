package modelos;

import java.util.Date;
import java.util.List;

public class Factura {
    private int id;
    private Cliente cliente;
    private List<Producto> producto;
    private Date fecha;
    private double total;


    // Constructor que incluye todos los campos, incluido el id
    public Factura( Date fecha, double total,Cliente cliente, List<Producto> producto) {
    	this.fecha = fecha;
        this.total = total;
    	this.cliente = cliente;
        this.producto = producto;
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

    public List<Producto> getProducto() {
        return producto;
    }

    public void setProducto(List<Producto> producto) {
        this.producto = producto;
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
