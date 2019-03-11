package ua.com.jujaWebApp.controller;

import ua.com.jujaWebApp.exceptions.ConnectionFailException;
import ua.com.jujaWebApp.model.DbConnector;
import ua.com.jujaWebApp.model.PostgreConnector;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Connection;

public class ConnectionServlet extends HttpServlet {
    private DbConnector model;
    private Connection connection;

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        model = new PostgreConnector();
        String password = req.getParameter("password");
        String login = req.getParameter("login");
        String dbName = req.getParameter("dbName");
        try {
            connection = model.connect(login,password,dbName);

        } catch (ConnectionFailException e) {
            e.printStackTrace();
        }
    }


}
