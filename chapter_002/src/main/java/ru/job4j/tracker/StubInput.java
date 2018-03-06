package ru.job4j.tracker;


/**
 * Class StartInput реализует функционал поведения пользователя
 * @author Konstantin Inozemcev (9715791@gmail.com)
 * @version $Id$
 * @since 0.1
 */

public class StubInput implements Input {

    /**
     * Поле содержит последовательность ответов пользователя.
     */
    private final String[] value;

    /**
     * Поле считает количество вызовов метода ask.
     */
    private int position;

    /**
     * Конструктор - создание нового объекта с параметрами
     * @param  value массив строк с вводом данных пользователя
     */

    public StubInput(final String[] value) {
        this.value = value;
    }

    /**
     * Метод последовательно возвращает ответы пользователя
     *@param question строка с запросом для пользователя
     *@return строка с данными от пользователя
     */
    @Override
    public String ask(String question) {
        return this.value[this.position++];
    }
}
