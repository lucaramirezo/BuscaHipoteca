package grupo_nueve.buscahipotecas.Auth;

import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import grupo_nueve.buscahipotecas.Jwt.JwtService;
import grupo_nueve.buscahipotecas.Usuarios.Role;
import grupo_nueve.buscahipotecas.Usuarios.Usuario;
import grupo_nueve.buscahipotecas.Usuarios.UsuarioRepository;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class AuthService {

    private final UsuarioRepository usuarioRepository;
    private final JwtService jwtServie;
    private final PasswordEncoder passwordEncoder;
    private final AuthenticationManager authenticationManager;

    public AuthResponse login(LoginRequest request) {
        authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(request.getUsername(), request.getPassword()));
        UserDetails usuario_details=usuarioRepository.findByUsername(request.getEmail()).orElseThrow();
        
        String token=jwtServie.getToken(usuario_details);
        
        return AuthResponse.builder()
            .token(token)
            .build();
    }

    public AuthResponse register(RegisterRequest request) {
        if (usuarioRepository.findByEmail(request.getEmail()).isPresent()) {
            throw new IllegalArgumentException("User already exists");
        }

        Usuario usuario = Usuario.builder()
            .username(request.getEmail())
            .email(request.getEmail())
            .password(passwordEncoder.encode(request.getPassword()))
            .role(Role.USER)
            .build();
        
        usuarioRepository.save(usuario);

        return AuthResponse.builder()
            .token(jwtServie.getToken(usuario))
            .build();
    }

}
