package io.github.patrikalm.service;

import java.io.IOException;
import java.io.Reader;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class DataBaseConnection {


    public static Connection getConnection() throws SQLException {

        Properties properties = new Properties();

        try(
                Reader in = Files.newBufferedReader(Path.of("src/main/resources/database.properties"), StandardCharsets.UTF_8);
                ){

            properties.load(in);
            System.out.println("File read");

        } catch (IOException e) {
            throw new RuntimeException("Oops, something went wrong with reading properties file!");
        }

        System.out.println("Read Properties");
        String url = properties.getProperty("jdbc.url");
        String username = properties.getProperty("jdbc.username");
        String password = properties.getProperty("jdbc.password");

        return DriverManager.getConnection(url, username, password);

    }


}
