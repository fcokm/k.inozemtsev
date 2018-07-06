package ru.job4j.tracker;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.*;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.sql.*;
import java.util.Properties;

/**
 * Class DbHelper реализует
 *
 * @author Konstantin Inozemcev (9715791@gmail.com)
 * @version $Id$
 * @since 0.1
 */
public class DbHelper {

    /**
     * Ссылка на объект соединения с базой данных
     */
    private Connection conn;

    /**
     * Ссылка на логер
     */
    private static Logger logger = LoggerFactory.getLogger(DbHelper.class);

    /**
     * Ссылка на объект класса
     */
    private static DbHelper instance;

    /**
     * Метод возвращает ссылку на приватный конструктор
     */
    public static DbHelper getInstance() {
        if (instance == null) {
            instance = new DbHelper();
        }
        return instance;
    }

    /**
     * Конструктор  - создание нового соединения с базой данных
     */
    private DbHelper() {
        Properties prop = new Properties();
        try (InputStream fis = DbHelper.class.getClassLoader().getResourceAsStream("confing.properties")) {
            prop.load(fis);
            String url = prop.getProperty("url");
            String username = prop.getProperty("username");
            String password = prop.getProperty("password");
            Class.forName("org.postgresql.Driver");
            conn = DriverManager.getConnection(url, username, password);
            if (!isTablesExist()) {
                Statement stmt = conn.createStatement();
                String createSql = readResource(DbHelper.class, "create.sql");
                stmt.executeUpdate(createSql);
                stmt.close();
            }
        } catch (Exception e) {
           logger.error(e.getMessage(), e);
        }

    }


    /**
     * Метод возвращает ссылку на соединение с базой
     *
     * @return conn
     */
    public Connection getConn() {
        return conn;
    }

    /**
     * Метод проверяет существует таблица в базе
     *
     * @return true существует
     */
    boolean isTablesExist() throws Exception {
        DatabaseMetaData data = conn.getMetaData();
        boolean exist = false;
        try (ResultSet res = data.getTables(null, null, "item",
                new String[]{"TABLE"})) {
            exist = res.next();
        } catch (SQLException e) {
            logger.error(e.getMessage(), e);
        }
        return exist;
    }

    /**
     * Метод возвращает скрипт создание новой таблицы из файла
     *
     * @return строка
     */
    String readResource(Class cpHolder, String path) throws Exception {
        URL url = cpHolder.getClassLoader().getResource(path);
        Path resPath = Paths.get(url.toURI());
        return new String(Files.readAllBytes(resPath), "UTF8");
    }


}

