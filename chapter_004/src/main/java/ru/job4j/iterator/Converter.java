package ru.job4j.iterator;

import java.util.*;


/**
 * Class Converter класс реализует итератор итераторов.
 *
 * @author Konstantin Inozemcev (9715791@gmail.com)
 * @version $Id$
 * @since 0.1
 */

public class Converter {

    /**
     * Метод возвращает итератор чисел
     * @param it   объект итератор итератор
     * @return итератор чисел.
     */

    Iterator<Integer> convert(Iterator<Iterator<Integer>> it) {
        return new Iterator<Integer>() {
            Iterator<Integer> iterator = it.next();

            /**
             * Метод проверяет , есть ли числа в итераторе
             * @return true если да, в противном случае false.
             */
            @Override
            public boolean hasNext() {
                boolean flag = false;
                while(it.hasNext() || iterator.hasNext()) {
                    if (iterator.hasNext()) {
                        flag = true;
                        break;
                    }else {
                        iterator =it.next();
                    }
                }
                return flag;
            }
            /**
             * Метод вовращает число из итератора
             * @return  число.
             * @throws NoSuchElementException если в нет чисел в итераторе.
             */
            @Override
            public Integer next() {
                if (!hasNext()) {
                    throw new NoSuchElementException();
                }
                return iterator.next();
            }
        };
    }
}
