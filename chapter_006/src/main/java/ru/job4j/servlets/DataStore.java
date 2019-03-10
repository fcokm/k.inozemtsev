package ru.job4j.servlets;

import java.util.Collection;

/**
 * interface DataStore
 *
 * @author Konstantin Inozemcev (9715791@gmail.com)
 * @version $Id$
 * @since 0.1
 */
public interface DataStore<T> {

    T add(T data);

    void update(T data);

    void delete(int id);

    Collection<T> findAll();

    T findById(int id);
}

