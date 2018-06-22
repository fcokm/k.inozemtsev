package ru.job4j.tracker;


    /**
     * Interface UserAction
     *
     * @author Konstantin Inozemcev (9715791@gmail.com)
     * @version $Id$
     * @since 0.1
     */
    public interface UserAction {

        /**
         * Метод возвращает ключ на событие пользователя
         */
      int key();

        /**
         * Метод выполняет событие выбраное пользователем
         *
         * @param input   ввод данных.
         * @param tracker хранилище заявок.
         */
     void execute(Input input, Tracker tracker);

        /**
         * Метод сообщает пользователю какие действия выполняются
         * @return строка
         */
     String info();
}