package ua.com.jujaWebApp.model;

import ua.com.jujaWebApp.exceptions.ConnectionFailException;

import java.sql.Connection;

public interface DbConnector {
    public Connection connect(String login, String password, String dbName) throws ConnectionFailException;

}
