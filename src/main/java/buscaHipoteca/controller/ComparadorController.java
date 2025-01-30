package buscaHipoteca.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;
import org.springframework.http.ResponseEntity;

@RestController
@RequestMapping("/buscahipotecas/v1/hipotecas")
public class ComparadorController {

    private final RestTemplate restTemplate = new RestTemplate();

    @GetMapping
    public ResponseEntity<String> getHipotecas() {
        String apiUrl = "http://localhost:8080/buscahipotecas/v1/hipotecas"; // URL del microservicio
        return restTemplate.getForEntity(apiUrl, String.class);
    }
}
