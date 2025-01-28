package buscaHipoteca.controller;

import buscaHipoteca.model.Hipoteca;
import buscaHipoteca.servicio.Servicio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/hipotecas")
public class HipotecaController {

    @Autowired
    private Servicio hipotecaService;

    @GetMapping
    public List<Hipoteca> getAllHipotecas() {
        return hipotecaService.getAllHipotecas();
    }

    @PostMapping
    public Hipoteca createHipoteca(@RequestBody Hipoteca hipoteca) {
        return hipotecaService.createHipoteca(hipoteca);
    }
}
