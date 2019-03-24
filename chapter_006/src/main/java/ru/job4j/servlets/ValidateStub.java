package ru.job4j.servlets;

import java.util.*;
import java.util.function.Function;

public class ValidateStub implements Validate<User> {
    private final Map<Integer, User> store = new HashMap<>();
    private int ids = 0;

    private final Map<String, Function<User, Boolean>> map = new HashMap<>();


    public ValidateStub() {
        init();
    }
    private void init() {
        map.put("add", add());
        map.put("delete", delete());
        map.put("update", update());
    }


    public boolean load(String key, User user) {
        return map.get(key).apply(user);
    }


    @Override
    public Function<User, Boolean> add() {
        return user -> {
            if (Objects.isNull(getLoginValid(user.getLogin(), user))) {
                user.setId(this.ids++);
                store.put(user.getId(), user);
                return true;
            }
            return false;
        };
    }


    @Override
    public Function<User, Boolean>  delete() {
        return user -> {
            int id = user.getId();
            if (Objects.nonNull(store.get(id))) {
                store.remove(id);
                return true;
            }
            return false;
        };
    }

    @Override
    public Function<User, Boolean> update() {
        return user -> {
            if (Objects.isNull(getLoginValid(user.getLogin(), user))) {
               store.put(user.getId(), user);
                return true;
            }
            return false;
        };
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
        return new ArrayList<User>(store.values());
    }

    public boolean findUserById(User user) {
        return Objects.isNull(store.get(user.getId()));
    }


}