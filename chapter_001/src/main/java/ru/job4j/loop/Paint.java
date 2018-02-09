package ru.job4j.loop;   


   /**
     *  Class Paind строит  пирамиду в псевдографике
     *
     * @author Konstantin Inozemcev (9715791@gmail.com)
     * @version $Id$
     * @since 0.1
     */



    public class Paint {
	
	
	   /**
         * Метод рисует  пирамиду из символа ^ и пробелов
         *
		 *"@param height высота пирамиды
         * @return строка в виде пирамиды .
         */	
	

    String pyramid(int height) {

        StringBuilder screen = new StringBuilder();
        int in = height * 2 - 1;
        int midlle = height - 1;
        for (int i = 0; i < height; i++) {

            for (int j = 0; j < in; j++) {

                if (j <= (midlle + i) && j >= (midlle - i)) {
                    screen.append("^");
                } else {
                    screen.append(" ");
                }
            }

            screen.append(System.lineSeparator());
        }

        return screen.toString();
    }
 }	
	
	
	
	
	
	
	