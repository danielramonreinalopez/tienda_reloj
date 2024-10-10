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
                   
                    resultSet.getString("marca"),
                    resultSet.getString("modelo"),
                    resultSet.getDouble("precio"),                    
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
    public void actualizarProducto(Producto producto) throws SQLException {
        String consulta = "UPDATE producto SET marca = ?, modelo = ?, precio = ?, descripcion = ? WHERE modelo = ?";
        try (Connection conexion = ConfiguracionBaseDatos.getConnection();
             PreparedStatement statement = conexion.prepareStatement(consulta)) {
             
            statement.setString(1, producto.getMarca());
            statement.setString(2, producto.getModelo());
            statement.setDouble(3, producto.getPrecio());
            statement.setString(4, producto.getDescripcion());
            statement.setString(5, producto.getModelo()); // El modelo es usado como identificador
            statement.executeUpdate();
        }
    }

    // Método para eliminar un producto por modelo
    public void eliminarProducto(String modelo) throws SQLException {
        String consulta = "DELETE FROM producto WHERE modelo = ?";
        try (Connection conexion = ConfiguracionBaseDatos.getConnection();
             PreparedStatement statement = conexion.prepareStatement(consulta)) {
             
            statement.setString(1, modelo); // El parámetro debe ser 1
            statement.executeUpdate();
        }
    }
    
    
    // Método para contar la cantidad total de productos en la base de datos
    public int contarProductos() throws SQLException {
        String consulta = "SELECT COUNT(*) AS total FROM producto";
        try (Connection conexion = ConfiguracionBaseDatos.getConnection();
             PreparedStatement statement = conexion.prepareStatement(consulta);
             ResultSet resultSet = statement.executeQuery()) {
             
            if (resultSet.next()) {
                return resultSet.getInt("total");
            } else {
                return 0;
            }
        }
    }
}
