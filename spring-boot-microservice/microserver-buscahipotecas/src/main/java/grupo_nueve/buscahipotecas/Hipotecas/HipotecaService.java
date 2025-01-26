package grupo_nueve.buscahipotecas.Hipotecas;

import java.util.List;

import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor // Inyeccion de dependencia.
public class HipotecaService {

    private final HipotecaRepository hipotecaRepository; // Inyeccion de dependencia.

    public void create (Hipoteca hipoteca)
    {
        hipotecaRepository.save(hipoteca);
    }

    public List<Hipoteca> getAll() {
        return hipotecaRepository.findAll();
    }


}
