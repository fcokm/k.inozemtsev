package ru.job4j.generic;


import java.util.Iterator;
import java.util.NoSuchElementException;


/**
 * Class SimpleArray класс реализует простой контейнер элементов
 *
 * @author Konstantin Inozemcev (9715791@gmail.com)
 * @version $Id$
 * @since 0.1
 */

public class SimpleArray<T> {
    /**
     * Массив элементов
     */
    private Object[] objects;
    /**
     * Указатель списка
     */
    private int index = 0;

    /**
     * Конструктор - создание нового объекта с параметрами
     *
     * @param size размер списка.
     */
    public SimpleArray(int size) {
        this.objects = new Object[size];
    }

    /**
     * Метод добавляет элемент в список
     * @param value
     */
    public void add(T value) {
        this.objects[index++] = value;
    }

    /**
     * Метод возвращает элемент по индексу
     * @param index индекс элемента
     * @return элемент списка.
     */
    public T get(int index) {
        return (T) this.objects[index];
    }

    /**
     * Метод возвращает элемент по индексу
     * @param index индекс элемента
     * @param model элемент
     */
    public void set(int index, T model) {
        this.objects[index] = model;
    }

    /**
     * Метод удаляет  элемент по индексу из списка
     * @param index индекс элемента
     */
    public void delete(int index) {
        System.arraycopy(this.objects, index + 1, this.objects, index,
                this.objects.length - 1 - index);
        this.objects[this.objects.length - 1] = null;
    }

    /**
     * Метод возвращает итеретор
     * @return  итератор .
     */
    public Iterator<T> iterator() {
        return new SimpleArrayIterator();
    }

    /**
     * Class SimpleArrayIterator
     *
     * @author Konstantin Inozemcev (9715791@gmail.com)
     * @version $Id$
     * @since 0.1
     */
    private class SimpleArrayIterator implements Iterator<T> {
        private int position = 0;

        @Override
        public boolean hasNext() {
            if (objects.length == 0) {
                throw new NoSuchElementException();
            }
            return objects.length > position;
        }
        @Override
        public T next() {
            if (objects.length == 0 || !hasNext()) {
                throw new NoSuchElementException();
            }
         return (T) objects[position++];
        }
    }

}
