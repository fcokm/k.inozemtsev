package ru.db;

import ru.domain.User;

import java.util.Collection;
import java.util.List;

public interface Storage {

     User add(User user);

     int update(User user);

     void deleteById(int id);

     User findById(int id);

     List<User> findAll();

}


