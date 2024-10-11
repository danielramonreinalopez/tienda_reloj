package servicio;

//import org.mindrot.jbcrypt.BCrypt; // Importar la librería BCrypt
import org.mindrot.jbcrypt.BCrypt;
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
        productoRepositorio = new ProductoRepositorio();
    }

    // Método para iniciar sesión
    public Cliente iniciarSesion(String correo, String contrasenia) throws SQLException, InvalidoException {
        Cliente cliente = clienteRepositorio.buscarCliente(correo);
        if (cliente == null) {
            throw new InvalidoException(ErrorTipo.ERROR_INICIO_SESION_CLIENTE);
        } else {
            // Verificar la contraseña usando BCrypt
            if (BCrypt.checkpw(contrasenia, cliente.getContrasenia())) {
                return cliente;
            } else {
                throw new InvalidoException(ErrorTipo.ERROR_INICIO_SESION_CLIENTE); // Contraseña incorrecta
            }
        }
    }

    // Método para registrar un nuevo cliente
    public boolean registrarCliente(Cliente cliente) throws SQLException, InvalidoException {
        String correo = cliente.getCorreo();
        Cliente aux = clienteRepositorio.buscarCliente(correo);
        
        if (aux != null) {
            System.out.println("Cliente existente");
            return false;
        } else {
            // Encriptar la contraseña usando BCrypt antes de guardar
            String hashedPassword = BCrypt.hashpw(cliente.getContrasenia(), BCrypt.gensalt(12));
            cliente.setContrasenia(hashedPassword); // Establecer la contraseña hasheada
            
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
