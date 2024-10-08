package modelos;

public class Administrador extends Usuario{
	
	private String rol;
	
	public Administrador(String rol, String nombre, String apellido, int numcelular,  String correo, String contrasenia) {
		super(nombre, apellido, numcelular, correo, contrasenia);
		this.rol = rol;
	}

	public String getRol() {
        return rol;
    }
    
    public void setRol(String rol) {
    	 this.rol = rol; 
    } 
}
