package servicio;

import java.sql.SQLException;

import excepcion.ErrorTipo;
import modelos.Cliente;
import modelos.Carrito;
import repositorio.ClienteRepositorio;
import excepcion.InvalidoException;
import java.util.ArrayList;
import modelos.Producto;
import repositorio.ProductoRepositorio;

public class ServicioCliente {
    private ClienteRepositorio clienteRepositorio;
    private ProductoRepositorio productoRepositorio;
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
    
    //Este metodo es para mostrar los productos en la ventana cliente
    public ArrayList<Producto> obtenerProductos()throws SQLException{
        ArrayList<Producto> productos = productoRepositorio.obtenerProductos();
        return productos;
    }
}