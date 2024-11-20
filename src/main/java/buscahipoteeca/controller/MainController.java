package buscahipoteeca.controller;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;

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

    }

    public void initialize() {
        // Centrar todos los elementos dentro del VBox
        VIEW.setAlignment(Pos.CENTER); // Asegura que todo en el VBox esté centrado vertical y horizontalmente

        // Ajustar el ancho de los elementos para que sean proporcionales al ancho del VBox
        LoginButton.prefWidthProperty().bind(VIEW.widthProperty().multiply(0.5)); // Botón será 50% del ancho del VBox
        PassLabel.prefWidthProperty().bind(VIEW.widthProperty().multiply(0.5));   // Etiqueta será 50% del ancho del VBox
        UsuarioLabel.prefWidthProperty().bind(VIEW.widthProperty().multiply(0.5)); // Etiqueta será 50% del ancho del VBox
        NombreText.prefWidthProperty().bind(VIEW.widthProperty().multiply(0.6));  // Campo de texto será 60% del ancho del VBox
        PassText.prefWidthProperty().bind(VIEW.widthProperty().multiply(0.6));    // Campo de texto será 60% del ancho del VBox
    }

}
