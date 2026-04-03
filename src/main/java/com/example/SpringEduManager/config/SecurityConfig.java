package com.example.SpringEduManager.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.core.userdetails.*;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableMethodSecurity
public class SecurityConfig {

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        http
            // ⚠️ CSRF desactivado (ok para pruebas)
            .csrf(csrf -> csrf.disable())

            .authorizeHttpRequests(auth -> auth

                // 🌐 RUTAS PÚBLICAS
                .requestMatchers("/login", "/css/**").permitAll()

                // 📋 VISTAS (USER y ADMIN)
                .requestMatchers("/cursos", "/estudiantes").hasAnyRole("ADMIN", "USER")

                // 📚 CURSOS (solo ADMIN)
                .requestMatchers("/cursos/nuevo", "/cursos/guardar", "/cursos/eliminar/**").hasRole("ADMIN")

                // 👨‍🎓 ESTUDIANTES (solo ADMIN)
                .requestMatchers("/estudiantes/nuevo", "/estudiantes/guardar", "/estudiantes/eliminar/**").hasRole("ADMIN")

                // 🔒 OTRAS ÁREAS
                .requestMatchers("/evaluaciones/**").hasRole("ADMIN")
                .requestMatchers("/api/**").hasRole("ADMIN")

                // 🔐 TODO LO DEMÁS REQUIERE LOGIN
                .anyRequest().authenticated()
            )

            // 🔑 LOGIN
            .formLogin(form -> form
                .loginPage("/login")
                .defaultSuccessUrl("/cursos", true)
                .permitAll()
            )

            // 🚪 LOGOUT
            .logout(logout -> logout
                .logoutSuccessUrl("/login?logout")
                .permitAll()
            );

        return http.build();
    }

    // 👥 USUARIOS EN MEMORIA
    @Bean
    public UserDetailsService userDetailsService() {

        UserDetails admin = User.builder()
                .username("admin")
                .password("{noop}1234")
                .roles("ADMIN")
                .build();

        UserDetails user = User.builder()
                .username("user")
                .password("{noop}1234")
                .roles("USER")
                .build();

        return new InMemoryUserDetailsManager(admin, user);
    }
}