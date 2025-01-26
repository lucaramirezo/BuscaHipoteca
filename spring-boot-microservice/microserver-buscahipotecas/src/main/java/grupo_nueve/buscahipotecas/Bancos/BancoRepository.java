package grupo_nueve.buscahipotecas.Bancos;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BancoRepository extends JpaRepository <Banco, Integer> {
    // Optional<Banco> findByBanco(String nombre_banco);
}
