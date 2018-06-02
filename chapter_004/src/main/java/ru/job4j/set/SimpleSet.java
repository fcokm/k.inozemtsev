package ru.job4j.set;

import ru.job4j.list.SimpleList;
import java.util.*;

/**
 *  Class SimpleSet класс реализует множество  на массиве
 *
 * @author Konstantin Inozemcev (9715791@gmail.com)
 * @version $Id$
 * @since 0.1
 */
public class SimpleSet<T> {
    /**
     * Ссылка на контейнер
     */
    private SimpleList simpleList;

    /**
     * Конструктор - создание нового объекта
     */
    public SimpleSet() {
        simpleList = new SimpleList();
    }

    /**
     * Метод добавляет элемент в множество
     * @param e элемент
     */
    public void add(T e) {
        if (!contains(e)) {
            simpleList.add(e);
        }
    }

    /**
     * Метод проверяет , содержит множество элемент e
     * @param e   элемента
     * @return true если содержит, false нет.
     */
    public boolean contains(T e) {
       return simpleList.contains(e);
    }

    /**
     * Метод возвращает итеретор
     * @return  итератор .
     */
    public Iterator<T> iterator() {
        return simpleList.iterator();
    }

    public static void main(String[] args) {
        SimpleSet set = new SimpleSet();
        set.add(1);

    }



}
