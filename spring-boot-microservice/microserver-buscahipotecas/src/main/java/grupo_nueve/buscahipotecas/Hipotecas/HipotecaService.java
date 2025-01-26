package grupo_nueve.buscahipotecas.Hipotecas;

import java.util.List;
import org.springframework.stereotype.Service;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor // Inyeccion de dependencia.
public class HipotecaService {

    private final HipotecaRepository hipotecaRepository; // Inyeccion de dependencia.

    public void create(Hipoteca hipoteca) {
        hipotecaRepository.save(hipoteca);
    }

    public List<Hipoteca> getAll() {
        return hipotecaRepository.findAll();
    }

    public Hipoteca update(int id_hipoteca, Hipoteca hipoteca) {
        if (id_hipoteca <= 0 || hipoteca == null) {
            throw new IllegalArgumentException("Invalid id_hipoteca");
        }
        Hipoteca hipotecaToUpdate = hipotecaRepository.findById(id_hipoteca).orElse(null);
        if (hipotecaToUpdate == null) {
            throw new IllegalArgumentException("hipoteca not found");
        }
        hipotecaToUpdate.setNombre_hipoteca(hipoteca.getNombre_hipoteca());
        hipotecaToUpdate.setImporte_inicial(hipoteca.getImporte_inicial());
        hipotecaToUpdate.setMensualidad(hipoteca.getMensualidad());
        hipotecaToUpdate.setTipo_hipoteca(hipoteca.getTipo_hipoteca());
        hipotecaToUpdate.setFinalidad(hipoteca.getFinalidad());
        hipotecaToUpdate.setId_entidad(hipoteca.getId_entidad());

        return hipotecaRepository.save(hipotecaToUpdate);
    }

    public void delete(int id_hipoteca) {
        if (id_hipoteca <= 0) {
            throw new IllegalArgumentException("Invalid id_hipoteca");
        }
        Hipoteca hipotecaToDelete = hipotecaRepository.findById(id_hipoteca).orElse(null);
        if (hipotecaToDelete == null) {
            throw new IllegalArgumentException("hipoteca not found");
        }
        hipotecaRepository.delete(hipotecaToDelete);
    }

}
