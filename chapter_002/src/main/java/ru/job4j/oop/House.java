package ru.job4j.oop;


/**
 *  Class House
 *
 * @author Konstantin Inozemcev (9715791@gmail.com)
 * @version $Id$
 * @since 0.1
 */


public class House  {
    /**
     * Поле название дома.
     */
    private String name;

    public House(String name) {
        this.name = name;
    }

    /**
     * Метод для получения значения поля name
     *
     * @return name имя
     */

    public String getName() {
        return name;
    }

    /**
     * Метод для присваивания  значения поля name
     */
    public void setName(String name) {
        this.name = name;
    }
}
