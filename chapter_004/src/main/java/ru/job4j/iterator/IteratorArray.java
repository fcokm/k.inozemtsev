package ru.job4j.iterator;


import java.util.Iterator;
import java.util.List;
import java.util.NoSuchElementException;

/**
 * Class IteratorArray класс реализует итератор
 * для двухмерного массива
 *
 * @author Konstantin Inozemcev (9715791@gmail.com)
 * @version $Id$
 * @since 0.1
 */

public class IteratorArray implements Iterator {
    /**
     * Двумерный  массива чисел
     */
    private final int[][] values;
    /**
     * Первый индекс  двухмерного массива.
     */
    private int firstIndex;
    /**
     * Второй индекс  двухмерного массива.
     */
    private int secondIndex;
    /**
     * Счетчик элементов итератора.
     */
    private int count;

    /**
     * Количество элементов массива.
     */
    private int size;


    /**
     * Конструктор - создание нового объекта с параметрами
     *
     * @param values двумерный  массив чисел.
     */

    public IteratorArray(final int[][] values) {
        this.values = values;
        this.firstIndex = 0;
        this.secondIndex = 0;
        this.count = 0;
        arryaSize();
    }

    /**
     * Метод вычисляет количество элементов в
     * двумерном  массиве
     */
    void arryaSize() {
        int index = 0;
        for(int i = 0; i < values.length; i++){
           size += values[i].length;
        }
    }

    /**
     * Метод проверяет , есть следующий элемент в контейнере
     * @return true если существует, в противном случае false.
     */
    @Override
    public boolean hasNext() {
        return size > count;
    }

    /**
     * Метод вовращает  следующий элемент в контейнере
     * @return следующий элемент в контейнере.
     * @throws NoSuchElementException если в контейнере нет элементов.
     */
    @Override
    public Object next() {
        if (!hasNext()) {
            throw new NoSuchElementException();
        }
        if (!(values[firstIndex].length > secondIndex)) {
            firstIndex++;
            secondIndex = 0;
        }
        count++;
        return values[firstIndex][secondIndex++];
    }

}

