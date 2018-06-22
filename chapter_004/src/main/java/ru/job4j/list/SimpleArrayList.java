package ru.job4j.list;

import net.jcip.annotations.ThreadSafe;

/**
 *  Class SimpleArrayList класс реализует односвязный список
 *
 * @author Konstantin Inozemcev (9715791@gmail.com)
 * @version $Id$
 * @since 0.1
 */
@ThreadSafe
public class SimpleArrayList<E> {
    /**
     * Размер списка
     */
    private int size;
    /**
     * Ссылка на объект первого элемента
     */
    private Node<E> first;


    /**
     * Метод вставляет в начало списка данные.
     */
    public void add(E date) {
        Node<E> newLink = new Node<>(date);
        newLink.next = this.first;
        this.first = newLink;
        this.size++;
    }

    /**
     *  Метод удаляет первый элемент списка.
     */
    public E delete() {
        Node<E> result = this.first;
        Node<E>  next = result.next;
        this.first =next;
        return (E)  this.first;
    }

    /**
     * Метод возвращает элемент по индексу.
     */
    public E get(int index) {
        Node<E> result = this.first;
        for (int i = 0; i < index; i++) {
            result = result.next;
        }
        return result.date;
    }

    /**
     * Метод возвращает размер коллекции.
     */
    public int getSize() {
        return this.size;
    }

    /**
     * Класс предназначен для хранения данных.
     */
    private static class Node<E> {
        E date;
        Node<E> next;

        Node(E date) {
            this.date = date;
        }
    }

}
