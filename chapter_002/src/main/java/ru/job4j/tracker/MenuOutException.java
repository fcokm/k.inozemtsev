package ru.job4j.tracker;


/**
 * Class MenuOutException реализует обработку ошибок ввода
 * пользователем в меню
 * @author Konstantin Inozemcev (9715791@gmail.com)
 * @version $Id$
 * @since 0.1
 */

public class MenuOutException extends  RuntimeException {
    /**
     * Переопределение конструктора родительского класса
     * @param msg  строка сообщение об ошибке .
     */
    public MenuOutException(String msg) {
        super(msg);
    }
}
