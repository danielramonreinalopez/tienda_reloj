package modelos;

public class Usuario {
	
	private String nombre;
	private String apellido;
	private int numcelular;
	private String correo;
	private String contrasenia;
	
	
	public Usuario(String nombre, String apellido, int numcelular,String correo, String contrasenia) {
		this.nombre = nombre;
		this.apellido = apellido;
		this.numcelular = numcelular;
		this.correo = correo;
		this.contrasenia = contrasenia;
		
	}
	

	
	public String getApellido() {
		return apellido;
	}
	
	public String getCorreo() {
		return correo;
	}
	
	public String getNombre() {
		return nombre;
	}
	
	public int getNumcelular() {
		return numcelular;
	}
	
	public String getContrasenia() {
		return contrasenia;
	}
	
	public void setApellido(String apellido) {
		this.apellido = apellido;
	}
	
	public void setCorreo(String correo) {
		this.correo = correo;
	}
	
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	
	public void setNumcelular(int numcelular) {
		this.numcelular = numcelular;
	}   
	
	public void setContrasenia(String contrasenia) {
		this.contrasenia = contrasenia;
	}
	
	

}
