package repositorio;

import conexionBD.ConfiguracionBaseDatos;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import modelos.Producto;

public class ProductoRepositorio {


	// Método para buscar un producto por modelo
	public Producto buscarProducto(String modelo) throws SQLException {
	    String consulta = "SELECT * FROM producto WHERE modelo = ?";
	    try (Connection conexion = ConfiguracionBaseDatos.getConnection();
	         PreparedStatement statement = conexion.prepareStatement(consulta)) {
	         
	        statement.setString(1, modelo);
	        try (ResultSet resultSet = statement.executeQuery()) {
	            if (resultSet.next()) {
	                return new Producto(
                                
                                
	                    resultSet.getString("marca"),
	                    resultSet.getString("modelo"),
	                    resultSet.getInt("precio"),
	                    resultSet.getString("descripcion")
	                );
	            } else {
	                return null;
	            }
	        }
	    }
	}
        
        
    


	// Método para guardar un nuevo producto
	public void guardarProducto(Producto producto) throws SQLException {
	    String consulta = "INSERT INTO producto (marca, modelo, precio, descripcion) VALUES (?, ?, ?, ?)";
	    try (Connection conexion = ConfiguracionBaseDatos.getConnection();
	         PreparedStatement statement = conexion.prepareStatement(consulta)) {
	         
	        statement.setString(1, producto.getMarca());
	        statement.setString(2, producto.getModelo());
	        statement.setDouble(3, producto.getPrecio());
	        statement.setString(4, producto.getDescripcion());
	        statement.executeUpdate();
	    }
	}

	// Método para actualizar un producto existente
	public boolean actualizarProducto(Producto producto) throws SQLException {
	    String consulta = "UPDATE producto SET WHERE marca = ?, modelo = ?, precio = ?, descripcion = ? ";
	    try (Connection conexion = ConfiguracionBaseDatos.getConnection();
	         PreparedStatement statement = conexion.prepareStatement(consulta)) {
	         
	        statement.setString(1, producto.getMarca());
	        statement.setString(2, producto.getModelo());
	        statement.setDouble(3, producto.getPrecio());
	        statement.setString(4, producto.getDescripcion());
	        
	        statement.executeUpdate();
                return true;
	    }
	}


	// Método para eliminar un producto por ID
	public void eliminarProducto(String modelo) throws SQLException {
	    String consulta = "DELETE FROM producto WHERE modelo = ?";
	    try (Connection conexion = ConfiguracionBaseDatos.getConnection();
	         PreparedStatement statement = conexion.prepareStatement(consulta)) {
	         
	        statement.setString(1, modelo);
	        statement.executeUpdate();
	    }
	}
        
        public ArrayList<Producto> obtenerProductos() throws SQLException{
            String consulta = "SELECT * FROM producto";
            ArrayList<Producto> productos = new ArrayList<>();
	    try (Connection conexion = ConfiguracionBaseDatos.getConnection();
	         PreparedStatement statement = conexion.prepareStatement(consulta)) {
	         
	        try (ResultSet resultSet = statement.executeQuery()) {
                    int contador = 1;
	            while (resultSet.next()) {
	                Producto producto = new Producto(
                                contador++,
	                    resultSet.getString("marca"),
	                    resultSet.getString("modelo"),
	                    resultSet.getInt("precio"),
	                    resultSet.getString("descripcion")
	                );
                        productos.add(producto);
	            }
	        }
                return productos;
	    }
        }
        
        

}
