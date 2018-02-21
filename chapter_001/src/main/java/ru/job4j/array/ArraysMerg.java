package ru.job4j.array;


/**
 * Class ArraysMerg реализует алгоритм слияния
 * двух упорядочных массивов
 *
 * @author Konstantin Inozemcev (9715791@gmail.com)
 * @version $Id$
 * @since 0.1
 */


public class ArraysMerg {


    /**
     * Метод объединяет два отсортированных массива целых чисел
     *
     *"@param firstArray  массива целых чисел
     *"@param secondArray  массива целых чисел
     * @return result массив целых чисел  .
     */

    public int[] merge(int[] firstArray, int[] secondArray) {
        int[] result = new int[firstArray.length + secondArray.length];
        int oneIndex = 0;
        int twoIndex = 0;
        for (int i = 0; i < result.length; i++) {

            if (oneIndex > firstArray.length - 1) {
                result[i] = secondArray[twoIndex];
                twoIndex++;

            } else if (twoIndex > secondArray.length - 1) {
                result[i] = firstArray[oneIndex];
                oneIndex++;

            } else if (firstArray[oneIndex] <= secondArray[twoIndex]) {
                result[i] = firstArray[oneIndex];
                oneIndex++;

            } else if (secondArray[twoIndex] < firstArray[oneIndex]) {
                result[i] = secondArray[twoIndex];
                twoIndex++;
            }

        }

        return result;
    }


}
