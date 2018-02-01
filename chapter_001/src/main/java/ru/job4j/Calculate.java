package ru.job4j;

/**
 * Calculator.
 *
 * @author Konstantin Inozemcev (9715791@gmail.com)
 * @version $Id$
 * @since 0.1
 */
 
   public class Calculate {

       
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
     * @param name Your name.
     * @return Echo plus your name.
     */
    public String echo(String name) {
        return "Echo, echo, echo : " + name;
    }
		
	}