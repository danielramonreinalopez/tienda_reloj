package servicio;

import java.sql.SQLException;

import excepcion.ErrorTipo;
import modelos.Cliente;
import modelos.Carrito;
import repositorio.ClienteRepositorio;
import excepcion.InvalidoException;

public class ServicioCliente {
    private ClienteRepositorio clienteRepositorio;
    private Carrito carrito;
    

    public ServicioCliente() {
        clienteRepositorio = new ClienteRepositorio();
    }

    public Cliente iniciarSesion(String correo, String contrasenia) throws SQLException, InvalidoException {
        Cliente cliente = clienteRepositorio.buscarCliente(correo);
        if (cliente == null) {
            throw new InvalidoException(ErrorTipo.ERROR_INICIO_SESION_CLIENTE);
        }else{
            if(cliente.getContrasenia().equals( contrasenia)){
                return cliente;
            }
        }
        
        return null;
    }

    public boolean registrarCliente(Cliente cliente) throws SQLException, InvalidoException {
        String correo = cliente.getCorreo();
        Cliente aux = clienteRepositorio.buscarCliente(correo);
        if(aux != null){
            System.out.println("Cliente existente");
            return false;
        }else{
            clienteRepositorio.guardarCliente(cliente);
            return true;
        }
    }
}