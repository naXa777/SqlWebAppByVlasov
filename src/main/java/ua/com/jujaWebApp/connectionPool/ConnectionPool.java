package ua.com.jujaWebApp.connectionPool;

import org.apache.commons.dbcp.DriverManagerConnectionFactory;
import org.apache.commons.dbcp.PoolableConnectionFactory;
import org.apache.commons.dbcp.PoolingDataSource;
import org.apache.commons.pool.impl.GenericObjectPool;
import org.postgresql.core.ConnectionFactory;

import javax.sql.DataSource;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class ConnectionPool {
    private static Properties properties;
    private static String jdbcDriver;
    private static String url;
    private static String user;
    private static String password;
    private static GenericObjectPool gPool;

    static {
        properties= new Properties();
        try (FileInputStream fis = new FileInputStream("src\\main\\webapp\\WEB-INF\\props\\DB.properties")) {
            properties.load(fis);
        } catch (FileNotFoundException e) {
            System.err.println("ОШИБКА!!! Файл настроек не найден");
        } catch (IOException e) {
            e.printStackTrace();
        }

        jdbcDriver = properties.getProperty("db.driver");
        url = properties.getProperty("db.url")+properties.getProperty("db.dbname");
        user = properties.getProperty("db.user");
        password = properties.getProperty("db.password");
    }

    public static DataSource setUpPool() throws ClassNotFoundException {
        Class.forName(jdbcDriver);

        gPool = new GenericObjectPool();
        gPool.setMaxActive(10);

        DriverManagerConnectionFactory conFactory = new DriverManagerConnectionFactory(url,user,password);

        PoolableConnectionFactory polCOnFactory = new PoolableConnectionFactory(
                conFactory,gPool,null,null,false,true);
        return new PoolingDataSource(gPool);
    }

    public static GenericObjectPool getConnectionPool(){
        return gPool;
    }

    private void printDbStatus(){
        System.out.println(String.format("Максимальный размер пула:%s\n" +
                "Активных коннекшенов:%s",
                getConnectionPool().getMaxActive(),getConnectionPool().getNumActive()));
    }
}
