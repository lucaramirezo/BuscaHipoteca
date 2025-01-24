package grupo_nueve.buscahipotecas.Usuarios;

import java.util.Collection;
import java.util.List;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.provisioning.UserDetailsManager;

import jakarta.persistence.Basic;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.UniqueConstraint;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data // Anotation Lombok que añade getters y setters.
@Builder
@AllArgsConstructor // Anotation Lombok que añade constructor.
@NoArgsConstructor // No deja recibir parámetros.
@Entity
// @Table(name="usuario", uniqueConstraints = {@UniqueConstraint(columnNames = {"email"})});
public class Usuario implements UserDetails {
    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private Integer id_usuario;
    @Column(nullable = false)
    String username;
    @Column(nullable = false)
    String email;
    @Column(nullable = false)
    String password;
    Role role;

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        // TODO Auto-generated method stub
        // throw new UnsupportedOperationException("Unimplemented method 'getAuthorities'");
        return List.of(new SimpleGrantedAuthority((role.name())));
    }

    // @Override
    // public String getUsername() {
    //     // TODO Auto-generated method stub
    //     throw new UnsupportedOperationException("Unimplemented method 'getUsername'");
    // }
    
    @Override
    public boolean isAccountNonExpired() {
       return true;
    }

    @Override
    public boolean isAccountNonLocked() {
       return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }
    
    @Override
    public boolean isEnabled() {
        return true;
    }


}
