<<<<<<< HEAD
package buscaHipoteca.app;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class App extends Application {

	 @Override
	    public void start(Stage primaryStage) {
	        try {
	            // Cargamos el FXML -> src/main/resources/VIEW/MainView.fxml
	            FXMLLoader loader = new FXMLLoader(getClass().getResource("/VIEW/FXML/MainView.fxml"));
	            Parent root = loader.load();

	            // Crear el objeto scene (La vista)
	            Scene scene = new Scene(root);

	            // El t�tulo de la ventana (Se puede dejar vacio)
	            primaryStage.setTitle("Busca Hipoteca");

	            // �cono para la ventana (Opcional)
	            primaryStage.getIcons().add(
	            	    new javafx.scene.image.Image(getClass().getResourceAsStream("/VIEW/IMAGENES/logo.png"))
	            	);
	            // Mostrar la vista
	            primaryStage.setScene(scene);
	            primaryStage.show();
	        } catch (Exception e) {
	        	// Mostramos el error
	            e.printStackTrace();
	        }
	    }
	 public static void main(String[] args) {
	        launch(args);
	    }
}
=======
package buscaHipoteca.app;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class App extends Application {

	 @Override
	    public void start(Stage primaryStage) {
	        try {
	            // Cargamos el FXML -> src/main/resources/VIEW/MainView.fxml
	            FXMLLoader loader = new FXMLLoader(getClass().getResource("/VIEW/FXML/MainView.fxml"));
	            Parent root = loader.load();

	            // Crear el objeto scene (La vista)
	            Scene scene = new Scene(root);

	            // El t�tulo de la ventana (Se puede dejar vacio)
	            primaryStage.setTitle("Busca Hipoteca");

	            // �cono para la ventana (Opcional)
	            primaryStage.getIcons().add(
	            	    new javafx.scene.image.Image(getClass().getResourceAsStream("/VIEW/IMAGENES/logo.png"))
	            	);
	            // Mostrar la vista
	            primaryStage.setScene(scene);
	            primaryStage.show();
	        } catch (Exception e) {
	        	// Mostramos el error
	            e.printStackTrace();
	        }
	    }
	 public static void main(String[] args) {
	        launch(args);
	    }
}
>>>>>>> 4787f1bafb9d970f685025c027e057187e45223a
