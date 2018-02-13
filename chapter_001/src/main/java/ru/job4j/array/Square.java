package ru.job4j.array;   


    /**
     *  Class Square
     *
     * @author Konstantin Inozemcev (9715791@gmail.com)
     * @version $Id$
     * @since 0.1
     */
	 
	 
	 public class Square {
	 
	    /**
         * Метод  заполняет массив чисел возведенных в квадрат
         *
		 * @param bound число
         * @return массив чисел.
         */	
		 
    public int[] calculate(int bound) {
        int[] rst = new int[bound];
        for (int i = 0; i < rst.length; i++) {
            rst[i] = (i + 1) * (i + 1);

        }

        return rst;

    }
	
	
 }	