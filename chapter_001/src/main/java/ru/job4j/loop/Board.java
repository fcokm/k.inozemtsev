package ru.job4j.loop;   


   /**
     *  Class Board строит шахматную доску в псевдографике
     *
     * @author Konstantin Inozemcev (9715791@gmail.com)
     * @version $Id$
     * @since 0.1
     */



	
    class Board {
	
	
	
	   /**
         * Метод рисует шахматную доску из символов x и пробелов
         *
		 * @param width ширина доски
		 *"@param height высота доски
		 *
         * @return строка в виде доски.
         */


        public String paint(int width, int height) {
            StringBuffer sb = new StringBuffer();
            String ln = System.lineSeparator();

            for (int i = 0; i < height; i++) {
                for (int j = 0; j < width; j++) {
                    if (i + j == 0 || (i + j) % 2 == 0) {
                        sb.append('X');
                    } else {
                        sb.append(' ');
                    }

                }
                sb.append(ln);
            }

            return sb.toString();
        }
		
		
    }