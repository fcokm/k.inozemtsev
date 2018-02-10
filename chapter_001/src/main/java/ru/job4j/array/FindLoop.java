package ru.job4j.array;   


   /**
     *  Class FindLoop реализует классический поиск перебором
     *
     * @author Konstantin Inozemcev (9715791@gmail.com)
     * @version $Id$
     * @since 0.1
     */



    public class FindLoop {
	
	
	   /**
         * Метод  возвращает индекс элемента
         *
		 * @param data  массив элементов
		 * @param el  число 
		 * 
         * @return индекс элемента
		 * если элемента нет в массиве, то возвращаем -1
         */	
	

    public int indexOf(int[] data, int el) {

        int rsl = -1;

        for (int index = 0; index < data.length; index++) {
            if (data[index] == el) {
                rsl = index;

                break;
            }
        }

        return rsl;
    }
 }