package ru.job4j.tracker;

import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.sql.*;
import java.util.*;


/**
 * Class Tracker реализует функционал хранения и обработки  заявок
 *
 * @author Konstantin Inozemcev (9715791@gmail.com)
 * @version $Id$
 * @since 0.1
 */

public class Tracker {
    /**
     * Список для хранение заявок.
     */
    List<Item> itemList = new ArrayList<>();

    /**
     * Указатель ячейки для новой заявки.
     */
    private int position = 0;


    /**
     * Ссылка на соединение с базой
     */
    private DbHelper dbHelper = DbHelper.getInstance();


    /**
     * Метод реализающий добавление заявки в хранилище
     *
     * @param item новая заявка
     * @return Item заявка.
     */
    public Item add(Item item) {
        String sql = "insert into item (name, description, creared) VALUES (?, ?, ?);";
        try (PreparedStatement ps = dbHelper.getConn().prepareStatement(sql)) {
            ps.setString(1, item.getName());
            ps.setString(2, item.getDesc());
            ps.setTimestamp(3, new Timestamp(Calendar.getInstance().getTimeInMillis()));
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return item;
    }

    /**
     * Метод реализует редактирование заявки в хранилище
     *
     * @param id   идентификатор заявки
     * @param item новая заявка.
     */
    public void replace(int id, Item item) {
        String sql = "update item set  name = ?,  description = ?,  creared = ?   where id = ?";
        try (PreparedStatement ps = dbHelper.getConn().prepareStatement(sql)) {
            ps.setString(1, item.getName());
            ps.setString(2, item.getDesc());
            ps.setTimestamp(3, item.getCreared());
            ps.setInt(4, id);
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    /**
     * Метод удаляет заявку
     *
     * @param id идентификатор заявки
     */
    public void delete(int id) {
        String sql = "delete from item where id = ?";
        try (PreparedStatement ps = dbHelper.getConn().prepareStatement(sql)) {
            ps.setInt(1, id);
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    /**
     * Метод возвращает список заявок по имени
     *
     * @return result список заявок.
     */
    List<Item> findByName(String key) {
        List<Item> items = new ArrayList<>();
        String sql = "select * form item where key = ?";
        try (PreparedStatement ps = dbHelper.getConn().prepareStatement(sql)) {
            try (ResultSet rs = ps.executeQuery()) {
                while (rs.next()) {
                    Item item = new Item();
                    item.setId(rs.getInt("id"));
                    item.setName(rs.getString("name"));
                    item.setDesc(rs.getString("description"));
                    item.setCreared(rs.getTimestamp("creared"));
                    items.add(item);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return items;
    }


    /**
     * Метод возвращает заякву по идентификатору
     *
     * @param id идентификатор заявки
     * @return Item заявка, если нет null .
     */

    public Item findById(int id) {
        Item item = null;
        String sql = "select * form item where id = ?";
        try (PreparedStatement ps = dbHelper.getConn().prepareStatement(sql)) {
            try (ResultSet rs = ps.executeQuery()) {
                if (rs.next()) {
                    item = new Item();
                    item.setId(rs.getInt("id"));
                    item.setName(rs.getString("name"));
                    item.setDesc(rs.getString("description"));
                    item.setCreared(rs.getTimestamp("creared"));
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return item;
    }


    /**
     * Метод возвращает список всех заявок
     *
     * @return список заявок.
     */
    public List<Item> getAll() {
        List<Item> items = new ArrayList<>();
        String sql = "select * from item";
        try (PreparedStatement ps = dbHelper.getConn().prepareStatement(sql)) {
            try (ResultSet rs = ps.executeQuery()) {
                while (rs.next()) {
                    Item item = new Item();
                    item.setId(rs.getInt("id"));
                    item.setName(rs.getString("name"));
                    item.setDesc(rs.getString("description"));
                    item.setCreared(rs.getTimestamp("creared"));
                    items.add(item);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return items;
    }


}