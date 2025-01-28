<<<<<<< HEAD
package buscaHipoteca.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MainController {
    private static final Logger Logger = LoggerFactory.getLogger(MainController.class);

    @GetMapping("/") // Página principal
    public String home() {
        Logger.info("Entrando a la página principal");
        return "index"; // templates/index.html
    }

    @GetMapping("/login") // Página de inicio de sesión
    public String showLoginPage(Model model) {
        Logger.info("Entrando a la página de login");
        return "LoginPage"; // templates/LoginPage.html
    }

    @GetMapping("/register") // Página de registro
    public String showRegisterPage(Model model) {
        Logger.info("Entrando a la página de registro");
        return "RegisterPage"; // templates/RegisterPage.html
    }

    @GetMapping("/test") // Página de prueba
    public String showTestPage() {
        Logger.info("Entrando a la página de test");
        return "test"; // templates/test.html
    }
}
=======
package buscaHipoteca.controller;

import java.io.IOException;
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

public class MainController {

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
        } else if (usuario.equals("ADMIN") && contrasena.equals("ADMIN")) {
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
}
>>>>>>> 4787f1bafb9d970f685025c027e057187e45223a
