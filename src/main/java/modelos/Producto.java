package modelos;

public class Producto {
    private int id; // Asegúrate de incluir el id
    private String marca;
    private String modelo;
    private double precio; // Cambiado a double
    private int cantidad; // Se mantiene cantidad
    private String descripcion;

    // Constructor para crear un Producto con id 
    public Producto(int id, String marca, String modelo, double precio, int cantidad, String descripcion) {
        this.id = id;
        this.marca = marca;
        this.modelo = modelo;
        this.precio = precio;
        this.cantidad = cantidad;
        this.cantidad = cantidad;
    }
    //  Constructor para crear un producto sin id
    public Producto( String marca, String modelo, double precio, int cantidad, String descripcion) {
        this.marca = marca;
        this.modelo = modelo;
        this.precio = precio;
        this.cantidad = cantidad;
        this.descripcion = descripcion;
    }

    // Métodos getters y setters
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getMarca() {
        return marca; // Devuelve la marca del producto
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public String getModelo() {
        return modelo; // Devuelve el modelo del producto
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public double getPrecio() {
        return precio; // Cambiado a double
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }
    
    public String getDescripcion() {
		return descripcion;
	}
    
    public void setDescripcion() {
    	this.descripcion = descripcion;
    }

    // Método toString para mostrar información del producto
    @Override
    public String toString() {
        return id + "/ Marca: " + marca + "/ Modelo: " + modelo + "/ Precio: " + precio + "/ Descripción: " + descripcion;
    }

    public String modeloYValor() {
        return id + "/ Modelo: " + modelo + "/ Precio: " + precio;
    }

}
