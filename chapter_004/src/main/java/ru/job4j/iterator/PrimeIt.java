package ru.job4j.iterator;

import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * Class PrimeIt класс реализует итератор простых чисел
 *
 * @author Konstantin Inozemcev (9715791@gmail.com)
 * @version $Id$
 * @since 0.1
 */

public class PrimeIt implements Iterator {
    /**
     * Массив чисел
     */
    private final int[] numbers;
    /**
     * Указатель элемента итератора
     */
    private int index = 0;

    /**
     * Конструктор - создание нового объекта с параметрами
     *
     * @param numbers  массив чисел.
     */
    public PrimeIt(final int[] numbers) {
        this.numbers = numbers;
    }

    /**
     * Метод проверяет , есть простые числа в массиве
     * @return true если существует, в противном случае false.
     */
    @Override
    public boolean hasNext() {
        int pointer = index;
        if (numbers.length == 0) {
            throw new NoSuchElementException();
        }
        while (pointer + 1 < numbers.length && !isprime(numbers[pointer])) {
            pointer++;
        }
        return pointer < numbers.length && isprime(numbers[pointer]);
    }

    /**
     * Метод вовращает  простые числа из массива
     * @return простое число.
     * @throws NoSuchElementException если в нет простых чисел в массиве.
     */
    @Override
    public Object next() {
        if (numbers.length == 0 || !hasNext()) {
            throw new NoSuchElementException();
        }
        while (index < numbers.length && !isprime(numbers[index])) {
            index++;
        }
        return numbers[index++];
    }


    /**
     * Метод проверяет является число простым
     * @param num  число
     * @return true если да, в противном случае false.
     */
    boolean isprime(int num) {
        boolean flag = true;
        if(num < 2) {
         flag = false;
        } else {
            for (int index = 2; index * index <= num; index++) {
                if (num % index == 0 )
                    flag = false;
                break;
            }
        }
        return flag;
    }
}
