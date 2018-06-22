package ru.job4j.tracker;


/**
 * Class BaseAction  реализует интерфес  UserAction
 *
 * @author Konstantin Inozemcev (9715791@gmail.com)
 * @version $Id$
 * @since 0.1
 */

public abstract class BaseAction implements UserAction {
    private final int key;
    private final String name;

    /**
     * Конструктор - создание нового объекта с параметрами
     *
     * @param key   ключ на событие пользователя.
     * @param name строка с сообщением действий пользователя.
     */
    protected BaseAction(final int key, final String name) {
        this.key = key;
        this.name = name;
    }

    /**
     * Метод возвращает ключ на событие пользователя
     */
    @Override
    public int key() {
        return this.key;
    }

    /**
     * Метод сообщает пользователю какие действия выполняются
     * @return строка
     */
    @Override
    public String info() {
        return String.format("%s : %s", this.key, this.name);
    }
}










