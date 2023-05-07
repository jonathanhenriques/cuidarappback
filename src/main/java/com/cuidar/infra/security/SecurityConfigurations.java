package com.cuidar.infra.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

@Configuration
@EnableWebMvc
public class SecurityConfigurations {

    @Autowired
    private SecurityFilter securityFilter;

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
         http.csrf().disable().cors();


        http.headers().frameOptions().disable();
        http.authorizeRequests().antMatchers("/h2-console/**").permitAll();
//        http.csrf().disable().authorizeRequests().anyRequest().permitAll()

                http.sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS)
                .and().authorizeRequests()

                .antMatchers(HttpMethod.POST,"/login").permitAll()

                .antMatchers("/pacientes/**").permitAll()//esse endpoint e de livre acesso para qualquer usuario

                .anyRequest().permitAll()
//                .authenticated()
                //indicamos para executar primeiro o filtro de autenticação e depois os filtros do spring
                .and().addFilterBefore(securityFilter, UsernamePasswordAuthenticationFilter.class)
       ;
                return http .build();
    }

    @Bean //disponibiliza objetos para o Spring ou para usar em outros lugares
    public AuthenticationManager authenticationManagerBean(AuthenticationConfiguration configuration) throws Exception {
        //cria um AuthenticationManagerBean e disponibiliza para o Spring
        return configuration.getAuthenticationManager();
    }

    @Bean
    public PasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder();
    }
}
