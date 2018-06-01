 package ru.job4j.array;

 import java.util.Arrays; 


   /**
     *  Class ArrayChar обертка над строкой
     *
     * @author Konstantin Inozemcev (9715791@gmail.com)
     * @version $Id$
     * @since 0.1
     */

	 
	 
	 public class ArrayChar {

    private char[] data;

    public ArrayChar(String line) {
        this.data = line.toCharArray();
    }

    /**
     *  Метод проверяет что слово начинается с префикса
     *
     * @param prefix префикс
     * @return true если слово начинаеться с префикса.
     */
    public boolean startWith(String prefix) {
        int count = 0;
        char[] value = prefix.toCharArray();
        for (int i = 0; i < value.length; i++) {
            if (data[i] == value[i]) {
                count++;
            }
        }
        return value.length == count;
    }

}