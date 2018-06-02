package ru.job4j.generic;


/**
 *  Class Base
 *
 * @author Konstantin Inozemcev (9715791@gmail.com)
 * @version $Id$
 * @since 0.1
 */
public abstract class Base {
    /**
     * id объекта
     */
    private final String id;

    protected Base(final String id) {
        this.id = id;
    }

    /**
     * Метод получения id объекта
     * @return id
     */
    public String getId() {
        return id;
    }
}
