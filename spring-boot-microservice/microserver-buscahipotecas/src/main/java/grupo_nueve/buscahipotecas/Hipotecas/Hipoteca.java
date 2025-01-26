package grupo_nueve.buscahipotecas.Hipotecas;

import java.util.HashSet;
import java.util.Set;

import grupo_nueve.buscahipotecas.Usuarios.Usuario;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data // Anotation Lombok que añade getters y setters.
@Builder
@AllArgsConstructor // Anotation Lombok que añade constructor.
@NoArgsConstructor // No deja recibir parámetros.
@Entity
public class Hipoteca {
    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private Integer id_hipoteca;

    @Column(nullable = false)
    String nombre_hipoteca;

    @Column(nullable = false)
    Double importe_inicial;

    @Column(nullable = false)
    Double mensualidad;

    @Column(nullable = true)
    String tipo_hipoteca;

    @Column(nullable = false)
    String finalidad;

    @Column(nullable = false)
    int id_entidad;
    
    
    @ManyToMany(mappedBy = "hipotecas")
    @Builder.Default
    private Set<Usuario> usuarios = new HashSet<>();


}

