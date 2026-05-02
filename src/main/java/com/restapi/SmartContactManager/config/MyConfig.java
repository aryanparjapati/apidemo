package com.restapi.SmartContactManager.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class MyConfig {

    @Bean
    public UserDetailsService getUserDetailsService() {
        return new UserDetailsServiceImpl();
    }

    @Bean
    public BCryptPasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Bean
    public DaoAuthenticationProvider authenticationProvider() {
        DaoAuthenticationProvider authProvider = new DaoAuthenticationProvider();
        authProvider.setUserDetailsService(getUserDetailsService());
        authProvider.setPasswordEncoder(passwordEncoder());
        return authProvider;
    }

   @Bean
public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {

    http
        .authenticationProvider(authenticationProvider())

        .authorizeHttpRequests(auth -> auth
            // ✅ static resources allow karo
            .requestMatchers("/img/**", "/css/**", "/js/**").permitAll()

            // ✅ public pages
            .requestMatchers("/", "/signin", "/signup", "/do_register").permitAll()

            // ✅ roles
            .requestMatchers("/user/**").hasRole("USER")
            .requestMatchers("/admin/**").hasRole("ADMIN")

            .anyRequest().authenticated()
        )

        .formLogin(form -> form
            .loginPage("/signin")
            .loginProcessingUrl("/dologin")
            .defaultSuccessUrl("/user/index", true)
        )

        .csrf(csrf -> csrf.disable());

    return http.build();
}
}