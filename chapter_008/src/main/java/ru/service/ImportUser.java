package ru.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import ru.db.Storage;
import ru.domain.User;

import java.util.List;

@Service
public class ImportUser {

    private Storage storage;
    @Autowired
    public ImportUser(@Qualifier("memory")Storage storage) {
        this.storage = storage;
    }

    public void add(User user) {
        storage.add(user);
    }

    public void update(User user) {
        storage.update(user);
    }

    public void delete(int id) {
        storage.deleteById(id);
    }

    public User findById(int id) {
       return storage.findById(id);
    }
    public List<User> all() {
        return storage.findAll();
    }
}
