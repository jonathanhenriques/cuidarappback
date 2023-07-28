package com.cuidar;
import com.cuidar.infra.bd.DatabaseInitializer;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

import java.util.TimeZone;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.core.env.Environment;

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

