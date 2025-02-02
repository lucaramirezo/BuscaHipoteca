package grupo_nueve.buscahipotecas.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.CorsConfigurationSource;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;

import java.util.Arrays;
import java.util.List;

import grupo_nueve.buscahipotecas.Jwt.JwtAuthenticationFilter;
import lombok.RequiredArgsConstructor;

@Configuration
@EnableWebSecurity
@RequiredArgsConstructor
public class SecurityConfig {

        private final JwtAuthenticationFilter jwtAuthenticationFilter;
        private final AuthenticationProvider authProvider;

        @Bean
        public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
                return http
                        .csrf(csrf -> csrf.disable()) // Deshabilitar CSRF para pruebas (activar en producción)
                        .cors(cors -> cors.configurationSource(corsConfigurationSource())) // Habilitar CORS
                        .authorizeHttpRequests(authRequest -> authRequest
                                .requestMatchers("/test/**").permitAll()
                                .requestMatchers("/buscahipotecas/v1/auth/**").permitAll() // Permitir autenticación
                                .requestMatchers("/doc/swagger-ui/**").permitAll()
                                .requestMatchers("/buscahipotecas/v1/swagger-ui/**").permitAll()
                                .requestMatchers("/buscahipotecas/v1/**").authenticated()
                                .anyRequest().authenticated())
                        .sessionManagement(sessionManager -> sessionManager
                                .sessionCreationPolicy(SessionCreationPolicy.STATELESS))
                        .authenticationProvider(authProvider)
                        .addFilterBefore(jwtAuthenticationFilter, UsernamePasswordAuthenticationFilter.class)
                        .build();
        }

        @Bean
        public CorsConfigurationSource corsConfigurationSource() {
                CorsConfiguration config = new CorsConfiguration();
                config.setAllowedOrigins(List.of("http://localhost:8081")); // Permitir frontend en 8081
                config.setAllowedMethods(Arrays.asList("GET", "POST", "PUT", "DELETE", "OPTIONS"));
                config.setAllowedHeaders(Arrays.asList("Authorization", "Content-Type"));
                config.setAllowCredentials(true); // Permitir cookies y tokens

                UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
                source.registerCorsConfiguration("/**", config);
                return source;
        }
}
