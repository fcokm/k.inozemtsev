package ru.job4j.db;

import lombok.extern.slf4j.Slf4j;
import org.hibernate.Session;
import org.hibernate.Transaction;
import ru.job4j.util.HibernateUtil;

import java.util.function.Function;


@Slf4j
public class DBWrapp {

    protected <T> T tx(final Function<Session, T> command) {
        final Session session = HibernateUtil
                .getSessionFactory()
                .openSession();
        final Transaction tx = session.beginTransaction();
        try {
            T rsl = command.apply(session);
            tx.commit();
            return rsl;
        } catch (final Exception e) {
            if (tx != null) {
                tx.rollback();
            }
            log.error(e.getMessage(), e);
            throw e;
        } finally {
            if (session != null) {
                session.close();
            }
        }
    }


}
