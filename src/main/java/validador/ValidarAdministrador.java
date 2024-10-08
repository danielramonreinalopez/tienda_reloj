package validador;

import modelos.Administrador;

public class ValidarAdministrador {
	
	 public static boolean validarRol(String rol) {
	        // Validamos que el rol no esté vacío
	        return rol != null && !rol.trim().isEmpty();
	    }

	    public static boolean validarNombre(String nombre) {
	        // Validamos que el nombre no esté vacío
	        return nombre != null && !nombre.trim().isEmpty();
	    }
	  
	    public static boolean validarApellido(String apellido) {
	        // Validamom njnjjmnnhs que el apellido no esté vacío
	        return apellido != null && !apellido.trim().isEmpty();
	    }

	    public static boolean validarNumeroCelular(int numCelular) {
	        // Validamos que el numero de celular tenga 10 dígitos
	        String numCelularStr = String.valueOf(numCelular);
	        return numCelularStr.length() == 10;
	    }

	    public static boolean validarCorreo(String correo) {
	        // Validamos que el correo contenga un símbolo '@' 
	        return correo != null && correo.contains("@");
	    }

	    public static boolean validarContrasenia(String contrasenia) {
	        // Validamos que la contraseña tenga una longitud específica
	        return contrasenia != null && contrasenia.length() >= 5; 
	    }

	    public static boolean validarAdministrador(Administrador administrador) {
	        // Validamos todos los campos del administrador
	        return validarRol(administrador.getRol()) &&
	               validarNombre(administrador.getNombre()) &&
	               validarApellido(administrador.getApellido()) &&
	               validarNumeroCelular(administrador.getNumcelular()) &&
	               validarCorreo(administrador.getCorreo()) &&
	               validarContrasenia(administrador.getContrasenia());
	    }

}
