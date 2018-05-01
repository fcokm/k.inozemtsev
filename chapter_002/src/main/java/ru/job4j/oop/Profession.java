package ru.job4j.oop;

/**
 * Class Profession базовый класс профессий.
 *
 * @author Konstantin Inozemcev (9715791@gmail.com)
 * @version $Id$
 * @since 0.1
 */


public class Profession {
    /**
     * Поле имя.
     */
    protected String name;


    /**
     * Поле название профессии.  .
     */
    protected String profession;


    /**
     * Конструктор - создание нового объекта
     */

    public Profession() {

    }

    /**
     * Конструктор - создание нового объекта с параметрами
     *
     * @param name       - имя
     * @param profession - название профессии
     */
    public Profession(String name, String profession) {
        this.name = name;
        this.profession = profession;
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


    /**
     * Метод для получения значения поля profession
     *
     * @return profession профессия
     */
    public String getProfession() {
        return profession;
    }

    /**
     * Метод для присваивания  значения поля profession
     */
    public void setProfession(String profession) {
        this.profession = profession;
    }
}
