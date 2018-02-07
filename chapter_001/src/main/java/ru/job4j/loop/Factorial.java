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

            if (number < 0) {
                return -1;
            }
            if (number == 0) {
                return 1;
            }
            int fact = 1;
            for (int i = 2; i <= number; i++) {
                fact *= i;
                System.out.print(fact + " ");

            }
            return fact;
        }


    }