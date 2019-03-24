package ru.job4j.servlets;

import java.util.*;
import java.util.function.Function;


/**
 * Class ValidateService
 *
 * @author Konstantin
 * @version $Id$
 * @since 0.1
 */

public enum ValidateService implements Validate<User> {

    INSTANCE;

    private final DataStore dataStore = DbStore.getInstance();
    private final Map<String, Function<User, Boolean>> map = new HashMap<>();

    public static Validate getInstance() {
        return INSTANCE;
    }

    private void init() {
        map.put("add", add());
        map.put("delete", delete());
        map.put("update", update());
    }

    ValidateService() {
        init();
    }


    @Override
    public boolean load(String key, User user) {
        return map.get(key).apply(user);
    }

    @Override
    public Function<User, Boolean> add() {
        return user -> {
            if (Objects.isNull(getLoginValid(user.getLogin(), user))) {
                dataStore.add(user);
                return true;
            }
           return false;
        };
    }


    @Override
    public Function<User, Boolean> delete() {
        return user -> {
            int id = user.getId();
            if (Objects.nonNull(dataStore.findById(id))) {
                dataStore.delete(id);
                return true;
            }
            return false;
        };
    }

    @Override
    public Function<User, Boolean> update() {
        return user -> {
            if (Objects.isNull(getLoginValid(user.getLogin(), user))) {
                dataStore.update(user);
                return true;
            }
            return false;
        };
    }


    public User getValidUser(String login, String password) {
        User user = getAll().stream()
                .filter(usr -> usr.getLogin().equals(login) &&
                        usr.getPassword().equals(password))
                .findFirst()
                .orElse(null);
        return user;
    }

    public User getLoginValid(String login, User us) {
        User user = null;
        if(!login.equals(us.getUpdateLogin())) {
             user = getAll().stream()
                    .filter(usr -> (usr.getLogin().equals(login)))
                    .findFirst()
                    .orElse(null);
        }
        return user;

    }


    public List<User> getAll() {
        return dataStore.findAll();
    }

    public boolean findUserById(User user) {
        return Objects.isNull(dataStore.findById(user.getId()));
    }


}

