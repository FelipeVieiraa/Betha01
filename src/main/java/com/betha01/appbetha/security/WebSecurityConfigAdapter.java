package com.betha01.appbetha.security;

import com.betha01.appbetha.details.UsuarioCustomDTO;
import com.betha01.appbetha.models.Users;
import com.betha01.appbetha.repositories.UserRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

/**
 * WebSecurityConfigAdapter
 */

@Configuration
@EnableWebSecurity
public class WebSecurityConfigAdapter extends WebSecurityConfigurerAdapter {

    @Bean
    public AuthenticationManager customAuthenticationManager() throws Exception {
        return authenticationManagerBean();
    }

    @Bean  
    public static BCryptPasswordEncoder passwordEncoder() {  
    return new BCryptPasswordEncoder();  
    }

    @Autowired
    public void authenticationManager(AuthenticationManagerBuilder builder, UserRepository userRepository) throws Exception {
    if (userRepository.count() == 0) {
        String pass = "admin";
        String login = "admin";

        Users user = new Users();
        user.setUsername(login);
        user.setUserpass(passwordEncoder().encode(pass));
        userRepository.save(user);
    }

    builder.userDetailsService(username -> new UsuarioCustomDTO(userRepository.findByUsername(username))).passwordEncoder(passwordEncoder());
    
    }
    
}