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
            if(cliente.getContrasenia() == contrasenia){
                return cliente;
            }
        }
        
        return null;
    }

    public void registrarCliente(Cliente cliente) throws SQLException, InvalidoException {
        try {
            // Verifica si el correo electrónico ya está registrado
            if (clienteRepositorio.buscarCliente(cliente.getCorreo()) != null) {
                throw new InvalidoException(ErrorTipo.ERROR_CLIENTE_EXISTE);
            }
            clienteRepositorio.guardarCliente(cliente);
        } catch (SQLException e) {
            throw new InvalidoException(ErrorTipo.ERROR_REGISTRO_CLIENTE);
        }
    }
}