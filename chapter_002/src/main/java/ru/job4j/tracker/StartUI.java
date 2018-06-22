package ru.job4j.tracker;


import java.util.List;

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
        Tracker tracker = new Tracker();
        MenuTracker menu = new MenuTracker(this.input, tracker);
        menu.addAction(new MenuTracker().new AddItem(0, "Добавление новой заявки\n") {
            @Override
            public void execute(Input input, Tracker tracker) {
                String name = input.ask("Введите имя заявки :");
                String desc = input.ask("Введите описание заявки :");
                Item item = new Item(name, desc);
                tracker.add(item);
                String.format("%s  %s  %s", "--Заявка  с id добавлена: ", item.getId(), "\n");
            }
        });
        menu.addAction(new MenuTracker().new ShowItems(1, "Список всех заявок\n") {
            @Override
            public void execute(Input input, Tracker tracker) {
                List<Item> items = tracker.getAll();
                for (Item item : items) {
                    System.out.println(item);
                }
            }
        });
        menu.addAction(new MenuTracker().new ReplacingItem(2, "Редактирование заявки\n") {
            @Override
            public void execute(Input input, Tracker tracker) {
                String id = input.ask("Введите id редактируемой заявки :");
                String name = input.ask("Введите новое имя заявки :");
                String desc = input.ask("Введите новое описание  заявки :");
                Item item = new Item(id, name, desc);
                tracker.replace(id, item);
                String.format("%s  %s  %s", "--Заявка  с id: ", id, "\n");
            }
        });
        menu.addAction(new MenuTracker().new DeletingItem(3, "Удаление заявки\n") {
            @Override
            public void execute(Input input, Tracker tracker) {
                String id = input.ask("Введите id заявки :");
                tracker.delete(id);
                String.format("%s  %s  %s", "--Заявка  с id: ", id, "удалена ------", "\n");
            }

        });
        menu.addAction(new MenuTracker().new FindingByIdItem(4, "Поиск заявки по id\n") {

            @Override
            public void execute(Input input, Tracker tracker) {
                String id = input.ask("Введите id  заявки :");
                Item item = tracker.findById(id);
                System.out.println(item);
            }

        });
        menu.addAction(new MenuTracker().new FindingByNameItems(5, "Поиск списка заявок по имени\n") {

            @Override
            public void execute(Input input, Tracker tracker) {
                String name = input.ask("Введите имя заявки :");
                List<Item> items = tracker.findByName(name);
                for (Item it : items) {
                    System.out.println("-------------Заявка : " + it + "-----------");
                }
            }
        });

        int[] range = menu.fillRange();
        boolean exit = false;
        while (!exit) {
            menu.show();
            menu.select(input.ask("Введите пункт меню : ", range));
            if ("y".equals(input.ask("6. Завершить программу ?: y.\n"))) {
                exit = true;
            }
        }
    }

    /**
     * Метод отображает пункты  меню.
     */
    private void showMenu() {
        System.out.printf("%7s %5s %5s %5s %5s %5s %5s %5s", "Меню.\n", "0. Добавить новую заявку.\n",
                "1. Показать все заявки.\n", "2. Редактировать заявку.\n", "3. Удалить заявку.\n", "4. Найти  заявку по id.\n",
                "5. Найти заявку по имени.\n", "6. Завершить программу.\n");
    }

}


