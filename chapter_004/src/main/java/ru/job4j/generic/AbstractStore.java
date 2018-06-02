package ru.job4j.generic;

import java.util.Iterator;

/**
 *  Class AbstractStore
 *
 * @author Konstantin Inozemcev (9715791@gmail.com)
 * @version $Id$
 * @since 0.1
 */

public abstract class AbstractStore <T extends Base> implements Store <T>  {
    /**
     * Контейнер для хранения объектов.
     */
    private SimpleArray<T> simpleArray = new SimpleArray<>(10);
    /**
     * Размер контейнера.
     */
    private int size;

    @Override
    public void add(T model) {
        simpleArray.add(model);
        size++;
    }

    @Override
    public boolean replace(String id, T model) {
        T item = null;
        int count = 0;
        boolean flag = false;
        Iterator<T> it = simpleArray.iterator();
        while (it.hasNext()) {
            item = it.next();
            if (item.getId().equals(id)) {
                simpleArray.set(count, model);
                flag = true;
                break;
            }
            count++;
        }
        return flag;
    }


    @Override
    public boolean delete(String id) {
        T item = null;
        int count = 0;
        boolean flag = false;
        Iterator<T> it = simpleArray.iterator();
        while (it.hasNext()) {
            item = it.next();
            if (item.getId().equals(id)) {
                simpleArray.delete(count);
                flag = true;
                size--;
                break;
            }
            count++;
        }
        return flag;
    }

    /**
     * Метод добавляет элемент в контейнер
     * @return  возвращает размер контейнера.
     */
    public int getSize() {
        return size;
    }

    @Override
    public T findById(String id) {
        T item = null;
        Iterator<T> it = simpleArray.iterator();
        while (it.hasNext()) {
            item = it.next();
            if (item.getId().equals(id)) {
                break;
            }
        }
        return item;
    }

}
