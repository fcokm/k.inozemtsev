package ru.job4j.tracker;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

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
     * Метод реализающий добавление заявки в хранилище
     *
     * @param item новая заявка
     * @return Item заявка.
     */
    public Item add(Item item) {
        item.setId(this.generateId());
        this.itemList.add(item);
        return item;
    }

    /**
     * Метод реализует редактирование заявки в хранилище
     *
     * @param id   идентификатор заявки
     * @param item новая заявка.
     */
    public void replace(String id, Item item) {
        for (Item it : this.itemList) {
            if (it.getId().equals(id)) {
                this.itemList.add(item);
                break;
            }
        }
    }

    /**
     * Метод удаляет заявку
     *
     * @param id идентификатор заявки
     */
    public void delete(String id) {
        for (Item item : this.itemList) {
            if (item.getId().equals(id)) {
                this.itemList.remove(item);
                break;
            }
        }
    }

    /**
     * Метод возвращает список заявок по имени
     * @return result список заявок.
     */
    List<Item> findByName(String key) {
        List<Item> items = new ArrayList<>();
        for (Item item : this.itemList) {
            if (item.getName().equals(key)) {
                items.add(item);
            }
        }
        return items;
    }


    /**
     * Метод возвращает заякву по идентификатору
     *
     * @param id идентификатор заявки
     * @return Item заявка, если нет null .
     */

    public Item findById(String id) {
        Item item = null;
        for (Item it : this.itemList) {
            if (it.getId().equals(id)) {
                item = it;
            }
        }
        return item;
    }


    /**
     * Метод возвращает список всех заявок
     * @return список заявок.
     */
    public List<Item> getAll() {
        return this.itemList;
    }

    /**
     * Метод генерирует уникальный ключ для заявки.
     * @return id Уникальный ключ.
     */
    private String generateId() {
        String id = " ";
        do {
            id = Integer.toString(new Random(System.nanoTime()).nextInt(100) + 1);
        } while (this.findById(id) != null);
        return id;
    }


}