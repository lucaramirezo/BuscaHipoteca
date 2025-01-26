package grupo_nueve.buscahipotecas.Usuarios;

import org.springframework.web.bind.annotation.RestController;

import grupo_nueve.buscahipotecas.Hipotecas.Hipoteca;
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
@RequestMapping("/buscahipotecas/v1/usuario")
@RequiredArgsConstructor // Inyeccion de dependencia.
public class UsuarioController {

    private final UsuarioService usuarioService; // Inyeccion de dependencia.

    // Create se realiza en el auth.

    @GetMapping("/all")
    public List<Usuario> all()
    {
        return usuarioService.getAll();
    }

    @GetMapping("/get/{id_usuario}")
    public ResponseEntity<Usuario> getUserById(@PathVariable int id_usuario) {
        if (id_usuario <= 0) {
            throw new IllegalArgumentException("Invalid id_usuario");
        }
        Usuario usuario = usuarioService.getById(id_usuario);
        return ResponseEntity.ok(usuario);
    }

    @PostMapping("/update/{id_usuario}")
    public ResponseEntity<Usuario> updateUsuario(@PathVariable int id_usuario, @RequestBody Usuario usuario) {
        if (id_usuario <= 0) {
            throw new IllegalArgumentException("Invalid id_usuario");
        }
        Usuario updatedUsuario = usuarioService.update(id_usuario, usuario);
        return ResponseEntity.ok(updatedUsuario);
    }

    @DeleteMapping("/delete/{id_usuario}")
    public ResponseEntity<String> deleteUsuario(@PathVariable int id_usuario) {
        if (id_usuario <= 0) {
            throw new IllegalArgumentException("Invalid id_usuario");
        }
        usuarioService.delete(id_usuario);
        return ResponseEntity.ok("User deleted successfully");
    }

    @PostMapping("/setHipotecas/{id_usuario}")
    public ResponseEntity<Usuario> setHipotecas(@PathVariable int id_usuario, @RequestBody List<Hipoteca> hipotecas) {
        if (id_usuario <= 0) {
            throw new IllegalArgumentException("Invalid id_usuario");
        }
        Usuario usuario = usuarioService.setHipotecas(id_usuario, hipotecas);
        return ResponseEntity.ok(usuario);
    }
}
