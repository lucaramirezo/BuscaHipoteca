package grupo_nueve.buscahipotecas.Hipotecas;

import org.springframework.web.bind.annotation.RestController;

import grupo_nueve.buscahipotecas.Usuarios.Usuario;
import lombok.RequiredArgsConstructor;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;


@RestController
@RequestMapping("/hipoteca")
@RequiredArgsConstructor // Inyeccion de dependencia.
public class HipotecaController {

    private final HipotecaService hipotecaService; // Inyeccion de dependencia.

    @PostMapping("/create")
    public void createHipoteca(@RequestBody Hipoteca hipoteca)
    {
        hipotecaService.create(hipoteca);
    }

    @GetMapping("/all")
    public List<Hipoteca> all()
    {
        return hipotecaService.getAll();
    }
}
