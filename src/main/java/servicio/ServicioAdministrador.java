/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package servicio;

import repositorio.AdministradorRepositorio;
import repositorio.ProductoRepositorio;
import modelos.Administrador;
import excepcion.ErrorTipo;
import excepcion.InvalidoException;
import java.sql.SQLException;
import java.util.ArrayList;
import modelos.Cliente;
import modelos.Producto;
/**
 *
 * @author daniel
 */
public class ServicioAdministrador {
    
    AdministradorRepositorio admRepositorio = new AdministradorRepositorio();
    ProductoRepositorio prodRepositorio = new ProductoRepositorio();
    
    public boolean validarSiExiste(String correo, String contrasenia){ //throw SQLException {
        try{
            Administrador adm = admRepositorio.buscarAdministrador(correo, contrasenia);
            if(adm.getCorreo() == correo && adm.getContrasenia() == contrasenia){
                return true;
            }
            return false;
        }catch(SQLException e){
            System.out.println("No de pudo realizar la coneccion "+ e.getMessage());
        }
        return false;
    }
    
    public Administrador iniciarSesion(String correo, String contrasenia) throws SQLException, InvalidoException {
        Administrador admi = admRepositorio.buscarAdministrador(correo, contrasenia);
        if (admi != null) {
            return admi;
        }else{
//            throw new InvalidoException(ErrorTipo.ERROR_INICIO_SESION_CLIENTE);
        
            return null;
        }
    }
    
    //Este metodo es para mostrar los productos en la ventana cliente
    public ArrayList<Producto> obtenerProductos()throws SQLException{
        ArrayList<Producto> productos = prodRepositorio.obtenerProductos();
        return productos;
    }
}
