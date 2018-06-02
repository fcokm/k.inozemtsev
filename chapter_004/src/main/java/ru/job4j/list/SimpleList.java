package ru.job4j.list;

import net.jcip.annotations.GuardedBy;
import net.jcip.annotations.ThreadSafe;

import java.util.*;

/**
 * Class SimpleList класс реализует  динамический список на базе массива
 *
 * @author Konstantin Inozemcev (9715791@gmail.com)
 * @version $Id$
 * @since 0.1
 */
@ThreadSafe
public class SimpleList<E> implements SimpleContainer<E> {
    /**
     * Массив элементов
     */
    @GuardedBy("this")
    private Object[] container = new Object[10];
    /**
     * Указатель списка
     */
    @GuardedBy("this")
    private int position;

    /**
     * Счетчик изменений списка
     */
    @GuardedBy("this")
    private int modCount;

    /**
     * Размер списка
     */
    @GuardedBy("this")
    private int size;

    /**
     * Метод добавляет элемент в список
     *
     * @param e элемент
     */
    public synchronized void add(E e) {
        if (position == container.length - 1) {
            resize(container.length * 2);
        }
        modCount++;
        size++;
        container[position++] = e;
    }

    /**
     * Метод возвращает элемент по индексу
     *
     * @param index индекс элемента
     * @return элемент списка.
     */
    @SuppressWarnings("unchecked")
    public synchronized E get(int index) {
        return (E) container[index];
    }


    /**
     * Метод проверяет , содержит список элемент e
     *
     * @param e элемента
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


    public synchronized int getSize() {
        return size;
    }

    /**
     * Метод увеличивает размер массива элементов
     *
     * @param newLength размер
     */
    private synchronized void resize(int newLength) {
        Object[] newContainer = new Object[newLength];
        System.arraycopy(container, 0, newContainer, 0, position);
        container = newContainer;
    }

    /**
     * Метод возвращает итеретор
     *
     * @return итератор .
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
    private class SimpleListIterator implements Iterator<E> {
        /**
         * Указатель итератора
         */
        @GuardedBy("this")
        private int index = 0;

        /**
         * Счетчик изменений списка
         */
        @GuardedBy("this")
        int expectedModCount = modCount;


        /**
         * Метод проверяет , есть следующий элемент в контейнере
         *
         * @return true если существует, в противном случае false.
         */
        @Override
        public synchronized boolean hasNext() {
            synchronized (SimpleList.this) {
                return position > index;
            }
        }

        /**
         * Метод вовращает  следующий элемент в контейнере
         *
         * @return следующий элемент в контейнере.
         * @throws NoSuchElementException если в контейнере нет элементов.
         */
        //this.checkModification(DynamicLinkedContainer.this.modCount);
        @Override
        @SuppressWarnings("unchecked")
        public synchronized E next() {
            synchronized (SimpleList.this) {
                if (container.length == 0 || !hasNext()) {
                    throw new NoSuchElementException();
                }
                if (position >= container.length || modCount != expectedModCount) {
                    throw new ConcurrentModificationException();
                }
                return (E) container[index++];
            }
        }
    }
}
