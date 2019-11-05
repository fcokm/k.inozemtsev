package ru.db;

import org.springframework.stereotype.Component;
import ru.domain.User;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

@Component("memory")
public class MemoryStorage implements Storage {
    private final Map<Integer, User> users = new ConcurrentHashMap<>();
    private int id = 1;

    @Override
    public User add(User user) {
        user.setId(id++);
        users.put(id, user);
        return user;
    }

    @Override
    public int update(User user) {
        return users
                .computeIfPresent(user.getId(),(k, v) -> user)
                .getId();
    }

    @Override
    public void deleteById(int id) {
      users.remove(id);

    }

    @Override
    public User findById(int id) {
        return users.get(id);
    }

    @Override
    public List<User> findAll() {
        return   new ArrayList<>(users.values());
    }
}
