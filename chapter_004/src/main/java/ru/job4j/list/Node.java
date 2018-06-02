package ru.job4j.list;

/**
 *  Class Node
 *
 * @author Konstantin Inozemcev (9715791@gmail.com)
 * @version $Id$
 * @since 0.1
 */
public class Node<T> {
    /**
     * Значение узла
     */
    T value;
    /**
     * Ссылка на объект следующий элемента узла
     */
     Node<T> next;


    /**
     * Конструктор - создание нового объекта с параметрами
     *
     * @param value значение узла
     */
    public Node(T value) {
        this.value = value;
    }

    /**
     * Метод определяющий, что список содержит замыкания
     * @param first ссылка на узел
     * @return  true если список содержит замыкания,
     * в противном случае false.
     */
    public static boolean hasCycle(Node first) {
        Node turtle = first;
        Node hare = first;

        while (hare != null && hare.next != null) {
            turtle = turtle.next;
            hare = hare.next.next;
            if (turtle == hare) {
                return true;
            }
        }
        return false;
    }

}
