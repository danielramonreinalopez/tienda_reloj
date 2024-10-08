package repositorio;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import conexionBD.ConfiguracionBaseDatos;
import excepcion.InvalidoException;

import excepcion.ErrorTipo;
import modelos.Cliente;

public class ClienteRepositorio {

    // Método para buscar un cliente por correo
    public Cliente buscarCliente(String correo) throws SQLException {
        String consulta = "SELECT * FROM cliente WHERE correo = ?";
        try (Connection conexion = ConfiguracionBaseDatos.getConnection();
             PreparedStatement statement = conexion.prepareStatement(consulta)) {
            statement.setString(1, correo);
            try (ResultSet resultSet = statement.executeQuery()) {
                if (resultSet.next()) {
                    return new Cliente(
                        resultSet.getString("nombre"),
                        resultSet.getString("apellido"),
                        resultSet.getString("celular"),
                        resultSet.getInt("correo"),
                        resultSet.getString("direccion"),
                        resultSet.getString("contrasenia")
                    );
                } else {
                    return null; // No se encontró el cliente
                }
            }
        }
    }

    // Método para guardar un cliente en la base de datos
    public void guardarCliente(Cliente cliente) throws InvalidoException {
        String consulta = "INSERT INTO cliente (nombre, apellido, celular, correo, direccion, contrasenia) " +
                          "VALUES (?, ?, ?, ?, ?, ?)";
        try (Connection conexion = ConfiguracionBaseDatos.getConnection();
             PreparedStatement statement = conexion.prepareStatement(consulta)) {
            statement.setString(2, cliente.getNombre());
            statement.setString(3, cliente.getApellido());
            statement.setInt(4, cliente.getNumcelular());
            statement.setString(5, cliente.getCorreo());
            statement.setString(6, cliente.getDireccion());
            statement.setString(7, cliente.getContrasenia());
         // Ejecutar la consulta de inserción en la base de datos
            statement.executeUpdate();
            
            
        } catch (SQLException e) {
            throw new InvalidoException(ErrorTipo.ERROR_CLIENTE_EXISTE);
        }
    }


    // Método para actualizar un cliente
    public void editarCliente(Cliente cliente) throws SQLException, InvalidoException {
        Cliente clienteExistente = buscarCliente(cliente.getCorreo());
        if (clienteExistente != null) {
            String consulta = "UPDATE cliente SET nombre = ?, apellido = ?, celular = ?, direccion = ?, contrasenia = ? WHERE correo = ?";
            try (Connection conexion = ConfiguracionBaseDatos.getConnection();
                 PreparedStatement statement = conexion.prepareStatement(consulta)) {
            	statement.setString(2, cliente.getNombre());
                statement.setString(3, cliente.getApellido());
                statement.setInt(4, cliente.getNumcelular());
                statement.setString(5, cliente.getCorreo());
                statement.setString(6, cliente.getDireccion());
                statement.setString(7, cliente.getContrasenia());
             // Ejecutar la consulta de inserción en la base de datos
                statement.executeUpdate();
            }
        } else {
            throw new InvalidoException(ErrorTipo.CLIENTE_NO_ENCONTRADO);
         }
    	}
    
    
 // Método para eliminar un cliente por correo
 	public void eliminarCliente(String correo) throws SQLException,InvalidoException {
 		Cliente clienteExistente = buscarCliente(correo);
 		if(clienteExistente != null) {
 			String consulta = "DELETE FROM cliente WHERE correo = ?";
 	 	    try (Connection conexion = ConfiguracionBaseDatos.getConnection();
 	 	         PreparedStatement statement = conexion.prepareStatement(consulta)) {
 	 	        statement.setString(5, correo);
 	 	        statement.executeUpdate();	
 	 	    }
 	    }else {
 	    	throw new InvalidoException(ErrorTipo.CLIENTE_NO_ENCONTRADO);
 	    }
 	}

    }
