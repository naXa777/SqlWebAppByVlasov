package ua.com.jujaWebApp.controller;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class ConnectionServlet extends HttpServlet {
    private static String PAGE_OK = "connectionIsWell.jsp";
    private static String WRONG_PARAMETERS = "wrongConnection.jsp";


    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
            Properties properties = loadProperties();

            //Написал sout, просто чтобы видеть в консоли, - пишется что-то или нет. как решу трабл, - уберу
            System.out.println(properties.getProperty("db.user") + "\n" +
                    properties.getProperty("db.dbname") + "\n" +
                    properties.getProperty("db.password"));

            String login = req.getParameter("login");
            String password = req.getParameter("password");
            String dbName = req.getParameter("dbName");

        /*тут ниже пока хардкод, чтобы хоть как-то работало. Как решу вопрос с пропертями, - все будет сравниваться через них

        if(password.equals(properties.getProperty("db.password"))&&
                login.equals(properties.getProperty("db.user"))&&
                dbName.equals(properties.getProperty("db.dbname"))){

         */
        if(password.equals("root")&&
                login.equals("postgres")&&
                dbName.equals("test")){

            req.getRequestDispatcher(PAGE_OK).forward(req,resp);
        }
        else{
            req.getRequestDispatcher(WRONG_PARAMETERS).forward(req,resp);
        }
    }

    private Properties loadProperties() {
        Properties result = new Properties();

        try(FileInputStream fis = new FileInputStream("src/main/webapp/WEB-INF/classes/DB.properties")) {
            result.load(fis);
        } catch (IOException e) {
            e.printStackTrace();
        }

        return result;
    }
}
