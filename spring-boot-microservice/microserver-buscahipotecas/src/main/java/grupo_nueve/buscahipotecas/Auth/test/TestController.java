package grupo_nueve.buscahipotecas.Auth.test;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/test")
@RequiredArgsConstructor // Inyeccion de dependencia.
public class TestController {

    @PostMapping(value = "test")
    public ResponseEntity<String> test() {
        return ResponseEntity.ok("Test!");
    }
}
