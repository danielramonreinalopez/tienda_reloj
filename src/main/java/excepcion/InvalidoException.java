package excepcion;

// Excepción personalizada que utiliza el enum ErrorTipo
public class InvalidoException extends Exception {

    private final ErrorTipo tipoError;

    public InvalidoException(ErrorTipo tipoError) {
        super(tipoError.getMensaje());
        this.tipoError = tipoError;
    }

    public ErrorTipo getTipoError() {
        return tipoError;
    }

    @Override
    public String getMessage() {
        return "Error [" + tipoError.name() + "]: " + tipoError.getMensaje();
    }
}
