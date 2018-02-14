package ru.job4j.loop;   


   /**
     *  Class Factorial для вычисления факториала числа
     *
     * @author Konstantin Inozemcev (9715791@gmail.com)
     * @version $Id$
     * @since 0.1
     */



    class Factorial {
	
		
	   /**
         *  Метод  возвращает факториал числа 
         *
         * @param number первое число
         * @return факториал числа.
         */

		 
		 
		 
        public int calc(int number) {

            int fact = 1;
            for (int i = 1; i <= number; i++) {
                fact *= i;

            }
            return fact;
        }


    }