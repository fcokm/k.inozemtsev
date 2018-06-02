package ru.job4j.list;


import java.util.NoSuchElementException;
import java.util.Stack;

/**
 *  Class SimpleStack класс реализует стек  на базе связанного списка
 *
 * @author Konstantin Inozemcev (9715791@gmail.com)
 * @version $Id$
 * @since 0.1
 */
public class SimpleStack<T> {
    /**
     * Ссылка на контейнер
     */
    private SimpleLinkedList<T> linkedList;
    /**
     * Размер стека
     */
    private int size;
    /**
     * Указатель стека
     */
    private int pointer;

    /**
     * Конструктор - создание нового объекта
     */
    public SimpleStack() {
        linkedList =new SimpleLinkedList<>();
        size = 0;
        pointer = 0;
    }

    /**
     * Метод возвращает значение и удаляет его из стека
     * @return элемент стека
     */
    public T poll() {
        if (isEmpty()) throw new NoSuchElementException();
       T data = linkedList.get(pointer++);
        size--;
        return data;
    }

    /**
     * Метод добавляет элемент в стек
     * @param value элемент
     */
    public void push(T value) {
        linkedList.add(value);
        size++;
    }


    /**
     * Метод проверяет есть ли элементы в стеке
     * @return true если да , в противном случае false
     */
    public boolean isEmpty() {
        return size == 0;
    }


}


