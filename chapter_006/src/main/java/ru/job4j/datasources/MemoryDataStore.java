package ru.job4j.datasources;

import ru.job4j.model.User;
import java.util.Collection;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;


/**
 * Enum MemoryDataStore
 */

public enum MemoryDataStore implements DataStore<User> {

    INSTANCE;

    private final Map<Integer, User> users = new ConcurrentHashMap<>();

    @Override
    public User add(User user) {
        users.put(user.getId(), user);
        return user;
    }

    @Override
    public void update(User user) {
        users.put(user.getId(), user);
    }

    @Override
    public void delete(int id) {
            users.remove(id);
    }

    @Override
    public Collection<User> findAll() {
        return users.values();
    }

    @Override
    public User findById(int id) {
        return users.get(id);
    }
}

