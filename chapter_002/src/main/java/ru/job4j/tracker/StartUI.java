package ru.job4j.tracker;


/**
 * Class StartUI реализует функционал хранения и обработки  заявок
 *
 * @author Konstantin Inozemcev (9715791@gmail.com)
 * @version $Id$
 * @since 0.1
 */

public class StartUI {

    /**
     * Константа меню для добавления новой заявки.
     */
    private static final String ADD = "0";


    /**
     * Константа вводы всех заявок.
     */
    private static final String ALL = "1";


    /**
     * Константа получение списка заявок по имени.
     */

    private static final String BYNAME = "2";


    /**
     * Константа получение списка заявок по id.
     */

    private static final String BYID = "3";


    /**
     * Константа редактирования списка заявок.
     */


    private static final String REPLACE = "4";

    /**
     * Константа удаления заявки из списка.
     */

    private static final String DELETE = "5";


    /**
     * Константа для выхода из цикла.
     */

    private static final String EXIT = "6";


    /**
     * Получение данных от пользователя.
     */
    private final Input input;

    /**
     * Хранилище заявок.
     */
    private final Tracker tracker;

    /**
     * Конструтор инициализирующий поля.
     *
     * @param input   ввод данных.
     * @param tracker хранилище заявок.
     */
    public StartUI(Input input, Tracker tracker) {
        this.input = input;
        this.tracker = tracker;
    }

    /**
     * Основой цикл программы.
     */

    public void init() {
        boolean exit = false;
        while (!exit) {
            this.showMenu();
            String answer = this.input.ask("Введите пункт меню : ");
            switch (answer) {
                case "0":
                    this.createItem();
                    break;
                case "1":
                    this.getAllItems();
                    break;
                case "2":
                    this.replaceItemById();
                    break;
                case "3":
                    this.deleteItemById();
                    break;
                case "4":
                    this.getItemsById();
                    break;
                case "5":
                    this.getItemsByName();
                    break;
                case "6":
                    exit = true;
                    break;
                default:
                    answer = "Пункт меню выбран не верно";
                    break;
            }
        }
    }


    /**
     * Метод реализует добавление новый заявки в хранилище.
     */

    private void createItem() {
        System.out.println("------------ Добавление новой заявки --------------\n");
        String name = this.input.ask("Введите имя заявки :");
        String desc = this.input.ask("Введите описание заявки :");
        Item item = new Item(name, desc);
        this.tracker.add(item);
        System.out.printf("%-10s %-5s\n", "Создана новая заявка : ", item);
    }

    /**
     * Метод реализует вывод списка всех заявок на консоль.
     */
    private void getAllItems() {
        System.out.println("------------ Список всех заявок --------------");
        Item[] items = this.tracker.getAll();
        for (Item item : items) {
            System.out.printf("%-10s %-5s \n", "Заявка :", item);
        }
    }


    /**
     * Метод реализует вывод на консоль  список  заявок по имени.
     */
    private void getItemsByName() {
        System.out.println("------------ Получение заявки по имени --------------");
        String name = this.input.ask("Введите имя заявки :");
        Item[] items = this.tracker.findByName(name);
        for (Item it : items) {
            System.out.printf("%-8s %-10s\n", "Заявка :", it);
        }
    }

    /**
     * Метод реализует вывод на консоль  заявки по Id.
     */

    private void getItemsById() {
        System.out.println("------------ Получение заявки по Id --------------\n");
        String id = this.input.ask("Введите id заявки :");
        Item item = this.tracker.findById(id);
        System.out.printf("%-8s %-10s\n", "Заявка :", item);
    }

    /**
     * Метод реализует редактирование заявки
     */

    private void replaceItemById() {
        System.out.println("------------ Редактирование заявки --------------\n");
        String id = this.input.ask("Введите id редактируемой заявки :");
        String name = this.input.ask("Введите новое имя заявки :");
        String desc = this.input.ask("Введите новое описание  заявки :");
        Item item = new Item(id, name, desc);
        this.tracker.replace(id, item);
        System.out.printf("%-10s %-3s %-5s\n", "Заявка с id:", id, "отредактирована");
    }


    /**
     * Метод реализует удаление заявки
     */

    private void deleteItemById() {
        System.out.println("------------ Удаление заявки --------------");
        String id = this.input.ask("Введите id заявки :");
        this.tracker.delete(id);
        System.out.printf("%-10s %-3s %-5s\n", "Заявка с id:", id, "удалена");
    }

    /**
     * Метод отображает пункты  меню.
     */

    private void showMenu() {
        System.out.printf("%7s %5s %5s %5s %5s %5s %5s %5s", "Меню.\n", "0. Добавить новую заявку.\n",
                "1. Показать все заявки.\n", "2. Редактировать заявку.\n", "3. Удалить заявку.\n", "4. Найти  заявку по id.\n",
                "5. Найти заявку по имени.\n", "6. Завершить программу.\n");
    }

    /**
     * Запускт программы.
     *
     * @param args
     */
    public static void main(String[] args) {
        new StartUI(new ConsoleInput(), new Tracker()).init();
    }
}
