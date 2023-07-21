package com.cuidar;

import com.cuidar.infra.bd.DatabaseInitializer;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

import java.sql.*;
import java.util.TimeZone;

@Slf4j
@SpringBootApplication
public class CuidarApplication {
    public static void main(String[] args) {
        TimeZone.setDefault(TimeZone.getTimeZone("UTC"));

        DatabaseInitializer.createDatabaseIfNotExists();
        SpringApplication.run(CuidarApplication.class, args);
    }


}