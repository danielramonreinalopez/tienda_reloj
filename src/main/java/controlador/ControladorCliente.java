/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controlador;

import java.sql.SQLException;
import java.util.ArrayList;
import modelos.Producto;
import repositorio.ProductoRepositorio;

/**
 *
 * @author IVAN
 */
public class ControladorCliente {
    
    private ProductoRepositorio productoRepositorio = new ProductoRepositorio();
    
    //Este metodo es para mostrar los productos en la ventana cliente
    public ArrayList<Producto> obtenerProductos()throws SQLException{
        ArrayList<Producto> productos = productoRepositorio.obtenerProductos();
        return productos;
    }
}
