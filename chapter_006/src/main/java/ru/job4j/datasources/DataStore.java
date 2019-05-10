package ru.job4j.datasources;

import java.util.Collection;

/**
 * interface DataStore
 */
public interface DataStore<T> {

    T add(T data);

    void update(T data);

    void delete(int id);

    Collection<T> findAll();

    T findById(int id);
}

