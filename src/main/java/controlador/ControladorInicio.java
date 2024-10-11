/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controlador;

import excepcion.InvalidoException;
import java.sql.SQLException;
import servicio.ServicioCliente;
import servicio.ServicioAdministrador;
import modelos.Cliente;
import modelos.Administrador;

/**
 *
 * @author IVAN
 */
public class ControladorInicio {
    
    ServicioCliente serCliente = new ServicioCliente();
    ServicioAdministrador serAdmi = new ServicioAdministrador();
    
    public int iniciarSesion(String correo, String contraseña)throws SQLException, InvalidoException{
        
        Cliente cliente = serCliente.iniciarSesion(correo, contraseña);
        if(cliente != null){
            return 1;
        }
        
        Administrador adm = serAdmi.iniciarSesion(correo, contraseña);
        if(adm != null){
            return 2;
        }
        
        return 0;
    }
    
}
