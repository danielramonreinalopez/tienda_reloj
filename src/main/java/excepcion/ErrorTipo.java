package excepcion;


//Definimos el enum para representar diferentes tipos de errores en el sistema
public enum ErrorTipo {
 CLIENTE_NO_ENCONTRADO("Cliente no encontrado en la base de datos."),
 PRODUCTO_NO_DISPONIBLE("Producto no disponible ."),
 ERROR_CONEXION_BD("Error al conectar con la base de datos."),
 ERROR_VALIDACION("Los datos proporcionados no son válidos."),
 ERROR_GENERAL("Ha ocurrido un error inesperado."),
 ERROR_INICIO_SESION_CLIENTE("Usuario o Contraseña incorrectas, inicio de sesión fallido vuelva a intentar ."),
 ERROR_INICIO_SESION_ADMINISTRADOR("Error de inicio de sesión para el administrador."),
 ERROR_CLIENTE_EXISTE("El cliente ya está registrado en la base de datos."),
 ERROR_CORREO_INVALIDO("El correo electrónico debe contener un '@'."),
 ERROR_REGISTRO_CLIENTE("Error al registrar el cliente."),
 ERROR_ADMINISTRADOR_NO_ECONTRADO("Administrador no encontrado");
 // usamos un atributo para almacenar el mensaje asociado con cada tipo de error
 private final String mensaje;

 // Creamos el Constructor del Enum que asocia el mensaje a cada tipo de error
 ErrorTipo(String mensaje) {
     this.mensaje = mensaje;
 }

 // Método para obtener el mensaje del error
 public String getMensaje() {
     return mensaje;
 }
}
