package modelos;

public class Producto {
    private int codigo;
    private String marca;
    private String modelo;
    private int precio; // Cambiado a double // Se mantiene cantidad
    private String descripcion;

    // Constructor para crear un Producto con codigo 
    public Producto(int id, String marca, String modelo, int precio, String descripcion) {
        this.codigo = id;
        this.marca = marca;
        this.modelo = modelo;
        this.precio = precio;
        this.descripcion = descripcion;
    }

    //  Constructor para crear un producto sin codigo
    public Producto( String marca, String modelo, int precio, String descripcion) {
        this.marca = marca;
        this.modelo = modelo;
        this.precio = precio;
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
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }


    public int getPrecio() {
        return precio; // Cambiado a double
    }

    public void setPrecio(int precio) {
        this.precio = precio;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    // usamos un metodo toString para mostrar información del producto
    @Override
    public String toString() {
        return codigo + "/ Marca: " + marca + "/ Modelo: " + modelo + "/ Precio: " + precio + "/ Descripción: " + descripcion;
    }

    public String modeloYValor() {
        return codigo + "/ Modelo: " + modelo + "/ Precio: " + precio;
    }
}
