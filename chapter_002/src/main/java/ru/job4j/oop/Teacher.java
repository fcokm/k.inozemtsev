package ru.job4j.oop;

/**
 *  Class Teacher реализует профессию доктора
 *
 * @author Konstantin Inozemcev (9715791@gmail.com)
 * @version $Id$
 * @since 0.1
 */



public class Teacher extends Profession {


    /**
     * Конструктор - создание нового объекта
     */
    public Teacher() {

    }

    /**
     * Конструктор - создание нового объекта с параметрами
     *
     * @param name       - имя
     * @param profession - название профессии
     */
    public Teacher(String name, String profession) {
        super(name, profession);
    }

    /**
     * Метод возвращает строку
     *@param student студент
     *@return строка.
     */

    public String teachesStudent(Student student) {
        return this.profession + " " + this.name + " " + "обучает" + student.getName();
    }
}
