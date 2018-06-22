package ru.job4j.search;

/**
 * Class User
 *
 * @author Konstantin Inozemcev (9715791@gmail.com)
 * @version $Id$
 * @since 0.1
 */
public class User {
    /**
     * Id пользователя.
     */
    private int id;

    /**
     * Имя пользователя.
     */
    private String name;

    /**
     * Город
     */
    private String city;

    /**
     * Конструктор - создание нового объекта с параметрами
     *
     * @param name       - имя
     * @param desc - описание заявки
     */


    /**
     * Конструктор - создание нового объекта с параметрами
     */
    public User() {
    }

    /**
     * Конструктор - создание нового объекта с параметрами
     *
     * @param id  - id пользователя
     * @param name - имя пользователя
     * @param city - город
     */
    public User(int id, String name, String city) {
        this.id = id;
        this.name = name;
        this.city = city;
    }


    /**
     * Метод для получения значения поля id
     * @return id индификатор
     */
    public int getId() {
        return id;
    }

    /**
     * Метод для получения значения поля name
     * @return name имя
     */
    public String getName() {
        return name;
    }

    /**
     * Метод для получения значения поля city
     * @return city город
     */
    public String getCity() {
        return city;
    }
}
