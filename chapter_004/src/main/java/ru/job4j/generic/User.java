package ru.job4j.generic;


/**
 * Class User
 *
 * @author Konstantin Inozemcev (9715791@gmail.com)
 * @version $Id$
 * @since 0.1
 */
public class User extends Base {
    protected User(String id) {
        super(id);
    }

    @Override
    public String toString() {
        return getId();
    }
}
