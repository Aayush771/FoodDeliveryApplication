package com.foodApp.AppConfig;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
@Configuration
public class AppSecurityConfig {
    @Bean
    public SecurityFilterChain mySecurityFilterChain(HttpSecurity http) throws Exception {

        http

                .csrf().disable()
                .authorizeHttpRequests()
                .requestMatchers("/swagger-ui*/**","/v3/api-docs/**","/customer").permitAll()
                .requestMatchers(HttpMethod.POST, "/customer").permitAll()
                .anyRequest().authenticated().and()
                .formLogin()
                .and()
                .httpBasic();

        return http.build();
    }

    @Bean
    public PasswordEncoder encoder() {
        return new BCryptPasswordEncoder();
    }
}
