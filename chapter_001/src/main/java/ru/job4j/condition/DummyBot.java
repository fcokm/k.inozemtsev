package ru.job4j.condition;   


   /**
     * DummyBot решение задачи 3.1 .
     *
     * @author Konstantin Inozemcev (9715791@gmail.com)
     * @version $Id$
     * @since 0.1
     */

   public class DummyBot {

        /**
         *  Метод отвечает на вопросы.
         *
         * @param question Вопрос от клиента.
         * @return Ответ.
         */
        public String answer(String question) {
            String rsl = "Это ставит меня в тупик. Спросите другой вопрос.";
            if ("Привет, Бот.".equals(question)) {
                rsl = "Привет, умник.";
            } else if ("Пока.".equals(question)) {
                rsl = "До скорой встречи.";
            }
            return rsl;
        }
    }