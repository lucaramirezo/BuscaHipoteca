package grupo_nueve.buscahipotecas.Usuarios;

import java.util.List;

import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor // Inyeccion de dependencia.
public class UsuarioService {

    private final UsuarioRepository usuarioRepository; // Inyeccion de dependencia.

    public void create (Usuario usuario)
    {
        usuarioRepository.save(usuario);
    }

    public List<Usuario> getAll() {
        return usuarioRepository.findAll();
    }


}
