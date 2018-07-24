package ru.job4j.jdbc;

import java.io.InputStream;
import java.util.Properties;

/**
 * Class Config
 *
 * @author Konstantin Inozemcev (9715791@gmail.com)
 * @version $Id$
 * @since 0.1
 */
public class Config {
    /**
     *  Строка URL подключения к базе
     */
   private String url;

    /**
     * Строка создания новой таблицы
     */
   private String create;

    /**
     * Конструктор  - создание нового соединения с базой данных
     */
    public Config() {
        Properties prop = new Properties();
        try (InputStream fis = Config.class.getClassLoader().getResourceAsStream
                ("confing.properties")) {
            prop.load(fis);
            this.url = prop.getProperty("url");
            this.create = prop.getProperty("create");
        } catch (Exception e) {

        }
    }

    /**
     * Получение строки URL
     */
    public String getUrl() {
        return url;
    }

    /**
     * Получение строки create
     */
    public String getCreateTable() {
        return create;
    }
}
