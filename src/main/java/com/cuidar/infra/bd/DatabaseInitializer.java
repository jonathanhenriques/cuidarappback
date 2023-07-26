package com.cuidar.infra.bd;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;

import java.sql.*;

/**
 * Classe responsavel por verificar se existe um Banco de dados com o nome especifico
 * e se não existir, ele sera criado, evitando erros
 * (a criacao do schema esta sendo feita via properties)
 */
@Slf4j
public class DatabaseInitializer {

    public static void createDatabaseIfNotExists() {
        //pega o valor da propriedade profile antes de subir o prjeto
        String activeProfile = System.getProperty("spring.profiles.active");
        log.debug("valor {}.",activeProfile );
        if (activeProfile != null && !activeProfile.equals("teste")) {

            Connection connection = null;
            Statement statement = null;
            try {
                log.debug("Creating database if not exist...");
                connection = DriverManager.getConnection("jdbc:postgresql://localhost:5432/", "postgres", "159951");
                statement = connection.createStatement();
                statement.executeQuery("SELECT count(*) FROM pg_database WHERE datname = 'cuidarapp'");
                ResultSet resultSet = statement.getResultSet();
                resultSet.next();
                int count = resultSet.getInt(1);

                if (count <= 0) {
                    statement.executeUpdate("CREATE DATABASE cuidarapp");
                    log.debug("Database created.");
                } else {
                    log.debug("Database already exist.");
                }
            } catch (SQLException e) {
                log.error(e.toString());
            } finally {
                try {
                    if (statement != null) {
                        statement.close();
                        log.debug("Closed Statement.");
                    }
                    if (connection != null) {
                        log.debug("Closed Connection.");
                        connection.close();
                    }
                } catch (SQLException e) {
                    log.error(e.toString());
                }
            }

        }
    }
}