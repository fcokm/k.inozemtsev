package ru.job4j.calculator;

/**
 * Class Calculator решение задачи -2.3. Элементарный калькулятор.
 *
 * @author Konstantin Inozemcev (9715791@gmail.com)
 * @version $Id
 * @since 0.1
 */
 
   public class Calculator {
    
   
     private double result;
            
        /**
         * Конструктор вывода строки в консоль
         *
         * @param args - args.
         */
        public static void main(String[] args) {
            System.out.println("Hello World");
        }

        /**
         * Method echo.
         *
         * @param name Your name.
         * @return Echo plus your name.
         */
        public String echo(String name) {
            return "Echo, echo, echo : " + name;
        }
		
		
		 /**
         * Метод выполняет сложение  двух чисел.
         *
         * @param first argument of the first number .
		 * @param second argument of the second number.
         * @result sum of two numbers.
         */
		
		void add(double first, double second)  {
		   this.result = first + second;
		
		}
		
		/**
         *Метод выполняет деление  двух чисел.
         *
         * @param first argument of the first number .
		 * @param second argument of the second number.
         * @result division of two numbers.
         */
		
		
		
		void div(double first, double second) {
		  this.result = first / second;
		
		}
		
		
		/**
         * Метод выполняет  умножение  двух чисел.
         *
         * @param first argument of the first number .
		 * @param second argument of the second number.
         * @result multiple of two numbers.
         */
		
		void mult(double first, double second) {
		  this.result = first * second;
		
		}



	/**
	 * Метод выполняет  вычитание  двух чисел.
	 *
	 * @param first argument of the first number .
	 * @param second argument of the second number.
	 * @result  subtraction of two numbers.
	 */

	void sub(double first, double second) {
		this.result = first - second;

	}
		

		/**
         * Метод  возвращает значение поля result
         *
         * @result result.
         */
		
		 public double getResult() {
          return this.result;
		
        }
		
		
		
		

    }




