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

    public Usuario getById(int id_usuario) {
        // TODO Auto-generated method stub
        //throw new UnsupportedOperationException("Unimplemented method 'getById'");
        return usuarioRepository.findById(id_usuario).orElse(null);
    }


}
