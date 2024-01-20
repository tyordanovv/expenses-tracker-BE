package com.expenses.tracker.expensestracker.security.config;

import com.expenses.tracker.expensestracker.security.jwt.JWTAuthFilter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.web.AuthenticationEntryPoint;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.security.web.authentication.www.BasicAuthenticationEntryPoint;

@Configuration
@EnableWebSecurity
public class FilterChainConfig {
    private final AuthenticationProvider authenticationProvider;
    private final JWTAuthFilter jwtAuthFilter;

    @Autowired
    public FilterChainConfig(
            AuthenticationProvider authenticationProvider,
            JWTAuthFilter jwtAuthenticationFilter
    ) {
        this.authenticationProvider = authenticationProvider;
        this.jwtAuthFilter = jwtAuthenticationFilter;
    }


    @Bean
    public SecurityFilterChain securityFilterChain(
            HttpSecurity http
    ) throws Exception {
        http
                .csrf().disable()                   // disable csrf
                .cors(Customizer.withDefaults())    // no changes
                .authorizeHttpRequests()
                .requestMatchers(                   // permit all request which match POST and the following urls
                        HttpMethod.POST,
                        "/api/v1/auth",
                        "/api/v1/oauth2/callback"
                ).permitAll()
                .requestMatchers(                   // permit all request which match GET and /actuator/**
                        HttpMethod.GET,
                        "/actuator/**",
                        "/api/v1/auth",
                        "/api/v1/user",
                        "/api/v1/account/**"
                ).permitAll()
                .requestMatchers(                   // permit all authenticated request to user controller
                        "/api/v1/user/**"
                ).hasRole("FREE")
                .and()
                .sessionManagement()
                .sessionCreationPolicy(SessionCreationPolicy.STATELESS)
                .and()
                .authenticationProvider(authenticationProvider)
                .addFilterBefore(
                        jwtAuthFilter,
                        UsernamePasswordAuthenticationFilter.class
                )
                .exceptionHandling();
        return http.build();
    }
}
