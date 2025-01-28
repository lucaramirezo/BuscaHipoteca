package grupo_nueve.buscahipotecas.Bancos;

import org.springframework.web.bind.annotation.RestController;
import lombok.RequiredArgsConstructor;
import java.util.List;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;


@RestController
@RequestMapping("/buscahipotecas/v1/banco")
@RequiredArgsConstructor // Inyeccion de dependencia.
public class BancoController {

    private final BancoService bancoService; // Inyeccion de dependencia.

    @PostMapping("/create")
    public void createBanco(@RequestBody Banco banco)
    {
        bancoService.create(banco);
    }

    @GetMapping("/all")
    public List<Banco> all()
    {
        return bancoService.getAll();
    }

    @PostMapping("/update/{id_banco}")
    public ResponseEntity<Banco> updateHipoteca(@PathVariable int id_banco, @RequestBody Banco banco) {
        if (id_banco <= 0) {
            throw new IllegalArgumentException("Invalid id_hipoteca");
        }
        Banco updatedBanco = bancoService.update(id_banco, banco);
        return ResponseEntity.ok(updatedBanco);
    }

    @DeleteMapping("/delete/{id_banco}")
    public ResponseEntity<String> deleteBanco(@PathVariable int id_banco) {
        if (id_banco <= 0) {
            throw new IllegalArgumentException("Invalid id_banco");
        }
        bancoService.delete(id_banco);
        return ResponseEntity.ok("Banco deleted successfully");
    }
}
