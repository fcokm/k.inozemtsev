package ru.job4j.db;

import lombok.extern.slf4j.Slf4j;
import ru.job4j.model.*;
import java.util.Collection;



@Slf4j
public class DBStorage  extends DBStoreWrapper{
    private static final DBStorage INSTANCE = new DBStorage();

    public static DBStorage getInstance() {
        return INSTANCE;
    }


    public Collection<Item> allItem() {
        return super.tx(
                session -> session.createQuery("from Item").list()
        );
    }

    public Item addOrUpdate(final Item item) {
        return super.tx(
                session -> {
                    session.saveOrUpdate(item);
                    return item;
                }
        );
    }

}