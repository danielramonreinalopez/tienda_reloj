/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package servicio;
import java.sql.SQLException;
import java.util.List;
import modelos.Producto;
import repositorio.RepositorioIA;

/**
 *
 * @author Jorge
 */
public class ServicioIA {
    private RepositorioIA iaRepo;
    
    public ServicioIA (){
        iaRepo = new RepositorioIA();
    }
    
    public String crearContenido (String mesage){
        return iaRepo.crearContenido(mesage);
    }
    
    // En ServicioIA
//    public List<Producto> filtrarProductos(String criterio) throws SQLException {
//        return iaRepo.filtrarProductos(criterio);
//    }

}
