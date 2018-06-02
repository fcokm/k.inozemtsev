package ru.job4j.iterator;

import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * Class EvenIt класс реализует итератор четных чисел
 *
 * @author Konstantin Inozemcev (9715791@gmail.com)
 * @version $Id$
 * @since 0.1
 */
public class EvenIt implements Iterator {
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
    public EvenIt(final int[] numbers) {
        this.numbers = numbers;
        this.index = 0;
    }

    /**
     * Метод проверяет , есть четные числа в массиве
     * @return true если существует, в противном случае false.
     */
    @Override
    public boolean hasNext() {
        int position = index;
        while (numbers.length > position+1 && numbers[position] % 2 != 0 ) {
            position++;
        }
        return numbers[position] % 2 == 0;
    }

    /**
     * Метод вовращает  четные числа из массива
     * @return четное число.
     * @throws NoSuchElementException если в нет четных чисел в массиве.
     */
    @Override
    public Object next() {
        if (numbers.length == 0 || !hasNext() ) {
            throw new NoSuchElementException();
        }
        while (numbers.length > index && numbers[index] % 2 != 0) {
            index++;
        }
        return numbers[index++];
    }


}
