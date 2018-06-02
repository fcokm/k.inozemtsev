package ru.job4j.list;

import java.util.*;

/**
 *  Class SimpleLinkedList класс реализует  контейнер на базе
 *  связанного списка
 *
 * @author Konstantin Inozemcev (9715791@gmail.com)
 * @version $Id$
 * @since 0.1
 */
public class SimpleLinkedList<E> implements SimpleContainer<E> {
    /**
     * Ссылка на объект первого элемента
     */
    private Node<E> first;
    /**
     * Счетчик изменений списка
     */
    private int modCount;
    /**
     * Размер списка
     */
    private int size;

    /**
     * Метод добавляет элемент в список
     * @param e элемент
     */
    public void add(E e) {
        Node<E> newNote = new Node<>();
        newNote.data = e;
        if (first == null) {
            first = newNote;
        } else {
            newNote.next = first;
            first = newNote;
        }
        modCount++;
        size++;
    }

    /**
     * Метод возвращает элемент по индексу
     * @param index индекс элемента
     * @return элемент списка.
     */
    public E get(int index) {
        Node<E> x = first;
        for (int i = 0; i < index; i++) {
            x = x.next;
        }
        return  x.data;
    }

    /**
     * Метод проверяет , содержит список элемент e
     * @param e   элемента
     * @return true если содержит, false нет.
     */
    public boolean contains(E e) {
        boolean flag = false;
        Iterator<E> it = this.iterator();
        while (it.hasNext()) {
            if (it.next().equals(e)) {
                flag = true;
                break;
            }
        }
        return flag;
    }


    /**
     * Класс предназначен для хранения данных.
     */
    private static class Node<E> {
        Node<E> next;
        E data;
    }

    /**
     * Метод возвращает итеретор
     * @return  итератор .
     */
    public Iterator<E> iterator() {
        return new SimpleListIterator();
    }

    /**
     * Class SimpleListIterator
     *
     * @author Konstantin Inozemcev (9715791@gmail.com)
     * @version $Id$
     * @since 0.1
     */
    private  class SimpleListIterator implements Iterator<E> {
        /**
         * Ссылка на объект первого элемента
         */
        private Node<E> nextNode = first;
        /**
         * Элемент списка
         */
        private  E data;

        /**
         * Указатель итератора
         */
        private int position;

        /**
         * Счетчик изменений списка
         */
        int expectedModCount = modCount;

        /**
         * Метод проверяет , есть следующий элемент в контейнере
         * @return true если существует, в противном случае false.
         */
        @Override
        public boolean hasNext() {
            return position < size;
        }

        /**
         * Метод вовращает  следующий элемент в контейнере
         * @return следующий элемент в контейнере.
         * @throws NoSuchElementException если в контейнере нет элементов.
         */
        @Override
        public E next() {
            if (!hasNext()) {
                throw new NoSuchElementException();
            }
            if(modCount != expectedModCount) {
                throw new ConcurrentModificationException();
            }
            position++;
            data = nextNode.data;
            nextNode = nextNode.next;
            return data;
        }
    }

}
