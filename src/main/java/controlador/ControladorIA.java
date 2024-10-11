/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controlador;
import java.sql.SQLException;
import java.util.List;
import modelos.Producto;
import repositorio.RepositorioIA;
import servicio.ServicioIA;

/**
 *
 * @author Jorge
 */
public class ControladorIA {
    private ServicioIA servIA;
    private RepositorioIA repositorioIA;


    
    public ControladorIA() {
        servIA = new ServicioIA();
        repositorioIA = new RepositorioIA();
    }
    
   
   
//
//    public void buscarYGenerarContenido(String criterio) {
//        try {
//            List<Producto> productosFiltrados = repositorioIA.filtrarProductos(criterio); // Llamar al método
//            StringBuilder mensaje = new StringBuilder("Productos encontrados:\n");
//            
//            for (Producto producto : productosFiltrados) {
//                mensaje.append("Marca: ").append(producto.getMarca())
//                        .append(", Modelo: ").append(producto.getModelo())
//                        .append(", Precio: ").append(producto.getPrecio())
//                        .append(", Descripción: ").append(producto.getDescripcion())
//                        .append("\n");
//            }
//            
//            // Generar contenido usando la IA
//            String contenidoGenerado = repositorioIA.crearContenido(mensaje.toString());
//            System.out.println("Contenido generado: " + contenidoGenerado);
//            
//        } catch (SQLException e) {
//            System.out.println("Error al filtrar productos: " + e.getMessage());
//        }
//    }
//
//
//        public String crearContenido (String message){
//        return servIA.crearContenido(message);
//    } 
    
}
