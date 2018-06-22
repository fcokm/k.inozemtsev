package ru.job4j.search;

import java.util.ArrayList;
import java.util.LinkedList;

/**
 * Class Task  класс реализует задачу
 *
 * @author Konstantin Inozemcev (9715791@gmail.com)
 * @version $Id$
 * @since 0.1
 */
public class Task {
    /**
     * Описание задачи.
     */
    private String desc;

    /**
     * Приоритет задачи.
     */
    private int priority;


    /**
     * Конструктор - создание нового объекта с параметрами
     *
     * @param desc  описание задачи
     * @param priority - приоритет задачи
     */
    public Task(String desc, int priority) {
        this.desc = desc;
        this.priority = priority;
    }

    /**
     * Метод для получения значения поля desc
     * @return desc описание задачи
     */
    public String getDesc() {
        return desc;
    }

    /**
     * Метод для получения значения поля priority
     * @return priority приоритет задачи
     */
    public int getPriority() {
        return priority;
    }

}
