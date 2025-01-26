package buscaHipoteca.model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class SQLite {
    public static void main(String[] args) {
    	
    	
    	
    }
    
    // Método para establecer la conexión a la base de datos
    public static Connection connect() {
        String url = "jdbc:sqlite:hipotecas.db"; // Ruta a tu base de datos SQLite
        Connection conn = null;

        try {
            // Establecer la conexión
            conn = DriverManager.getConnection(url);
            System.out.println("Conexión establecida.");
        } catch (SQLException e) {
            System.out.println("Error al conectar a la base de datos.");
            e.printStackTrace();
        }

        return conn; // Devuelve la conexión
    }
    
    public static void disconnect(Connection conn) {
        if (conn != null) { // Verificar si la conexión no es nula
            try {
                // Cerrar la conexión
                conn.close();
                System.out.println("Conexión cerrada.");
            } catch (SQLException e) {
                System.out.println("Error al cerrar la base de datos.");
                e.printStackTrace();
            }
        } else {
            System.out.println("La conexión ya estaba cerrada o es nula.");
        }
    }

}
