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
}
