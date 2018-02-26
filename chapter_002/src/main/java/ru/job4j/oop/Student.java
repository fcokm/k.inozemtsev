package ru.job4j.oop;

/**
 *  Class Student
 *
 * @author Konstantin Inozemcev (9715791@gmail.com)
 * @version $Id$
 * @since 0.1
 */


public class Student {
    /**
     * Поле имя.
     */
    private String name;

    public Student() {

    }

    public Student(String name) {
        this.name = name;
    }

    /**
     * Метод для присваивания  значения поля name
     */
    public void setName(String name) {
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
}
