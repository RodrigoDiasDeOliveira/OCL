package com.triminds.security.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {

        http
            // desativa CSRF para API REST
            .csrf(csrf -> csrf.disable())

            // sessão stateless (padrão para JWT futuro)
            .sessionManagement(session ->
                session.sessionCreationPolicy(SessionCreationPolicy.STATELESS)
            )

            // regras de autorização (SUBSTITUI antMatchers)
            .authorizeHttpRequests(auth -> auth

                // endpoints públicos
                .requestMatchers(
                    "/auth/**",
                    "/public/**",
                    "/h2-console/**"
                ).permitAll()

                // RFID protegido
                .requestMatchers("/rfid/**").authenticated()

                // prediction protegido
                .requestMatchers("/prediction/**").authenticated()

                // resto bloqueado por padrão
                .anyRequest().authenticated()
            );

        // necessário para H2 console funcionar
        http.headers(headers -> headers.frameOptions(frame -> frame.disable()));

        return http.build();
    }
}