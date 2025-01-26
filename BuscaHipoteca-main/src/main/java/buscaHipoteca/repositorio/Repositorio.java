package buscaHipoteca.repositorio;


import buscaHipoteca.model.Hipoteca;
import org.springframework.data.jpa.repository.JpaRepository;

public interface Repositorio extends JpaRepository<Hipoteca, Long> {
}

