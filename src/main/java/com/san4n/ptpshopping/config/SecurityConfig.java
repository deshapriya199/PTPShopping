package com.san4n.ptpshopping.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

//    @Bean
//    public SecurityFilterChain filterChain1(HttpSecurity http) throws Exception {
//        //http.headers().frameOptions().disable();
//        http.csrf((csrf) -> csrf.disable())
//                .authorizeHttpRequests( (auth) ->{
//                    auth.anyRequest().authenticated();
//                });
//        return http.build();
//    }

    @Bean
    public PasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder();
    }

}
