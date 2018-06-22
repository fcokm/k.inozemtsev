package ru.job4j.tracker;


/**
 * Class ValidateInput реализует функционал проверки данных
 * введенных пользователем
 * @author Konstantin Inozemcev (9715791@gmail.com)
 * @version $Id$
 * @since 0.1
 */

public class ValidateInput implements Input {

    /**
     * Получение данных от пользователя.
     */
    private final Input input;


    /**
     * Конструтор инициализирующий поля.
     *
     * @param input   ввод данных.
     */
    public ValidateInput(final Input input) {
        this.input = input;
    }

    @Override
    public String ask(String question) {
        return this.input.ask(question);
    }


    /**
     * Метод получает данные от пользователя и проверяет
     * их корректность.
     * @param question стока с запросом для пользователя
     * @param range    массив выбора возможных пунктов меню
     * @return значение пункта меню.
     */
    public int ask(String question, int[] range) {
        boolean invalid = false;
        int value = -1;
        while (!invalid) {
            try {
                value = this.input.ask(question, range);
                invalid = true;
            } catch (MenuOutException moe) {
                System.out.println("Выбирете значение пункта из меню!");
            } catch (NumberFormatException nfe) {
                System.out.println("Введите корректное значение пункта из меню!");
            }
        }
        return value;
    }
}
