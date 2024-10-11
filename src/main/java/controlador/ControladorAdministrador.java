/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controlador;

import java.sql.SQLException;
import java.util.ArrayList;
import modelos.Producto;
import servicio.ServicioAdministrador;
import servicio.ServicioProducto;

/**
 *
 * @author IVAN
 */
public class ControladorAdministrador {
    
    private ArrayList<Producto> productos;
    private ServicioAdministrador serAdministrador = new ServicioAdministrador();
    private ServicioProducto serProducto = new ServicioProducto();
    
    //Este metodo es para mostrar los productos en la ventana cliente
    public ArrayList<Producto> obtenerProductos()throws SQLException{
        ArrayList<Producto> productos = serAdministrador.obtenerProductos();//Verificar que siga el modelo
        return productos;
    }
    
    public boolean agregarProducto(Producto producto){
        boolean aux = serProducto.agregarProducto(producto);
        if(aux){
            return true;
        }
        return false;
    }
    
    public boolean editarProducto(Producto producto) {
        boolean aux = serProducto.editarProducto(producto);
        if(aux){
            return true;
        }
        return false;
    }
    
    public Producto buscarProducto(String modelo) {
        Producto aux = serProducto.buscarProducto(modelo);
        return aux;
    }
    
    public boolean eliminarProducto(String modelo) {
        boolean aux = serProducto.eliminarProducto(modelo);
        return aux;
    }
}
