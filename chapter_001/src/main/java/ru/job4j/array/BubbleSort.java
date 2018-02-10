package ru.job4j.array;   


   /**
     *  Class BubbleSort реализует алгоритм сортировки  
     *  методом 
     * @author Konstantin Inozemcev (9715791@gmail.com)
     * @version $Id$
     * @since 0.1
     */



    public class BubbleSort {
	
	
	   /**
         * Метод сортирует  массив целых чисел, 
		 *  используя алгоритм сортировки пузырьком
         *
		 *"@param mas массив  не отсортированных целых чисел
         * @return массив отсортированный в порядке возрастания целых чисел .
         */	
	

	
	     public int[] sort(int[] mas) {
            int tmp = 0;

        for (int i = mas.length - 1; i >= 0; i--) {
            for (int j = 0; j < i; j++) {
                if (mas[j] > mas[j + 1]) {
                    tmp = mas[j];
                    mas[j] = mas[j + 1];
                    mas[j + 1] = tmp;
                }
            }

        }
		   return mas;
    }
	

 }	















    