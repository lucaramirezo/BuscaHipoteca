package grupo_nueve.buscahipotecas.Usuarios;

import org.springframework.web.bind.annotation.RestController;

import lombok.RequiredArgsConstructor;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;


@RestController
@RequestMapping("/usuario")
@RequiredArgsConstructor // Inyeccion de dependencia.
public class UsuarioController {

    private final UsuarioService usuarioService; // Inyeccion de dependencia.

    // @PostMapping("/create")
    // public void createUsuario(@RequestBody Usuario usuario)
    // {
    //     usuarioService.create(usuario);
    // }

    @GetMapping("/all")
    public List<Usuario> all()
    {
        return usuarioService.getAll();
    }

    // @PostMapping("/get")
    // // public Usuario getUsuario(@RequestBody Integer id_usuario) {
    // public String getUsuario(@RequestBody Integer id_usuario) {
    //     return "ok";
        // if (id_usuario <= 0) {
        //     throw new IllegalArgumentException("Invalid id_usuario");
        // }
        // return usuarioService.getById(id_usuario);
    // }

    @GetMapping("/{id_usuario}")
    public ResponseEntity<Usuario> getUserById(@PathVariable int id_usuario) {
        if (id_usuario <= 0) {
            throw new IllegalArgumentException("Invalid id_usuario");
        }
        Usuario usuario = usuarioService.getById(id_usuario);
        return ResponseEntity.ok(usuario);
    }
}
