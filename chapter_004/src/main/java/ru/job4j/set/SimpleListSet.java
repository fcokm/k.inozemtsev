package ru.job4j.set;
import ru.job4j.list.SimpleLinkedList;
import java.util.Iterator;


/**
 *  Class SimpleListSet класс реализует множество на связном списке
 *
 * @author Konstantin Inozemcev (9715791@gmail.com)
 * @version $Id$
 * @since 0.1
 */
public class SimpleListSet<E> {
    /**
     * Ссылка на контейнер
     */
    private SimpleLinkedList simpleSet;

    /**
     * Конструктор - создание нового объекта
     */
    public SimpleListSet() {
        simpleSet = new SimpleLinkedList();
    }

    /**
     * Метод добавляет элемент в множество
     * @param e элемент
     */
    public void add(E e) {
        if (!contains(e)) {
            simpleSet.add(e);
        }
    }

    /**
     * Метод проверяет , содержит множество элемент e
     * @param e   элемента
     * @return true если содержит, false нет.
     */
    public boolean contains(E e) {
      return simpleSet.contains(e);
    }


    /**
     * Метод возвращает итеретор
     * @return  итератор .
     */
    public Iterator<E> iterator() {
        return simpleSet.iterator();
    }


}
