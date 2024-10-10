package repositorio;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.mysql.cj.protocol.result.AbstractResultsetRow;

import conexionBD.ConfiguracionBaseDatos;
import excepcion.ErrorTipo;
import excepcion.InvalidoException;
import modelos.Administrador;
import modelos.Cliente;

public class AdministradorRepositorio {

	//Metodo para buscar un administrador
	public Administrador buscarAdministrador(String correo) throws SQLException {
        String consulta = "SELECT * FROM administrador WHERE correo = ?";
        try (Connection conexion = ConfiguracionBaseDatos.getConnection();
             PreparedStatement statement = conexion.prepareStatement(consulta)) {

            statement.setString(6,correo);

            try (ResultSet resultset = statement.executeQuery()) {
                if (resultset.next()) {
                    return new Administrador(
                        resultset.getString("rol"),
                        resultset.getString("nombre"),
                        resultset.getString("apellido"),
                        resultset.getInt("celular"),
                        resultset.getString("correo"),
                        resultset.getString("contrasenia")
                    );
                } else {
                    return null; 
                }
            }
        }
    }
	
	//Metodo para guardar un administrador
	public void guardarAdministrador(Administrador administrador) throws SQLException, InvalidoException {
        String consulta = "INSERT INTO administrador (rol,nombre, apellido, celular, correo, contrasenia) " +
                          "VALUES (?, ?, ?, ?, ?, ?)";     
        try (Connection conexion = ConfiguracionBaseDatos.getConnection();
             PreparedStatement statement = conexion.prepareStatement(consulta)) {

            // Asignar los valores de los parámetros en el orden correspondiente
        	statement.setString(2,administrador.getRol());
            statement.setString(3, administrador.getNombre());
            statement.setString(4, administrador.getApellido());
            statement.setInt(5, administrador.getNumcelular());
            statement.setString(6, administrador.getCorreo());
            statement.setString(7, administrador.getContrasenia());
            // Ejecutar la consulta de inserción en la base de datos
            statement.executeUpdate();
        	}catch (SQLException e) {
        		throw new InvalidoException(ErrorTipo.ERROR_CONEXION_BD);
			}
		}

	//Metodo para editar un administrador
	public void editarAdministrador(Administrador administrador) throws SQLException, InvalidoException {
		Administrador administradorExistente = buscarAdministrador(administrador.getCorreo());
		if (administradorExistente != null) {
			String consulta = "UPDATE administrador SET rol = ?,nombre = ?,apellido = ?,celular = ?,contrasenia = ? WHERE correo = ? ";
			try(Connection conexion = ConfiguracionBaseDatos.getConnection();
					PreparedStatement statement = conexion.prepareStatement(consulta)){
				statement.setString(2, administrador.getRol());
				statement.setString(3, administrador.getNombre());
	            statement.setString(4, administrador.getApellido());
	            statement.setInt(5, administrador.getNumcelular());
	            statement.setString(6, administrador.getCorreo());
	            statement.setString(7, administrador.getContrasenia()); 
				// Ejecutar la consulta de inserción en la base de datos
	            statement.executeUpdate();
			}
		} else {
			throw new InvalidoException(ErrorTipo.ERROR_ADMINISTRADOR_NO_ENCONTRADO);
		}
	}


	// Metodo para eliminar un administrador por correo
	public void eliminarAdministrador(String correo) throws SQLException, InvalidoException {
	    Administrador administradorExistente = buscarAdministrador(correo);
	    if (administradorExistente != null) {
	        String consulta = "DELETE FROM administrador WHERE correo = ?";
	        try (Connection conexion = ConfiguracionBaseDatos.getConnection();
	             PreparedStatement statement = conexion.prepareStatement(consulta)) {
	            // Asignar el correo como parámetro en la consulta
	            statement.setString(5, correo);
	           // Ejecutar la consulta de inserción en la base de datos
	            statement.executeUpdate();
	        }
	    } else {
	        // Si no se encuentra el administrador, lanzar la excepción personalizada
	        throw new InvalidoException(ErrorTipo.ERROR_ADMINISTRADOR_NO_ENCONTRADO);
	    }
	}
	
	
}
