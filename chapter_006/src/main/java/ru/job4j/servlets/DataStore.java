package ru.job4j.servlets;

import java.util.Collection;

/**
 * interface DataStore
 *
 * @author Konstantin Inozemcev (9715791@gmail.com)
 * @version $Id$
 * @since 0.1
 */
public interface DataStore {

    void add(User user);

    void update(User user);

    void delete(int id);

    Collection<User> findAll();

    User findById(int id);
}

