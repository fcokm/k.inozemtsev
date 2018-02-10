package ru.job4j.array;   


   /**
     *  Class Matrix реализует двухмерный массив
     *
     * @author Konstantin Inozemcev (9715791@gmail.com)
     * @version $Id$
     * @since 0.1
     */



    public class Matrix {
	
	
	   /**
         * Метод создает таблицу умножения
		 *  
		 *"@param size  указывает на размер таблицы
         * @return mas массив таблицы умножения.
         */		
	

	
    int[][] multiple(int size) {

        int[][] mas = new int[size][size];
        int numb = 1;
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                mas[i][j] = (i + 1) * (j + 1);

            }
        }

        return mas;
    }
	

 }	
