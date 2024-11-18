package buscahipoteeca.controller;

import buscahipoteeca.model.Usuario;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

public class MainController {

    @FXML
    private TextField nameField; // Campo de texto para ingresar el nombre

    @FXML
    private Label messageLabel; // Etiqueta para mostrar el mensaje

    private Usuario user; // Modelo

    public MainController() {
        // Inicializamos el modelo
        this.user = new Usuario("");
    }

    @FXML
    public void handleSubmit() {
        // Actualizamos el modelo con el nombre ingresado
        String name = nameField.getText();
        if (name.isEmpty()) {
            messageLabel.setText("Por favor, ingresa un nombre.");
        } else {
            user.setName(name);
            messageLabel.setText("¡Hola, " + user.getName() + "!");
        }
    }
}
