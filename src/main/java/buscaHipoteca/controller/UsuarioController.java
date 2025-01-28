package buscaHipoteca.controller;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
public class UsuarioController {

    @PostMapping("/login")
    public String login(@RequestParam String usuario, @RequestParam String password) {
        // Lógica para manejar el inicio de sesión
        return "Login exitoso para usuario: " + usuario;
    }

    @PostMapping("/register")
    public String register(@RequestParam String usuario, @RequestParam String password, @RequestParam String confirmPassword) {
        if (!password.equals(confirmPassword)) {
            return "Las contraseñas no coinciden";
        }
        // Lógica para manejar el registro
        return "Usuario registrado: " + usuario;
    }
}
