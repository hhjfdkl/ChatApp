package com.toy.chatapp.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

    //for use in Authentication Provider
    @Autowired
    private UserDetailsService userDetailsService;

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {

        return http
                .csrf(customizer -> customizer.disable())
                .authorizeHttpRequests(request -> request.anyRequest().authenticated())
                .httpBasic(Customizer.withDefaults())
                .sessionManagement(session -> session.sessionCreationPolicy(SessionCreationPolicy.STATELESS))
                .build()
                ;

    }

/*
    //TODO : Create a class which implements UserDetailsService
    //This will be used for our login users
    @Bean
    public UserDetailsService userDetailsService(){

        //this is a test user - this builder will be replaced with whatever is in our database once we flesh that out.
        UserDetails user1 = User
                .withDefaultPasswordEncoder()   //don't use this - it's deprecated and not proper hashing for storage
                .username("user1")
                .password("password")
                .roles("USER")
                .build();


        //This is a test user - similar to H2 for database
        return new InMemoryUserDetailsManager(user1);
    }
*/

    //Bean to change our Authentication Provider - we don't want to use Spring's default since we want to use a SQL db
    @Bean
    public AuthenticationProvider authenticationProvider() {
        DaoAuthenticationProvider provider = new DaoAuthenticationProvider();
        provider.setPasswordEncoder(NoOpPasswordEncoder.getInstance()); //don't do this, this is plaintext
        provider.setUserDetailsService(userDetailsService);
        return provider;
    }


}
