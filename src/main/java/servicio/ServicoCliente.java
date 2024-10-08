package servicio;

import java.sql.SQLException;

import excepcion.ErrorTipo;
import modelos.Cliente;
import modelos.Carrito;
import repositorio.ClienteRepositorio;
import excepcion.InvalidoException;

public class ServicoCliente {
    private ClienteRepositorio clienteRepositorio;
    private Carrito carrito;

    public ServicoCliente() {
        clienteRepositorio = new ClienteRepositorio();
    }

    public Cliente iniciarSesion(String correo, String contrasenia) throws SQLException, InvalidoException {
        Cliente cliente = clienteRepositorio.iniciarSesion(correo, contrasenia);
        if (cliente == null) {
            throw new InvalidoException(ErrorTipo.ERROR_INICIO_SESION_CLIENTE);
        }
        return cliente;
    }

    public void registrarCliente(Cliente cliente) throws SQLException, InvalidoException {
        try {
            // Verifica si el correo electrónico ya está registrado
            if (clienteRepositorio.encontrarClientePorCorreo(cliente.getCorreo()) != null) {
                throw new InvalidoException(ErrorTipo.ERROR_CLIENTE_EXISTE);
            }
            clienteRepositorio.guardarCliente(cliente);
        } catch (SQLException e) {
            throw new InvalidoException(ErrorTipo.ERROR_REGISTRO_CLIENTE);
        }
    }
}