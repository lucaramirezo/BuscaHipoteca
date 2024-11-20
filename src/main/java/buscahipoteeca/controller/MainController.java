package buscahipoteeca.controller;
import java.io.IOException;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Pos;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class MainController {

    @FXML
    private Button LoginButton;

    @FXML
    private TextField PassLabel;

    @FXML
    private TextField UsuarioLabel;

    @FXML
    private VBox VIEW;
    
    @FXML
    private Label NombreText;

    @FXML
    private Label PassText;

    @FXML
    void onLoginAction(ActionEvent event) {
    	ComprobarContraseña(UsuarioLabel.getText(), PassLabel.getText());    	
    }

    public void initialize() {
        // Centrar el contenido dentro del VBox
        VIEW.setAlignment(Pos.CENTER);

        // Ajustar el ancho de los elementos de forma proporcional al ancho del VBox
        double textFieldWidthRatio = 0.65; // Los TextField ocuparán el 65% del ancho del VBox

        // Vincular ancho de los TextField
        UsuarioLabel.prefWidthProperty().bind(VIEW.widthProperty().multiply(textFieldWidthRatio));
        PassLabel.prefWidthProperty().bind(VIEW.widthProperty().multiply(textFieldWidthRatio));

        // Vincular ancho del botón
        LoginButton.prefWidthProperty().bind(VIEW.widthProperty().multiply(0.5)); // El botón será el 50% del ancho del VBox

        // Opcional: limitar un tamaño máximo del VBox para evitar que crezca desmesuradamente
        VIEW.setMaxWidth(600);
    }

    public void ComprobarContraseña(String Usuario, String Pass) {
    	System.out.println(Usuario);
    	System.out.println(Pass);
    	//Esto es un ejemplo, una vez creemos la base de datos hay que cambiarlo para verificar contra la bbdd
    	if(Usuario.equals("ADMIN")){
    		if(Pass.equals("ADMIN")) {
    			System.out.println("Acceso Permitido");
    			CambiarScene();
    		}else {
    			System.out.println("Contraseña no valida");
    		}
    	}else
    	{
    		System.out.println("No es Valido");
    	}
    }
    public void CambiarScene() {
    	// Cambiar a la nueva escena
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/VIEW/FXML/SecondView.fxml"));
            Parent root = loader.load();
            
            // Obtén el stage actual y cambia la escena
            Stage stage = (Stage) PassLabel.getScene().getWindow();
            stage.setScene(new Scene(root));
            stage.setTitle("Buscahipoteeca");
        } catch (IOException e) {
            e.printStackTrace();
            showAlert("Error", "No se pudo cargar la vista del Dashboard.");
        }
    } 
    
	//Método para mostrar una alerta
	private void showAlert(String title, String content) {
	    Alert alert = new Alert(AlertType.ERROR);
	    alert.setTitle(title);
	    alert.setContentText(content);
	    alert.showAndWait();
	}

}
