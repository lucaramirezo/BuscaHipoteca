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