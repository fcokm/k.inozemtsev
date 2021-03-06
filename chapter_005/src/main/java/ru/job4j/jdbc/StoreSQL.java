package ru.job4j.jdbc;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.sql.*;


/**
 * Class StoreSQL
 *
 * @author Konstantin Inozemcev (9715791@gmail.com)
 * @version $Id$
 * @since 0.1
 */
public class StoreSQL {

    /**
     * Ссылка на логер
     */
    private static Logger logger = LoggerFactory.getLogger(StoreSQL.class);

    /**
     * Метод возвращает ссылку на приватный конструктор
     */
   /* public static StoreSQL getInstance(Config config) {
        if (instance == null) {
            instance = new StoreSQL(config);
        }
        return instance;
    }*/
    private String databaseUrl;

    /**
     * Конструктор  - создание нового соединения с базой данных
     */
    public StoreSQL(Config config) {
        this.databaseUrl = config.getUrl();
        System.err.println(databaseUrl);
        try (Connection connection = DriverManager.getConnection(databaseUrl)) {
            if (!isTablesExist()) {
                try (Statement stmt = connection.createStatement()) {
                    stmt.executeUpdate(config.getCreateTable());
                } catch (SQLException e) {
                    logger.error(e.getMessage(), e);
                }
            }
            if (!isEmptyTable()) {
                deleteAllRecords();
            }
        } catch (Exception e) {
            logger.error(e.getMessage(), e);
        }
    }


    /**
     * Метод проверяет существует таблица в базе
     *
     * @return true существует
     */
    private boolean isTablesExist() throws Exception {
        boolean result = true;
        System.out.println(databaseUrl);
        try (Connection connection = DriverManager.getConnection(databaseUrl);
             Statement stmt = connection.createStatement();
             ResultSet rs = stmt.executeQuery("SELECT count(*) FROM sqlite_master WHERE type='table' AND name='entry'")) {
            int count = rs.getInt(1);
            if (count == 0) {
                result = false;
            }
        } catch (SQLException e) {
            logger.error(e.getMessage(), e);
        }
        return result;
    }

    /**
     * Метод удаляет все записи из таблицы
     */
    private void deleteAllRecords() {
        String sql = "delete from entry";
        try (Connection connection = DriverManager.getConnection(databaseUrl);
             PreparedStatement ps = connection.prepareStatement(sql)) {
            ps.executeUpdate();
        } catch (SQLException e) {
            logger.error(e.getMessage(), e);
        }
    }

    /**
     * Метод генерирует в базе данных n записей
     *
     * @param n количество записей
     */
    void generate(int n) {
        String insert = "insert into entry (value) values (?)";
        try (Connection connection = DriverManager.getConnection(databaseUrl);
             PreparedStatement ps = connection.prepareStatement(insert)) {
            while (0 < n) {
                ps.setInt(1, n--);
                ps.executeUpdate();
            }
        } catch (SQLException e) {
            logger.error(e.getMessage(), e);
        }
    }


    /**
     * Метод проверяет есть ли записи в таблице
     *
     * @return true есть записи
     */
    boolean isEmptyTable() {
        String sql = "select * from entry";
        boolean flag = true;
        try (Connection connection = DriverManager.getConnection(databaseUrl);
             PreparedStatement ps = connection.prepareStatement(sql)) {
            try (ResultSet rs = ps.executeQuery()) {
                if (rs.next()) {
                    flag = false;
                }
            }
        } catch (SQLException e) {
            logger.error(e.getMessage(), e);
        }
        return flag;
    }


    /**
     * Метод возвращает объект Entry
     *
     * @return entries
     */
    public Entry getEntries() {
        Entry entries = new Entry();
        String sql = "select * from entry";
        try (Connection connection = DriverManager.getConnection(databaseUrl);
             PreparedStatement ps = connection.prepareStatement(sql)) {
            connection.setAutoCommit(false);
            try (ResultSet rs = ps.executeQuery()) {
                while (rs.next()) {
                    Field field = new Field();
                    field.setValue(rs.getInt("value"));
                    entries.getValues().add(field);
                }
                connection.commit();
            } catch (SQLException e) {
                connection.rollback();
                logger.error(e.getMessage(), e);
            } finally {
                connection.setAutoCommit(true);
            }
        } catch (SQLException e) {
            logger.error(e.getMessage(), e);
        }
        return entries;
    }

}
