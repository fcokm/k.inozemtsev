package ru.job4j.tracker;


/**
 * Interface Input
 *
 * @author Konstantin Inozemcev (9715791@gmail.com)
 * @version $Id$
 * @since 0.1
 */

public interface Input {

    /**
     * Метод получает данные от пользователя.
     *
     * @param question стока с запросом для пользователя
     * @return строка с полученным данными от пользователя
     */
    String ask(String question);

    /**
     * Метод получает данные от пользователя.
     *
     * @param question стока с запросом для пользователя
     * @param range  массив выбора возможных пунктов меню
     * @return строка с полученным данными от пользователя
     */
    public int ask(String question, int[] range);

}
