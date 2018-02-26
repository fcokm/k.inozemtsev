package ru.job4j.oop;


/**
 *  Class Engineer реализует профессию инженера
 *
 * @author Konstantin Inozemcev (9715791@gmail.com)
 * @version $Id$
 * @since 0.1
 */

public class Engineer extends Profession {


    /**
     * Конструктор - создание нового объекта
     */
    public Engineer() {
    }

    /**
     * Конструктор - создание нового объекта с параметрами
     *
     * @param name       - имя
     * @param profession - название профессии
     */
    public Engineer(String name, String profession) {
        super(name, profession);
    }

    /**
     * Метод возвращаеыт строку
     *
     *@return строка.
     */

    public String buildHouse(House house) {
        return this.profession + " " + this.name + " " + "строит"
               + " " + house.getName() + " "  + "дом.";
    }

}
