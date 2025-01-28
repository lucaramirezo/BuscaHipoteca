package grupo_nueve.buscahipotecas.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import grupo_nueve.buscahipotecas.Jwt.JwtAuthenticationFilter;

// import static org.springframework.security.config.Customizer.withDefaults;

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
                                .csrf(csrf -> csrf.disable()) // Crossside Request forced Desabilitar proteccion csrf
                                .authorizeHttpRequests(authRequest -> authRequest
                                                .requestMatchers("/test/**").permitAll()
                                                .requestMatchers("/buscahipotecas/v1/auth/**").permitAll()
                                                .requestMatchers("/doc/swagger-ui/**").permitAll()
                                                .requestMatchers("/buscahipotecas/v1/swagger-ui/**").permitAll()
                                                // .requestMatchers("/doc/swagger-ui.html").permitAll()
                                                // .requestMatchers("/doc/swagger-ui/index.html").permitAll()
                                                .requestMatchers("/buscahipotecas/v1/**").authenticated()
                                                .anyRequest().authenticated())
                                .sessionManagement(sessionManager -> sessionManager
                                                .sessionCreationPolicy(SessionCreationPolicy.STATELESS))
                                .authenticationProvider(authProvider)
                                .addFilterBefore(jwtAuthenticationFilter, UsernamePasswordAuthenticationFilter.class)
                                .build();
        }

}
