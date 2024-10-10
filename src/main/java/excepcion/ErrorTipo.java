package excepcion;

// Definimos el enum para representar diferentes tipos de errores en el sistema
public enum ErrorTipo {
    CLIENTE_NO_ENCONTRADO("Cliente no encontrado en la base de datos."),
    PRODUCTO_NO_DISPONIBLE("El producto solicitado no está disponible."),
    ERROR_CONEXION_BD("Error al conectar con la base de datos."),
    ERROR_VALIDACION("Los datos proporcionados no son válidos."),
    ERROR_GENERAL("Ha ocurrido un error inesperado. Por favor, inténtelo de nuevo."),
    ERROR_INICIO_SESION_CLIENTE("Usuario o contraseña incorrectos, inicio de sesión fallido. Vuelva a intentarlo."),
    ERROR_INICIO_SESION_ADMINISTRADOR("Error de inicio de sesión para el administrador."),
    ERROR_CLIENTE_EXISTE("El cliente ya está registrado en la base de datos."),
    ERROR_CORREO_INVALIDO("El correo electrónico debe contener un '@'."),
    ERROR_REGISTRO_CLIENTE("Error al registrar el cliente."),
    ERROR_ADMINISTRADOR_NO_ENCONTRADO("Administrador no encontrado."),
    CODIGO_INVALIDO("El código proporcionado es inválido."),
    MARCA_INVALIDA("La marca no puede estar vacía."),
    MODELO_INVALIDO("El modelo no puede estar vacío."),
    PRECIO_INVALIDO("El precio debe ser mayor que 0."),
    DESCRIPCION_INVALIDA("La descripción no puede estar vacía.");

    // Atributo para almacenar el mensaje asociado con cada tipo de error
    private final String mensaje;

    // Constructor del Enum que asocia el mensaje a cada tipo de error
    ErrorTipo(String mensaje) {
        this.mensaje = mensaje;
    }

    // Método para obtener el mensaje del error
    public String getMensaje() {
        return mensaje;
    }
}
