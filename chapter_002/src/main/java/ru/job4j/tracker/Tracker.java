package ru.job4j.tracker;


import java.util.Arrays;
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
     * Массив для хранение заявок.
     */
    private final Item[] items = new Item[100];

    /**
     * Указатель ячейки для новой заявки.
     */
    private int position = 0;


    /**
     * Метод реализаущий добавление заявки в хранилище
     *
     * @param item новая заявка
     * @return Item заявка.
     */

    public Item add(Item item) {
        item.setId(this.generateId());
        this.items[this.position++] = item;
        return item;
    }


    /**
     * Метод реализует редактирование заявки в хранилище
     *
     * @param id   идентификатор заявки
     * @param item новая заявка.
     */


    public void replace(String id, Item item) {
        for (int index = 0; index < position; index++) {
            if (this.items[index].getId().equals(id)) {
                this.items[index] = item;
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
        for (int index = 0; index < position; index++) {
            if (this.items[index] != null && this.items[index].getId().equals(id)) {
                System.arraycopy(this.items, index + 1, this.items, index, this.items.length - 1 - index);
                this.items[this.items.length - 1] = null;
                break;
            }
        }
    }

    /**
     * Метод возвращает список заявок по имени
     *
     * @return result массив заявок.
     */

    Item[] findByName(String key) {
        Item[] result = new Item[this.items.length];
        int count = 0;
        for (int index = 0; index < position; index++) {
            if (this.items[index] != null && this.items[index].getName().equals(key)) {
                result[count++] = this.items[index];
            }
        }
        return Arrays.copyOf(result, count);
    }


    /**
     * Метод возвращает заякву по идентификатору
     *
     * @param id идентификатор заявки
     * @return Item заявка, если нет null .
     */

    public Item findById(String id) {
        int index;
        for (index = 0; index < position; index++) {
            if (this.items[index] != null && this.items[index].getId().equals(id)) {
                break;
            }
        }
        return this.items[index] == null ? null : this.items[index];
    }


    /**
     * Метод возвращает список всех заявок
     *
     * @return copyItem массив заявок.
     */

    public Item[] getAll() {
        int count = 0;
        for (int index = 0; index < position; index++) {
            if (this.items[index] != null) {
                count++;
            }
        }
        Item[] copyItem = new Item[count];
        System.arraycopy(this.items, 0, copyItem, 0, count);
        return copyItem;
    }


    /**
     * Метод генерирует уникальный ключ для заявки.
     *
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