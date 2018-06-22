package ru.job4j.tracker;

import java.util.Arrays;


/**
 * Class CoffeeMachine
 *
 * @author Konstantin Inozemcev (9715791@gmail.com)
 * @version $Id$
 * @since 0.1
 */


public class CoffeeMachine {
    private final int[] monets = {1, 2, 5, 10};

    //  100-35 65  10
    public int[] change(int value, int price) {
        int[] result = new int[30];
        int index = monets.length - 1;
        int countMonets = 0;
        int change = value - price;
        while (change != 0) {
            if (monets[index] <= change) {
                for (int i = 0; i < change / monets[index]; i++) {
                    result[countMonets++] = monets[index];
                }
                change = change % monets[index];
                index--;
            } else {
                index--;
            }
        }
       result= Arrays.copyOf(result, countMonets);
        System.out.println(Arrays.toString(result));
        return result;
    }


    public static void main(String[] args) {
        new CoffeeMachine().change(100, 37);

        int a = 65, b = 10;
        //   System.out.println(a%b);

    }

}
