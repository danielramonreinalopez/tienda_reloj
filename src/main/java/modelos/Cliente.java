package modelos;

public class Cliente extends Usuario {
    
    private String direccion;
    
    public Cliente(String direccion, String nombre, String apellido, int numcelular, String correo, String contrasenia) {
    	super(nombre, apellido, numcelular, correo, contrasenia);
    	this.direccion = direccion;
    }
    
    public String getDireccion() {
        return direccion;
    }
    
    public void setDireccion(String direccion) {
    	 this.direccion = direccion; 
    } 
}