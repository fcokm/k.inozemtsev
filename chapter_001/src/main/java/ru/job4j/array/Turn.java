package ru.job4j.array;   


    /**
     *  Class Turn реализует алгоритм переворота массива
     *
     * @author Konstantin Inozemcev (9715791@gmail.com)
     * @version $Id$
     * @since 0.1
     */



    class Turn {
	
		
	    /**
         *  Метод  переворачивает массив задом наперёд
         *
         * @param array массив чисел
         * @return массив перевёрнутых чисел
         */

    public int[] back(int[] array) {
     
        int tmp = 0;
        for (int i = 0; i < array.length / 2; i++) {
            tmp = array[i];
            array[i] = array[((array.length - 1) - i)];
            array[((array.length - 1) - i)] = tmp;
         }

          return array;
      }


    }