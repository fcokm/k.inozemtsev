package ru.job4j.servlets;

import java.util.List;
import java.util.function.Function;

public interface Validate<T> {

    Function<T, Boolean> add();

    Function<T, Boolean> delete();

    Function<T, Boolean> update();

    boolean load(String key, T model);

    boolean findUserById(T model);

    List<T> getAll();
}
