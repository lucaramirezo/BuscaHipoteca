package grupo_nueve.buscahipotecas.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityCustomizer;
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
                                                .requestMatchers("/auth/**").permitAll()
                                                .requestMatchers("/swagger-ui/**").permitAll()
                                                .requestMatchers("/v3/api-docs*/**").permitAll()
                                                .requestMatchers("/test/**").permitAll()
                                                .requestMatchers("/doc/**").permitAll()
                                                .requestMatchers("/doc/swagger-ui.html").permitAll()
                                                .anyRequest().authenticated())

                                // .formLogin(withDefaults())
                                .sessionManagement(sessionManager -> sessionManager
                                                .sessionCreationPolicy(SessionCreationPolicy.STATELESS))
                                .authenticationProvider(authProvider)
                                .addFilterBefore(jwtAuthenticationFilter, UsernamePasswordAuthenticationFilter.class)
                                .build();
        }

        @Bean
        public WebSecurityCustomizer webSecurityCustomizer() {
                return (web) -> web.ignoring()
                                .requestMatchers(
                                        "/swagger-ui/**"
                                        , "/v3/api-docs*/**"
                                        , "/doc/**"
                                        ,"/test/**"
                                        );
        }
}
