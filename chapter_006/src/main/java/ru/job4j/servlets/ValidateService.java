package ru.job4j.servlets;

import java.util.Collection;
import java.util.Collections;


/**
 * Class ValidateService
 *
 * @author Konstantin
 * @version $Id$
 * @since 0.1
 */

public enum ValidateService {

    INSTANCE;

    private final DataStore dataStore = MemoryDataStore.INSTANCE;

    public boolean add(User user) {
        if (dataStore.findById(user.getId()) == null) {
            dataStore.add(user);
            return true;
        }
        return false;
    }

    public boolean update(User user) {
        if (dataStore.findById(user.getId()) != null) {
            dataStore.update(user);
            return true;
        }
        return false;
    }

    public boolean delete(int id) {
        if (dataStore.findById(id) != null) {
            dataStore.delete(id);
            return true;
        }
        return false;
    }

    public Collection<User> findAll() {
        if (!dataStore.findAll().isEmpty()) {
            return dataStore.findAll();
        }
        return Collections.EMPTY_LIST;
    }

}

