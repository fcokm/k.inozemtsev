package ru.job4j.max;   


   /**
     *  Class Max решение задачи 3.1 .
     *
     * @author Konstantin Inozemcev (9715791@gmail.com)
     * @version $Id$
     * @since 0.1
     */
	 
	 
	 
	    public class Max {

    
		
		/**
         *  Метод возвращает максимальное число  
         * из двух чисел
		 *
         * @param first первое число
		 * @param second второе число
         * @return максимальное число.
         */
		
	    public  int max(int first, int second) {
            int c = first - second;
            int k = (c >> 31) & 0x1;

            return first - k * c;
        }

		
		
		/**
         *  Метод возвращает максимальное число 
		 *   из трех чисел 
         *
         * @param first первое число
		 * @param second второе число
		 * @param third третье число
         * @return максимальное число.
         */
		
		
       public  int max(int first, int second, int third) {
            int tmp = max(first, second);
            int max = max(tmp, third);

            return max;
        }
		
		
		
		
		
    }
	
	
	
	