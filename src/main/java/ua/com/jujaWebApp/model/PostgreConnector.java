package ua.com.jujaWebApp.model;

import ua.com.jujaWebApp.exceptions.ConnectionFailException;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class PostgreConnector implements DbConnector {
    private Properties properties;
    private Connection connection;

    public PostgreConnector() {
        Properties prop = new Properties();
        try (FileInputStream fis = new FileInputStream("src\\main\\resourses\\DB.properties")) {
            properties.load(fis);

        } catch (FileNotFoundException e) {
            System.err.println("ОШИБКА!!! Файл настроек не найден");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public PostgreConnector(Properties properties, Connection connection) {
        this.properties = properties;
        this.connection = connection;
    }

    public Connection connect(String login, String password, String dbName) throws ConnectionFailException {
        String url = properties.getProperty("db.url") + dbName;
        String jdbcDriver = properties.getProperty("db.driver");
        try{
            Class.forName(jdbcDriver);
            connection= DriverManager.getConnection(url,login,password);
        } catch (ClassNotFoundException e) {
            throw new ConnectionFailException(e.getMessage());
        } catch (SQLException e) {
            throw new ConnectionFailException(e.getMessage());
        }
        return connection;
    }
}
