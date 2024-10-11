package conexionBD;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import io.github.cdimascio.dotenv.Dotenv;

public class ConfiguracionBaseDatos {
    
    // Cargar variables desde el archivo .env
//  private static final Dotenv dotenv = Dotenv.load();
//  private static final String URL = dotenv.get("DB_URL");
//  private static final String USER = dotenv.get("DB_USER");
//  private static final String PASSWORD = dotenv.get("DB_PASSWORD");
    
    private static final Dotenv dotenv = Dotenv.load();
    private static final String URL = "jdbc:mysql://localhost:3306/tienda";
    private static final String USER = "root";
    private static final String PASSWORD = "Dicapani01";


    public static Connection getConnection() throws SQLException {
        return DriverManager.getConnection(URL, USER, PASSWORD);
    }
}
