package ru.job4j.thread;


import net.jcip.annotations.GuardedBy;
import net.jcip.annotations.ThreadSafe;
import java.util.HashSet;
import java.util.Set;

/**
 * Class UserStorage
 *
 * @author Konstantin Inozemcev (9715791@gmail.com)
 * @version $Id$
 * @since 0.1
 */
@ThreadSafe
public class UserStorage {
    /**
     *Контейнер для хранения пользователей
     */
    @GuardedBy("this")
    private final Set<User> users = new HashSet<>();

    /**
     * Метод добавляет  пользователя в контейнер.
     * @param user  пользователь
     */
    public synchronized boolean add(User user) {
        synchronized (this.users) {
            return users.add(user);
        }
    }

    /**
     * Метод обновляет пользователя в контейнере
     * @param user  пользователь
     * @return true если обновление выполнено
     */
    public synchronized boolean update(User user) {
        boolean flag = false;
        if (users.contains(user)) {
            users.remove(user);
            users.add(user);
            flag = true;
        }
        return flag;
    }

    /**
     * Метод удаляет пользователя из контейнера
     * @param user  пользователь
     * @return true если удаление  выполнено
     */
    public synchronized boolean delete(User user) {
        return users.remove(user);

    }

    /**
     * Метод удаляет пользователя из контейнера
     * @param fromId  id пользователя платильщика
     * @param toId  id пользователя  получателя
     * @param amount сумма
     * @throws TransferException
     */
    public synchronized void transfer(int fromId, int toId, int amount) throws TransferException {
        User usFrom, usTo;
        usFrom = findById(fromId);
        usTo = findById(toId);
        if (usFrom.getAmount() >= amount) {
            usFrom.DelAmount(amount);
            usTo.AddAmount(amount);
        } else {
            throw new TransferException("Not enough money for the transaction");
        }

    }

    /**
     * Метод возвращает пользователя по id
     * @param id  пользователя
     * @return user
     */
    public synchronized User findById(int id) {
        synchronized (this.users) {
            User user = null;
            for (User usr : users) {
                if (usr.getId() == id) {
                    user = usr;
                    break;
                }
            }
            return user;
        }
    }

}
