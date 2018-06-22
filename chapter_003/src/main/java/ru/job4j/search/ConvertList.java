package ru.job4j.search;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

public class ConvertList {


    public List<Integer> toList(int[][] array) {
        ArrayList<Integer> list = new ArrayList<>();
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array[i].length; j++) {
                list.add(array[i][j]);
            }
        }
        return list;
    }


    public int[][] toArray(List<Integer> list, int rows) {
        int[][] array = new int[rows][rows];
        int index = 0;

        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array.length; j++) {
                if (index >= list.size()) {
                    index++;
                } else {
                    array[i][j] = list.get(index++);
                }
            }
        }
        return array;
    }


    public List<Integer> convert (List<int[]> list){
        List<Integer> result = new ArrayList<>();
        for (int[] number : list) {
            int[] array = number;
            for (int i = 0; i < array.length; i++) {
                result.add(array[i]);
            }
        }
        return result;
    }

}


