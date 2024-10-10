/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package repositorio;

/**
 *
 * @author Jorge
 */
 import com.google.gson.Gson;
 import com.google.gson.JsonObject;
 import java.io.IOException;
 import java.net.URI;
 import java.net.http.HttpClient;
 import java.net.http.HttpRequest;
 import java.net.http.HttpResponse;
 import org.json.JSONObject;
 import io.github.cdimascio.dotenv.Dotenv;
import java.sql.SQLException;
import java.util.List;
import modelos.Producto;

 public class RepositorioIA {
     
     
 private static final Dotenv dotenv = Dotenv.load();
 private static final String API_KEY = dotenv.get("API_KEY");
 private static final String API_URL =
 "https://generativelanguage.googleapis.com/v1beta/models/gemini-pro:generateContent";
 private static final HttpClient httpClient = HttpClient.newHttpClient();
 private static final Gson gson = new Gson();
 
 
  private ProductoRepositorio productoRepositorio = new ProductoRepositorio(); // Instancia no estática

    public RepositorioIA() {
        productoRepositorio = new ProductoRepositorio(); // Inicializar el repositorio
    }
 
 
 
 
 
 public String crearContenido(String message) {
    
 JsonObject requestBody = new JsonObject();
 JsonObject content = new JsonObject();
 JsonObject part = new JsonObject();
 part.addProperty("text", message);
 content.add("parts", gson.toJsonTree(new JsonObject[]{part}));
 requestBody.add("contents", gson.toJsonTree(new JsonObject[]{content}));
    
 
 try {
     HttpRequest request = HttpRequest.newBuilder()
             .uri(URI.create(API_URL))
             .header("Content-Type", "application/json")
             .header("x-goog-api-key", API_KEY)
             .POST(HttpRequest.BodyPublishers.ofString(requestBody.toString()))
             .build();
     HttpResponse<String> response = httpClient.send(request,
                          HttpResponse.BodyHandlers.ofString());
     
     if (response.statusCode() != 200) {
            throw new IOException("Error en la API: " + response.statusCode() + " - " + response.body());
        }
     JSONObject jsonObj = new JSONObject(response.body());
     String mensaje = jsonObj.getJSONArray("candidates")
             .getJSONObject(0)
             .getJSONObject("content")
             .getJSONArray("parts")
             .getJSONObject(0)
             .getString("text");
     return mensaje;
      
 } catch (IOException | InterruptedException e) {
 System.out.println("Error al crear contenido: " + e.getMessage());
 }
return null;
 }

   public List<Producto> filtrarProductos(String criterio) throws SQLException {
        List<Producto> productosFiltrados = productoRepositorio.filtrarProductos(criterio);
        if (productosFiltrados.isEmpty()) {
            System.out.println("No se encontraron productos para el criterio: " + criterio);
        } else {
            System.out.println("Productos filtrados: " + productosFiltrados);
        }
        return productosFiltrados;
    }
 }