package ru.job4j.generic;

/**
 * Interface Store
 *
 * @author Konstantin Inozemcev (9715791@gmail.com)
 * @version $Id$
 * @since 0.1
 */
public interface Store<T extends Base> {
    /**
     * Метод добавляет элемент в контейнер
     * @param model объект.
     */
    void add(T model);

    /**
     * Метод заменяет  элемент в контейнер с найденным id
     * на указанный элемент
     * @param id  индефикатор объекта для замены.
     * @param model объект
     * @return возвращает true если объект с данным id
     * заменен , false элемент не найден.
     */
    boolean replace(String id, T model);


    /**
     * Метод удаляет  элемент из контейнер по указанному id
     * @param id  индефикатор объекта для замены.
     * @return возвращает true если объект с данным id
     * удален, false элемент не найден.
     */
    boolean delete(String id);


    /**
     * Метод возвращает  элемент из контейнер по указанному id
     * @param id  индефикатор объекта для замены.
     * @return найденый объект.
     */
    T findById(String id);
}
