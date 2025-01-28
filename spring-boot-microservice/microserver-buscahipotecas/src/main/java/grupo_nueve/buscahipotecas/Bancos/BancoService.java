package grupo_nueve.buscahipotecas.Bancos;

import java.util.List;
import org.springframework.stereotype.Service;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor // Inyeccion de dependencia.
public class BancoService {

    private final BancoRepository bancoRepository; // Inyeccion de dependencia.

    public void create(Banco banco) {
        bancoRepository.save(banco);
    }

    public List<Banco> getAll() {
        return bancoRepository.findAll();
    }

    public Banco update(int id_banco, Banco banco) {
        if (id_banco <= 0 || banco == null) {
            throw new IllegalArgumentException("Invalid id_banco");
        }
        Banco bancoToUpdate = bancoRepository.findById(id_banco).orElse(null);
        if (bancoToUpdate == null) {
            throw new IllegalArgumentException("hipoteca not found");
        }
        bancoToUpdate.setNombre_banco(banco.getNombre_banco());

        return bancoRepository.save(bancoToUpdate);
    }

    public void delete(int id_banco) {
        if (id_banco <= 0) {
            throw new IllegalArgumentException("Invalid id_hipoteca");
        }
        Banco bancoToDelete = bancoRepository.findById(id_banco).orElse(null);
        if (bancoToDelete == null) {
            throw new IllegalArgumentException("hipoteca not found");
        }
        bancoRepository.delete(bancoToDelete);
    }

}
