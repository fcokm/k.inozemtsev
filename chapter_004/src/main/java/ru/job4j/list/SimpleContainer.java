package ru.job4j.list;


/**
 * Interface SimpleContainer
 *
 * @author Konstantin Inozemcev (9715791@gmail.com)
 * @version $Id$
 * @since 0.1
 */
public interface SimpleContainer<E> extends Iterable<E> {
    /**
     * Метод добавляет элемент в список
     * @param e элемент
     */
    void add(E e);

    /**
     * Метод возвращает элемент по индексу
     * @param index индекс элемента
     * @return элемент списка.
     */
    E get (int index);
}
