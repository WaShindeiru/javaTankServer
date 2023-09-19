package com.example.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.stereotype.Component;

@Component
public class BasicConfig {
    private PasswordEncoder encoder;

    @Bean
    public PasswordEncoder provideEncoder() {
        encoder = new BCryptPasswordEncoder();
        return encoder;
    }

    @Bean
    public UserDetailsService provideUserService() {
        var userService = new InMemoryUserDetailsManager();

        var adminUser = User.builder()
                .username("Tank")
                .password(encoder.encode("tanko"))
                .authorities("user")
                .build();

        userService.createUser(adminUser);

        return userService;
    }

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        return http
                .formLogin(form -> form
                        .loginPage("/login")
                        .permitAll())

                .authorizeHttpRequests((customizer) -> customizer
                        .requestMatchers("/").hasAuthority("user")
                        .anyRequest().permitAll())

                .httpBasic(Customizer.withDefaults()).build();
    }
}
