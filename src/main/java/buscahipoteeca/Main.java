package buscahipoteeca;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) {
        try {
            // Cargamos el FXML -> src/main/resources/VIEW/MainView.fxml
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/VIEW/FXML/MainView.fxml"));
            Parent root = loader.load();

            // Crear el objecto scene (La vista)
            Scene scene = new Scene(root);

            // El título de la ventana (Se puede dejar vacio)
            primaryStage.setTitle("Buscahipoteeca");

            // Ícono para la ventana (Opcional)
            //primaryStage.getIcons().add(
            //    new javafx.scene.image.Image(getClass().getResourceAsStream("/images/icon.png"))
            // );

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
