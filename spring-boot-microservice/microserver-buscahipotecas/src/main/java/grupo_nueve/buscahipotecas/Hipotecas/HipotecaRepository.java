package grupo_nueve.buscahipotecas.Hipotecas;

//import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface HipotecaRepository extends JpaRepository <Hipoteca, Integer> {
    // Optional<Hipoteca> findByHipoteca(String nombre_hipoteca);
}
