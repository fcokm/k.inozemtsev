package ru.job4j.iterator;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.NoSuchElementException;


public class IteratorArray implements Iterator {
    private final int[][] values;
    private int firstIndex;
    private int secondIndex;
    private int count;

    public IteratorArray(final int[][] values) {
        this.values = values;
        this.firstIndex = 0;
        this.secondIndex = 0;
        this.count = 0;
    }

    int arryLength() {
        int length = 0;
        for (int i = 0; i < values.length; i++) {
            for (int j = 0; j < values[i].length; j++) {
                length++;
            }
        }
        return length;
    }

    public boolean hasNext() {
        if (arryLength() == 0) {
            throw new NoSuchElementException();
        }
        return arryLength() > count;
    }


    public Object next() {
        if (arryLength() == 0) {
            throw new NoSuchElementException();
        }
        if (!(values[firstIndex].length > secondIndex)) {
            firstIndex++;
            secondIndex = 0;
        }
        count++;
        return values[firstIndex][secondIndex++];
    }

}

