package modelos;

public class Producto {
    private int codigo; // Asegúrate de incluir el codigo
    private String marca;
    private String modelo;
    private double precio; // Cambiado a double
    private int cantidad; // Se mantiene cantidad
    private String descripcion;

    // Constructor para crear un Producto con codigo 
    public Producto(int id, String marca, String modelo, double precio, int cantidad, String descripcion) {
        this.codigo = id;
        this.marca = marca;
        this.modelo = modelo;
        this.precio = precio;
        this.cantidad = cantidad;
        this.cantidad = cantidad;
    }
    //  Constructor para crear un producto sin codigo
    public Producto( String marca, String modelo, double precio, int cantidad, String descripcion) {
        this.marca = marca;
        this.modelo = modelo;
        this.precio = precio;
        this.cantidad = cantidad;
        this.descripcion = descripcion;
    }

    // Métodos getters y setters
    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
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
        return codigo + "/ Marca: " + marca + "/ Modelo: " + modelo + "/ Precio: " + precio + "/ Descripción: " + descripcion;
    }

    public String modeloYValor() {
        return codigo + "/ Modelo: " + modelo + "/ Precio: " + precio;
    }

}
