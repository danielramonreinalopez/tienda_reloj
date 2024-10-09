/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package servicio;

import repositorio.AdministradorRepositorio;
import modelos.Administrador;
import excepcion.ErrorTipo;
import excepcion.InvalidoException;
import java.sql.SQLException;
import modelos.Cliente;
/**
 *
 * @author daniel
 */
public class ServicioAdministrador {
    
    AdministradorRepositorio admRepo;
    
//    public boolean validarSiExiste(String correo, String contraseña){ //throw SQLException {
//        try{
//            Administrador adm = admRepo.buscarAdministrador(correo);
//            if(adm.getCorreo() == correo && adm.getContrasenia() == contraseña){
//                
//            }
//        }catch(SQLException e){
//            System.out.println("No de pudo realizar la coneccion "+ e.getMessage());
//        }
//    }
    
    public Administrador iniciarSesion(String correo, String contrasenia) throws SQLException, InvalidoException {
        Administrador admi = admRepo.buscarAdministrador(correo);
        if (admi == null) {
            throw new InvalidoException(ErrorTipo.ERROR_INICIO_SESION_CLIENTE);
        }else{
            if(admi.getContrasenia() == contrasenia){
                return admi;
            }
        }
        
        return null;
    }
}
