package ru.job4j.loop;   


   /**
     *  Class Counter для подсчета суммы
     *	 чётных чисел в диапазоне
     *
     * @author Konstantin Inozemcev (9715791@gmail.com)
     * @version $Id$
     * @since 0.1
     */

 
	 
    public class Counter {
        int sum = 0;

		
	   /**
         *  Метод должен вычислять сумму четныx чисел в заданном диапазоне 
         *
         * @param start первое число
		 * @param finish второе число
         * @return сумма чисел.
         */
		
		
        public int add(int start, int finish) {

            for (int i = start; i <= finish; i++) {

                if (i % 2 == 0) {
                    System.out.print(i + "  ");

                    sum = sum + i;
                }
            }
			
            return sum;

        }


    }
		
		
		
		
		

