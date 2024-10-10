/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controlador;

import excepcion.InvalidoException;
import java.sql.SQLException;
import modelos.Cliente;
import servicio.ServicioCliente;
/**
 *
 * @author IVAN
 */
public class ControladorRegistro {
    
    ServicioCliente servicio = new ServicioCliente();
    
    public void registrarCliente(Cliente cliente) throws SQLException, InvalidoException {
        servicio.registrarCliente(cliente);
    }
}
