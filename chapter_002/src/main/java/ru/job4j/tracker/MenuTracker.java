package ru.job4j.tracker;

/**
 * Class MenuTracker реализует функционал действий пользователя.
 *
 * @author Konstantin Inozemcev (9715791@gmail.com)
 * @version $Id$
 * @since 0.1
 */


public class MenuTracker {

    /**
     * Получение данных от пользователя.
     */
    private Input input;
    /**
     * Хранилище заявок.
     */
    private Tracker tracker;
    /**
     * Массив  действий пользователя.
     */
    private UserAction[] actions = new UserAction[6];

    /**
     * Указатель ячейки для нового действия.
     */
    private int position = 0;

    /**
     * Конструктор - создание нового объекта с параметрами
     *
     * @param input   ввод данных.
     * @param tracker хранилище заявок.
     */
    public MenuTracker(Input input, Tracker tracker) {
        this.input = input;
        this.tracker = tracker;
    }

    /**
     * Конструктор - создание нового объекта.
     */
    public MenuTracker() {
    }


    /**
     * Метод заполняет массив событий действий пользователя.
     */
    public void addAction(UserAction action) {
        this.actions[position++] = action;
    }

    /**
     * Метод заполняет массив количество действий пользователя.
     */
    public int[] fillRange() {
        int[] rangeNum = new int[actions.length];
        for (int index = 0; index < rangeNum.length; index++) {
            rangeNum[index] = index;
        }
        return rangeNum;
    }


    /**
     * Метод выполняет действия выбранное пользователем.
     */
    public void select(int key) {
        this.actions[key].execute(this.input, this.tracker);
    }

    /**
     * Метод печатает меню
     */
    public void show() {
        for (UserAction action : this.actions) {
            if (action != null) {
                System.out.println(action.info());
            }
        }
    }


    /**
     * Class AddItem реализует добавления  новой заявки в Tracker.
     */
    public class AddItem extends BaseAction {
        /**
         * Переопределение конструктора родительского класса
         *
         * @param key  ключ на событие пользователя.
         * @param name строка с сообщением действий пользователя.
         */
        AddItem(final int key, final String name) {
            super(key, name);
        }

        @Override
        public void execute(Input input, Tracker tracker) {
        }
    }


    /**
     * Class ShowItems реализует вывод на экран всех заявок.
     */
    public class ShowItems extends BaseAction {
        /**
         * Переопределение конструктора родительского класса
         *
         * @param key  ключ на событие пользователя.
         * @param name строка с сообщением действий пользователя.
         */
        ShowItems(final int key, final String name) {
            super(key, name);
        }

        @Override
        public void execute(Input input, Tracker tracker) {
        }
    }


    /**
     * Class ReplacingItem реализует редактирование
     * заяввок в Tracker.
     */
    class ReplacingItem extends BaseAction {
        /**
         * Переопределение конструктора родительского класса
         *
         * @param key  ключ на событие пользователя.
         * @param name строка с сообщением действий пользователя.
         */
        ReplacingItem(final int key, final String name) {
            super(key, name);
        }

        @Override
        public void execute(Input input, Tracker tracker) {
        }
    }


    /**
     * Class DeletingItem реализует удаление заявки в Tracker.
     */
    class DeletingItem extends BaseAction {
        /**
         * Переопределение конструктора родительского класса
         *
         * @param key  ключ на событие пользователя.
         * @param name строка с сообщением действий пользователя.
         */
        DeletingItem(final int key, final String name) {
            super(key, name);
        }

        @Override
        public void execute(Input input, Tracker tracker) {
        }
    }

    /**
     * Class FindingByNameItems реализует
     * поиск заявки по имени в Tracker.
     */
    class FindingByNameItems extends BaseAction {
        /**
         * Переопределение конструктора родительского класса
         *
         * @param key  ключ на событие пользователя.
         * @param name строка с сообщением действий пользователя.
         */
        FindingByNameItems(final int key, final String name) {
            super(key, name);
        }

        @Override
        public void execute(Input input, Tracker tracker) {
        }
    }

    /**
     * Class FindingByIdItem реализует
     * поиск заявки по id  в Tracker.
     */
    class FindingByIdItem extends BaseAction {
        /**
         * Переопределение конструктора родительского класса
         *
         * @param key  ключ на событие пользователя.
         * @param name строка с сообщением действий пользователя.
         */
        FindingByIdItem(final int key, final String name) {
            super(key, name);
        }

        @Override
        public void execute(Input input, Tracker tracker) {
        }
    }

    public static void main(String[] args) {
        new StartUI(new ValidateInput(new ConsoleInput()), new  Tracker()).init();
    }


}
















