 package ru.job4j.array;

 import java.util.Arrays; 


   /**
     *  Class ArrayDuplicate реализует алгоритм удаление дубликатов в массиве
     *
     * @author Konstantin Inozemcev (9715791@gmail.com)
     * @version $Id$
     * @since 0.1
     */



    class ArrayDuplicate {
	
		
	    /**
         *  Метод  удаляет все дубликаты строк из массива
         *
         * @param array массив строк
         * @return массив строк без повторяющихся слов.
         */

    public String[] removeDuplicates(String[] array) {

        int count = 0;

        for (int i = 0; i < array.length - count; i++) {
            for (int j = array.length - 1 - count; j >= i + 1; j--) {

                if (array[i].equals(array[j])) {
                    array[j] = array[array.length - 1 - count];
                    array[array.length - 1 - count] = array[i];
                    count++;

                }

            }

        }

        return Arrays.copyOf(array, (array.length - count));
    }



    }