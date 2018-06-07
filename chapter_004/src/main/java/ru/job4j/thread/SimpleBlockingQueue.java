package ru.job4j.thread;

import net.jcip.annotations.GuardedBy;
import net.jcip.annotations.ThreadSafe;

import java.util.LinkedList;
import java.util.Queue;

/**
 *  Class SimpleBlockingQueue класс реализует блокирующую очередь.
 *
 * @author Konstantin Inozemcev (9715791@gmail.com)
 * @version $Id$
 * @since 0.1
 */
@ThreadSafe
public class SimpleBlockingQueue<T> {
    /**
     *Очередь для хранения элементов
     */
    @GuardedBy("this")
    private final Queue<T> queue = new LinkedList<>();
    /**
     *Размер блокирующей очереди.
     */
    @GuardedBy("this")
    private int capacity;

    /**
     * Конструктор - создание нового объекта с параметрами
     * @param capacity размер блокирующей очереди.
     */
    public SimpleBlockingQueue(int capacity) {
        this.capacity = capacity;
    }


    /**
     * Метод добавляет элемент в  блокирующую очередь
     * @param value
     */
    public synchronized void offer(T value) {
        synchronized (this.queue) {
            while (this.queue.size() >= this.capacity) {
                try {
                    queue.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            queue.offer(value);
            queue.notify();
        }

    }


    /**
     * Метод возвращает  элемент из   блокирующую очередь
     * @return value элемент блокирующей очереди
     */
    public T poll() {
        synchronized (this.queue) {
            T value = null;
            while (queue.isEmpty()) {
                try {
                    queue.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            value = queue.poll();
            queue.notify();
            return value;
        }
    }

    /**
     * Метод возвращает размер блокирующей очереди
     * @return size
     */
  public   int size() {
        return queue.size();
    }
}
