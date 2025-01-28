package buscaHipoteca.controller;

import java.io.IOException;
import java.sql.ResultSet;
import java.sql.Statement;

import buscaHipoteca.model.SQLite;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class AppController {

    @FXML
    private VBox mainVBox; // Contenedor principal

    // Vista de Login
    @FXML
    private VBox loginView;
    @FXML
    private TextField usuarioTextField;
    @FXML
    private PasswordField passwordField;
    @FXML
    private Button loginButton;

    // Vista de Registro
    @FXML
    private VBox registerView;
    @FXML
    private TextField registerUserField;
    @FXML
    private PasswordField registerPasswordField;
    @FXML
    private PasswordField confirmPasswordField;
    @FXML
    private Button registerButton;

    /**
     * Inicialización automática al cargar la vista.
     */
    public void initialize() {
        showLoginView(); // Mostramos la vista de login al inicio
    }

    /**
     * Muestra la vista de login y oculta la de registro.
     */
    @FXML
    private void showLoginView() {
        loginView.setVisible(true);
        registerView.setVisible(false);
    }

    /**
     * Muestra la vista de registro y oculta la de login.
     */
    @FXML
    private void showRegisterView() {
        loginView.setVisible(false);
        registerView.setVisible(true);
    }

    /**
     * Acción de inicio de sesión.
     */
    @FXML
    private void onLoginAction(ActionEvent event) {
        String usuario = usuarioTextField.getText().trim();
        String contrasena = passwordField.getText().trim();

        if (usuario.isEmpty() || contrasena.isEmpty()) {
            showAlert("Error", "Por favor, completa todos los campos.");
        } else if (CheckUser(usuario, contrasena)) {
            showAlert("Acceso Permitido", "¡Bienvenido al sistema!");
            cambiarScene(); // Cambiar a la vista del dashboard
        } else {
            showAlert("Error de autenticación", "Usuario o contraseña incorrectos.");
        }
    }

    /**
     * Acción de registro de un nuevo usuario.
     */
    @FXML
    private void onRegisterAction(ActionEvent event) {
        String usuario = registerUserField.getText().trim();
        String pass = registerPasswordField.getText().trim();
        String confirmPass = confirmPasswordField.getText().trim();

        if (usuario.isEmpty() || pass.isEmpty() || confirmPass.isEmpty()) {
            showAlert("Error", "Todos los campos son obligatorios.");
        } else if (!pass.equals(confirmPass)) {
            showAlert("Error", "Las contraseñas no coinciden.");
        } else {
            showAlert("Registro Exitoso", "¡Tu cuenta ha sido creada!");
            showLoginView(); // Volvemos automáticamente al login tras el registro
        }
    }

    /**
     * Cambia la escena al dashboard tras un login exitoso.
     */
    private void cambiarScene() {
        try {
            // Cargar la nueva vista del dashboard
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/VIEW/FXML/ComparadorView.fxml"));
            Parent root = loader.load();

            // Obtener el stage actual y cambiar la escena
            Stage stage = (Stage) mainVBox.getScene().getWindow();
            stage.setScene(new Scene(root));
            stage.setTitle("Panel Principal - BuscaHipoteca");
        } catch (IOException e) {
            e.printStackTrace();
            showAlert("Error", "No se pudo cargar la vista del Dashboard.");
        }
    }

    /**
     * Muestra una alerta informativa o de error.
     * 
     * @param title   Título de la alerta.
     * @param content Contenido de la alerta.
     */
    private void showAlert(String title, String content) {
        Alert alert = new Alert(AlertType.INFORMATION);
        alert.setTitle(title);
        alert.setContentText(content);
        alert.showAndWait();
    }
    
    /**
     * Funciones para el acceso por BBDD
     */
    
    private boolean CheckUser(String user, String contraseña) {
    	boolean check = false;
    	int id = 0;
    	String nombre = null;
    	String pass = null;
    	try{
    		
    		// Crear statement y ejecutar consulta
            Statement stmt = SQLite.connect().createStatement();
            ResultSet rs = stmt.executeQuery("SELECT * FROM usuario where name = '"+user+"'");
            	
            	while(rs.next()) {
            		id = rs.getInt("id");
            		nombre = rs.getString("name");
            		pass = rs.getString("pass");
            	}
            if(user.equals(nombre) && contraseña.equals(pass)) {
            	check = true;
            }else {
            	System.out.println("error en el login");
            }
    	}catch(Exception e) {
    		e.printStackTrace();
    	}
    	return check;
    }
    
}