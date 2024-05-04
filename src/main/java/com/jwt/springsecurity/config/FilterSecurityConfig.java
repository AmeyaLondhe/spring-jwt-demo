package com.jwt.springsecurity.config;

import com.jwt.springsecurity.security.JWTEntryPoint;
import com.jwt.springsecurity.security.JWTFilter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configurers.AuthorizeHttpRequestsConfigurer;
import org.springframework.security.config.annotation.web.configurers.CsrfConfigurer;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

@Configuration
public class FilterSecurityConfig {

    @Autowired
    private JWTEntryPoint jwtEntryPoint;
    @Autowired
    private JWTFilter jwtFilter;

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception{
         http.csrf(CsrfConfigurer::disable)
                 .authorizeHttpRequests(auth -> auth.requestMatchers("/topics/**").authenticated()
                         .requestMatchers("/auth/login").permitAll()
                         .anyRequest().authenticated())
                         .exceptionHandling(e -> e.authenticationEntryPoint(jwtEntryPoint))
                 .sessionManagement(s -> s.sessionCreationPolicy(SessionCreationPolicy.STATELESS));
         http.addFilterBefore(jwtFilter, UsernamePasswordAuthenticationFilter.class);
         return http.build();
    }
}
