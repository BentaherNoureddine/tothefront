package com.noureddine.user_managemenet_service.config;



import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.web.SecurityFilterChain;


@Configuration
@EnableWebSecurity
public class SecurityConfig  {





    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception{

        http
                .cors(Customizer.withDefaults())
                //we have to disable the csrf
                .csrf(AbstractHttpConfigurer:: disable)
                //authorized endpoints
                .authorizeHttpRequests(req ->
                        req.requestMatchers(
                                        "/auth/**",
                                        "/reports/**",
                                        "/management/**",
                                        "/admin/**"
                                ).permitAll()
                                //the request at the request matchers don t need to be authenticated but those must be
                                .anyRequest()
                                .authenticated()
                );
        //the type of the session management




        return http.build();
    }




}

