package ru.job4j.search;

/**
 * Class Person реализует телефонный справочник
 *
 * @author Konstantin Inozemcev (9715791@gmail.com)
 * @version $Id$
 * @since 0.1
 */

public class Person {

    /**
     * Имя пользователя.
     */
    private String name;

    /**
     * Фамилия пользователя.
     */
    private String surname;

    /**
     * Телефон пользователя.
     */
    private String phone;

    /**
     * Адрес пользователя.
     */
    private String address;


    /**
     * Конструктор - создание нового объекта с параметрами
     *
     * @param name - имя пользователя
     * @param surname - фамилия пользователя
     * @param phone - номер телефона пользователя
     * @param address - адрес пользователя
     */
    public Person(String name, String surname, String phone, String address) {
        this.name = name;
        this.surname = surname;
        this.phone = phone;
        this.address = address;
    }

    /**
     * Метод для получения значения поля name
     * @return name имя
     */
    public String getName() {
        return name;
    }

    /**
     * Метод для получения значения поля surname
     * @return profession фамилия
     */
    public String getSurname() {
        return surname;
    }

    /**
     * Метод для получения значения поля phone
     * @return phone номер телефона
     */
    public String getPhone() {
        return phone;
    }

    /**
     * Метод для получения значения поля address
     * @return address адрес
     */
    public String getAddress() {
        return address;
    }
}