package ru.job4j.service;

import lombok.extern.slf4j.Slf4j;
import org.hibernate.Session;
import org.hibernate.Transaction;
import ru.job4j.model.Item;
import ru.job4j.util.HibernateUtil;
import java.util.ArrayList;
import java.util.List;


@Slf4j
public class DBStorage {
    private static final DBStorage INSTANCE = new DBStorage();
    public static DBStorage getInstance() {
        return INSTANCE;
    }


    public Item addOrUpdate(Item item) {
        Transaction transaction = null;
        Session session = HibernateUtil
                .getSessionFactory()
                .openSession();
        try {
            transaction = session.beginTransaction();
            session.saveOrUpdate(item);
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            log.error(e.getMessage(), e);
        } finally {
            if (session != null) {
                session.close();
            }
        }
        return item;
    }

    public List<Item> allItem() {
        List<Item> itemList = new ArrayList();
        Transaction transaction = null;
        Session session = HibernateUtil
                .getSessionFactory()
                .openSession();
        try {
            session.beginTransaction();
            itemList = session.createQuery("FROM Item").list();
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            log.error(e.getMessage(), e);
        } finally {
            if (session != null) {
                session.close();
            }
        }
        return itemList;
    }
}