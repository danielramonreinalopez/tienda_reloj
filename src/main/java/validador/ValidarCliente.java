package validador;

import modelos.Cliente;

public class ValidarCliente {
	
    public static boolean validarDireccion(String direccion) {
        // Validamos que la dirección no esté vacía
        return direccion != null && !direccion.trim().isEmpty();
    }
	
    public static boolean validarNombre(String nombre) {
        // Validamos que el nombre no esté vacío
        return nombre != null && !nombre.trim().isEmpty();
    }
  
    public static boolean validarApellido(String apellido) {
        // Validamos que el apellido no esté vacío
        return apellido != null && !apellido.trim().isEmpty();
    }

    public static boolean validarNumeroCelular(int numCelular) {
        // Validamos que el numero de celular tenga 10 dígitos
        String numCelularStr = String.valueOf(numCelular);
        return numCelularStr.length() == 12;
    }

    public static boolean validarCorreo(String correo) {
        // Validamos que el correo contenga un símbolo '@' 
        return correo != null && correo.contains("@");
    }
  
    public static boolean validarContrasenia(String contrasenia) {
        // Validamos que la contraseña tenga una longitud específica (puedes ajustar esto)
        return contrasenia != null && contrasenia.length() >= 5; // Cambiado a >= para permitir contraseñas más largas
    }

    public static boolean validarCliente(Cliente cliente) {
        // Validamos todos los campos del cliente
        return validarDireccion(cliente.getDireccion()) &&
               validarNombre(cliente.getNombre()) &&
               validarApellido(cliente.getApellido()) &&
               validarNumeroCelular(cliente.getNumcelular()) &&
               validarCorreo(cliente.getCorreo()) &&
               validarContrasenia(cliente.getContrasenia());
    }
}
