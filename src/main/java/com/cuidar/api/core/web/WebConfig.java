package com.cuidar.api.core.web;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.filter.ShallowEtagHeaderFilter;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import javax.servlet.Filter;

/**
 * Classe de configuracao do CORS
 */
//@Configuration
//public class WebConfig implements WebMvcConfigurer {
//
//    @Bean
//    public Filter shallowEtagHeaderFilter() {
//        return new ShallowEtagHeaderFilter();
//    }
//
//}


@Configuration
public class WebConfig implements WebMvcConfigurer {
    @Override
    public void addCorsMappings(CorsRegistry registry) {
        registry.addMapping("/**")//aqui passamos os endpoints dos controllers ex: /clientes
//                .allowedOrigins("*") //aqui as uris do cliente ex: http://localhost:8081
//                .allowedMethods("*") //aqui passamos os verbos http ex: "GET", "POST"...
//                .allowCredentials(false)
        ;
    }
}