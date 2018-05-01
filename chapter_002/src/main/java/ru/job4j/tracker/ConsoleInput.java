package ru.job4j.tracker;

import java.util.Scanner;


/**
 * Class ConsoleInput реализует функционал ввода пользовательских
 * данных из консоли
 *
 * @author Konstantin Inozemcev (9715791@gmail.com)
 * @version $Id$
 * @since 0.1
 */


public class ConsoleInput implements Input {

    private Scanner scanner = new Scanner(System.in);

    /**
     * Метод получает данные от пользователя.
     *
     * @param question стока с запросом для пользователя
     * @return строка с полученным данными от пользователя
     */
    public String ask(String question) {
        System.out.println(question);
        return scanner.nextLine();
    }


    /**
     * Метод получает данные от пользователя и проверяет
     * их корректность.
     * @param question стока с запросом для пользователя
     * @param range    массив выбора возможных пунктов меню
     * @return значение пункта меню.
     */
    public int ask(String question, int[] range) {
        int key = Integer.valueOf(this.ask(question));
        boolean exist = false;
        for (int value : range) {
            if (value == key) {
                exist = true;
                break;
            }
        }
        if (exist) {
            return key;
        } else {
            throw new MenuOutException(" Пункт меню не соответствует диапазону.");
        }
    }
}
