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
                                
                            resultSet.getInt("id"),    
	                    resultSet.getString("marca"),
	                    resultSet.getString("modelo"),
	                    resultSet.getInt("precio"),
	                    resultSet.getInt("cantidad"),
	                    resultSet.getString("descripcion")
	                );
	            } else {
	                return null;
	            }
	        }
	    }
	}
        
        
    
public List<Producto> filtrarProductos(String criterio) throws SQLException {
    List<Producto> productosFiltrados = new ArrayList<>();
    String consulta;

    if (criterio == null || criterio.trim().isEmpty()) {
        // Consulta para todos los productos
        consulta = "SELECT * FROM producto"; 
    } else {
        consulta = "SELECT * FROM producto WHERE modelo LIKE ? OR marca LIKE ?";
    }
    
    try (Connection conexion = ConfiguracionBaseDatos.getConnection();
         PreparedStatement statement = conexion.prepareStatement(consulta)) {
        
        if (criterio != null && !criterio.trim().isEmpty()) {
            // Realizamos una búsqueda parcial que contengan coincidencias
            String search = "%" + criterio + "%"; 
            statement.setString(1, search);
            statement.setString(2, search);
        }
        
        try (ResultSet resultSet = statement.executeQuery()) {
            while (resultSet.next()) {
                Producto producto = new Producto(
                    resultSet.getInt("id"),
                    resultSet.getString("marca"),
                    resultSet.getString("modelo"),
                    resultSet.getDouble("precio"),
                    resultSet.getInt("cantidad"),
                    resultSet.getString("descripcion")
                );
                productosFiltrados.add(producto);
            }
        }
    }
    return productosFiltrados;
}



	// Método para guardar un nuevo producto
	public void guardarProducto(Producto producto) throws SQLException {
	    String consulta = "INSERT INTO producto (marca, modelo, precio, cantidad, descripcion) VALUES (?, ?, ?, ?, ?)";
	    try (Connection conexion = ConfiguracionBaseDatos.getConnection();
	         PreparedStatement statement = conexion.prepareStatement(consulta)) {
	         
	        statement.setString(2, producto.getMarca());
	        statement.setString(3, producto.getModelo());
	        statement.setDouble(4, producto.getPrecio());
	        statement.setInt(5, producto.getCantidad());
	        statement.setString(6, producto.getDescripcion());
	        statement.executeUpdate();
	    }
	}

	// Método para actualizar un producto existente
	public void actualizarProducto(Producto producto) throws SQLException {
	    String consulta = "UPDATE producto SET marca = ?, modelo = ?, precio = ?, cantidad = ?, descripcion = ? ";
	    try (Connection conexion = ConfiguracionBaseDatos.getConnection();
	         PreparedStatement statement = conexion.prepareStatement(consulta)) {
	         
	        statement.setString(2, producto.getMarca());
	        statement.setString(3, producto.getModelo());
	        statement.setDouble(4, producto.getPrecio());
	        statement.setInt(5, producto.getCantidad());
	        statement.setString(6, producto.getDescripcion());
	        
	        statement.executeUpdate();
	    }
	}


	// Método para eliminar un producto por ID
	public void eliminarProducto(String modelo) throws SQLException {
	    String consulta = "DELETE FROM producto WHERE id = ?";
	    try (Connection conexion = ConfiguracionBaseDatos.getConnection();
	         PreparedStatement statement = conexion.prepareStatement(consulta)) {
	         
	        statement.setString(3, modelo);
	        statement.executeUpdate();
	    }
	}


}
