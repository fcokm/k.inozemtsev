package ru.job4j.list;


import java.util.*;

/**
 * Class SimpleQueue класс реализует очередь  на базе связанного списка
 *
 * @author Konstantin Inozemcev (9715791@gmail.com)
 * @version $Id$
 * @since 0.1
 */
public class SimpleQueue<T> {
    /**
     * Ссылка на контейнер
     */
    private SimpleLinkedList<T> linkedList;

    /**
     * Размер очереди
     */
    private int size;

    /**
     * Указатель на объект первого элемента очереди
     */
    int head;
    /**
     * Указатель на объект последнего элемента очереди
     */
    int tail;

    /**
     * Конструктор - создание нового объекта
     */
    public SimpleQueue() {
        linkedList = new SimpleLinkedList<>();
        head = -1;
        tail = -1;
        size = 0;
    }

    /**
     * Метод проверяет есть ли элементы в очереде
     *
     * @return true если да , в противном случае false
     */
    public boolean isEmpty() {
        return size == 0;
    }

    /**
     * Метод возвращает значение и удаляет первый элемент очереди
     * @return элемент очереди
     */
    public T poll() {
        if (isEmpty()) {
          throw  new NoSuchElementException();
        }
        T data = linkedList.get(head--);
        size--;
        return data;
    }

    /**
     * Метод возвращает значение и удаляет последний элемент
     * очереди
     * @return элемент очереди
     */
    public T lastPoll() {
        if (isEmpty()) {
            throw  new NoSuchElementException();
        }
        T data = linkedList.get(tail);
        tail++;
        size--;
        if (isEmpty()) {
            head = -1;
            tail = -1;
        }
        return data;
    }

    /**
     * Метод добавляет элемент в очередь
     * @param value элемент
     */
    public void push(T value) {
        if (isEmpty()) {
        }
        linkedList.add(value);
      size++;
      head++;;
    }



}
