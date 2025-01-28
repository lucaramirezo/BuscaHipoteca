package buscaHipoteca.servicio;

import buscaHipoteca.model.Hipoteca;
import buscaHipoteca.repositorio.Repositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class Servicio {

    @Autowired
    private Repositorio hipotecaRepository;

    public List<Hipoteca> getAllHipotecas() {
        return hipotecaRepository.findAll();
    }

    public Hipoteca createHipoteca(Hipoteca hipoteca) {
        return hipotecaRepository.save(hipoteca);
    }
}
