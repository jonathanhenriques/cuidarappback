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

            // Recuperar as informações de conexão do ambiente

//            jdbc:postgresql://${DB_HOST:localhost}:${PGPORT:5432}/${POSTGRES_DB:cuidarapp}

            String PGPORT = System.getenv("PGPORT");
            log.debug("PGPORT {}.",PGPORT );
            String POSTGRES_PORT = System.getenv("POSTGRES_PORT");
            log.debug("POSTGRES_PORT {}.",POSTGRES_PORT );
            String POSTGRES_DB = System.getenv("POSTGRES_DB");
            log.debug("POSTGRES_DB {}.",POSTGRES_DB );
            String POSTGRES_USER = System.getenv("DB_USERNAME");
            log.debug("POSTGRES_USER {}.",POSTGRES_USER );
            String POSTGRES_PASSWORD = System.getenv("DB_PASSWORD");
            log.debug("POSTGRES_PASSWORD {}.",POSTGRES_PASSWORD );



            Connection connection = null;
            Statement statement = null;
            try {
                log.debug("Creating database if not exist...");
//                connection = DriverManager.getConnection("jdbc:postgresql://localhost:5432/", "postgres", "159951");
//                spring.datasource.url=jdbc:postgresql://${DB_HOST:localhost}:${PGPORT:5432}/${POSTGRES_DB:cuidarapp}
//                connection = DriverManager.getConnection("jdbc:postgresql://localhost:5432/cuidarapp");
//                connection = DriverManager.getConnection("jdbc:postgresql://localhost:" + POSTGRES_PORT + "/", POSTGRES_DB, "159951");
                String dbUrl = "jdbc:postgresql://postgres:nTqGuMFzCsfGRBLkx0Rt@containers-us-west-59.railway.app:5827/railway";
                postgresql://postgres:nTqGuMFzCsfGRBLkx0Rt@containers-us-west-59.railway.app:5827/railway

                connection = DriverManager.getConnection(dbUrl,"postgres","nTqGuMFzCsfGRBLkx0Rt");
                statement = connection.createStatement();
                statement.executeQuery("SELECT count(*) FROM pg_database WHERE datname = '" + POSTGRES_DB + "'");
                ResultSet resultSet = statement.getResultSet();
                resultSet.next();
                int count = resultSet.getInt(1);

                if (count <= 0) {
                    statement.executeUpdate("CREATE DATABASE " + POSTGRES_DB);
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