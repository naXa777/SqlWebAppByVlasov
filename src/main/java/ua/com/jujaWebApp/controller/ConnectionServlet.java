package ua.com.jujaWebApp.controller;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class ConnectionServlet extends HttpServlet {
    private static Properties properties;
    public static String PAGE_OK = "connectionIsWell.jsp";
    public static String WRONG_PARAMETERS = "wrongConnection.jsp";

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        properties = loadProperties();

        System.out.println(properties.getProperty("db.user")+"\n"+
                properties.getProperty("db.dbname")+"\n"+
                properties.getProperty("db.password"));

        String password = req.getParameter("password");
        String login = req.getParameter("login");
        String dbName = req.getParameter("dbName");

        if(password.equals("root")&&
                login.equals("postgres")&&
                dbName.equals("test")){
            req.getRequestDispatcher(PAGE_OK).forward(req,resp);
        }
        else{
            req.getRequestDispatcher(WRONG_PARAMETERS).forward(req,resp);
        }
    }

    private static Properties loadProperties() {
        Properties result = new Properties();

        try (FileInputStream fis = new FileInputStream("src\\main\\resources\\DB.properties")) {
            result.load(fis);
        } catch (FileNotFoundException e) {
            System.err.println("ОШИБКА!!! Файл настроек не найден");
        } catch (IOException e) {
            e.printStackTrace();
        }

        return result;
    }
}
