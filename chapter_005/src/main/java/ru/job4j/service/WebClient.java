package ru.job4j.service;

import unisoft.ws.FNSNDSCAWS2;
import unisoft.ws.FNSNDSCAWS2Port;
import unisoft.ws.fnsndscaws2.request.NdsRequest2;
import unisoft.ws.fnsndscaws2.request.NdsRequest2.NP;;
import unisoft.ws.fnsndscaws2.response.NdsResponse2;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;


/**
 * Class WebClient
 *
 * @author Konstantin Inozemcev (9715791@gmail.com)
 * @version $Id$
 * @since 0.1
 */
public class WebClient {

    /**
     * Объект получения значений  ввода пользователя
     */
    private static Scanner scanner = new Scanner(System.in);

    /**
     * Константа ввода значения ИНН.
     */
    private static final int INN = 1;

    /**
     * Константа ввода значения КПП.
     */
    private static final int KPP = 2;

    /**
     * Массив значение признака состояния контрагента.
     */
    private static final String[] STATES = {
            "Налогоплательщик зарегистрирован в ЕГРН и имел статус действующего в указанную дату",
            "Налогоплательщик зарегистрирован в ЕГРН, но не имел статус действующего в указанную дату",
            "Налогоплательщик зарегистрирован в ЕГРН",
            "Налогоплательщик с указанным ИНН зарегистрирован в ЕГРН, КПП не соответствует ИНН или не указан",
            "Налогоплательщик с указанным ИНН не зарегистрирован в ЕГРН",
            "Некорректный ИНН",
            "Недопустимое количество символов ИНН",
            "Недопустимое количество символов КПП",
            "Недопустимые символы в ИНН",
            "Недопустимые символы в КПП",
            "некорректный формат даты",
            "некорректная дата (ранее 01.01.1991 или позднее текущей даты)",
    };

    public static void main(String[] args) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd.MM.yyyy");
        String data = formatter.format(LocalDate.now());
        String inn = validateInput(INN);
        String kpp = validateInput(KPP);
        NP np = new NP();
        np.setINN(inn);
        np.setKPP(kpp);
        np.setDT(data);
        NdsRequest2 nr = new NdsRequest2();
        nr.getNP().add(np);
        FNSNDSCAWS2 fns = new FNSNDSCAWS2();
        FNSNDSCAWS2Port fnaws = fns.getFNSNDSCAWS2Port();
        NdsResponse2 response = fnaws.ndsRequest2(nr);
        for (NdsResponse2.NP p : response.getNP()) {
            System.out.printf("ИНН:%s  КПП:%s  Дата:%s %s", p.getINN(), p.getKPP(), p.getDT(), "\n");
            System.out.printf(" %s", STATES[Integer.valueOf(p.getState())]);
        }

    }

    /**
     * Метод получает данные от пользователя.
     *
     * @param question стока с запросом для пользователя
     * @return строка с полученным данными от пользователя
     */
    private static String ask(String question) {
        System.out.println(question);
        return scanner.nextLine();
    }

    /**
     * Метод проверяет данные от пользоваеля на корректность
     *
     * @param key константа ввода
     * @return строка ввода пользователя.
     */
    private static String validateInput(int key) {
        boolean invalid = false;
        String result = " ";
        while (!invalid) {
            if (key == 1) {
                result = ask("Введите ИНН: ");
                if (result.matches("([0-9]){10,12}")) {
                    invalid = true;
                } else {
                    System.out.println("Не корректное значение ИНН!");
                }
            }
            if (key == 2) {
                result = ask("Введите КПП: ");
                if (result.matches("([0-9]){9}")) {
                    invalid = true;
                } else {
                    System.out.println("Не корректное значение КПП!");
                }
            }

        }
        return result;
    }

}




