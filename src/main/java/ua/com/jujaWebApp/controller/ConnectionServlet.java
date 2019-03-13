package ua.com.jujaWebApp.controller;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class ConnectionServlet extends HttpServlet {
    private static String PAGE_OK = "connectionIsWell.jsp";
    private static String WRONG_PARAMETERS = "wrongConnection.jsp";


    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
            Properties properties = loadProperties();

            String login = req.getParameter("login");
            String password = req.getParameter("password");
            String dbName = req.getParameter("dbName");

        if (password.equals(properties.getProperty("db.password")) &&
                login.equals(properties.getProperty("db.user")) &&
                dbName.equals(properties.getProperty("db.dbname"))) {

            req.getRequestDispatcher(PAGE_OK).forward(req, resp);
        } else {
            req.getRequestDispatcher(WRONG_PARAMETERS).forward(req, resp);
        }
    }

    private Properties loadProperties() {
        Properties result = new Properties();

        try {
            final InputStream is = ConnectionServlet.class.getResourceAsStream("/DB.properties");
            result.load(is);
        } catch (IOException e) {
            e.printStackTrace();
        }

        return result;
    }
}
