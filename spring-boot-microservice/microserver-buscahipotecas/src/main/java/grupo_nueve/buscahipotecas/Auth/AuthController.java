package grupo_nueve.buscahipotecas.Auth;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.RequiredArgsConstructor;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;


@RestController
@RequestMapping("/auth")
@RequiredArgsConstructor
public class AuthController {

    private final AuthService authService;

    @PostMapping(value = "login")
    public ResponseEntity<AuthResponse> login(@RequestBody LoginRequest request) {
        AuthResponse login_response = authService.login(request);
        return ResponseEntity.ok(login_response);
    }
    
    @PostMapping(value = "register")
    public ResponseEntity<AuthResponse> register(@RequestBody RegisterRequest request) {
        AuthResponse register_response = authService.register(request);
        return ResponseEntity.ok(register_response);
    }

    @PostMapping(value = "test")
    public ResponseEntity<String> test() {
        return ResponseEntity.ok("Test!");
    }
}
