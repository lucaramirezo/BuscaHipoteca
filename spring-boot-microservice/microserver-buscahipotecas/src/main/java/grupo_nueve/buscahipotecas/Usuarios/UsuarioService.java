package grupo_nueve.buscahipotecas.Usuarios;

import java.util.List;
import java.util.HashSet;

import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import grupo_nueve.buscahipotecas.Hipotecas.Hipoteca;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor // Inyeccion de dependencia.
public class UsuarioService {

    private final UsuarioRepository usuarioRepository; // Inyeccion de dependencia.
    private final PasswordEncoder passwordEncoder;

    public void create (Usuario usuario)
    {
        usuarioRepository.save(usuario);
    }

    public List<Usuario> getAll() {
        return usuarioRepository.findAll();
    }

    public Usuario getById(int id_usuario) {
        return usuarioRepository.findById(id_usuario).orElse(null);
    }

    public Usuario update(int id_usuario, Usuario usuario) {
        if (id_usuario <= 0 || usuario == null) {
            throw new IllegalArgumentException("Invalid id_usuario");
        }
        Usuario usuarioToUpdate = usuarioRepository.findById(id_usuario).orElse(null);
        if (usuarioToUpdate == null) {
            throw new IllegalArgumentException("Usuario not found");
        }
        usuarioToUpdate.setUsername(usuario.getUsername());
        usuarioToUpdate.setEmail(usuario.getEmail());
        usuarioToUpdate.setPassword(passwordEncoder.encode(usuario.getPassword()));
        usuarioToUpdate.setRole(usuario.getRole());
        
        return usuarioRepository.save(usuarioToUpdate);
    }


    public void delete(int id_usuario) {
        if (id_usuario <= 0) {
            throw new IllegalArgumentException("Invalid id_usuario");
        }
        Usuario usuarioToDelete = usuarioRepository.findById(id_usuario).orElse(null);
        if (usuarioToDelete == null) {
            throw new IllegalArgumentException("Usuario not found");
        }
        usuarioRepository.delete(usuarioToDelete);
    }

    public Usuario setHipotecas(int id_usuario, List<Hipoteca> hipotecas) {
        
        Usuario usuario = usuarioRepository.findById(id_usuario).orElse(null);
        
        if (usuario == null) {
            throw new IllegalArgumentException("Usuario not found");
        }
        usuario.setHipotecas(new HashSet<>(hipotecas));
        return usuarioRepository.save(usuario);
    }


}
