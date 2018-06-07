package ru.job4j.thread;

import net.jcip.annotations.GuardedBy;
import net.jcip.annotations.ThreadSafe;


/**
 * Class User
 *
 * @author Konstantin Inozemcev (9715791@gmail.com)
 * @version $Id$
 * @since 0.1
 */
@ThreadSafe
public class User {
    private int id;
    @GuardedBy("this")
    private  int amount;

    /**
     * Конструктор - создание нового объекта с параметрами
     *
     * @param id
     *  @param amount сумма денег на счете пользователя
     */
    public  User(int id, int amount) {
        this.id = id;
        this.amount = amount;
    }

    /**
     * Метод возвращает сумма денег на счету пользователя.
     * @return  amount
     */
    public synchronized  int getAmount() {
        return amount;
    }

    /**
     * Метод возвращает id пользователя
     * @return  id
     */
    public int getId() {
        return id;
    }

    /**
     * Метод возвращает id пользователя
     * @return  id
     */
    public synchronized void setAmount(int amount) {
        this.amount = amount;
    }

    /**
     * Метод списывает средства со счета пользователя
     * @return  amount
     */
    public synchronized void DelAmount(int amount) {
        this.amount = this.amount - amount;
    }

    /**
     * Метод добавляет средства на счет пользователя
     * @param amount  сумма
     */
    public synchronized void AddAmount(int amount) {
        this.amount = this.amount + amount;
    }

}
