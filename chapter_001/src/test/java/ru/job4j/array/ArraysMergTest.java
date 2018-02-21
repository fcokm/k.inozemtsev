package ru.job4j.array;

import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;


public class ArraysMergTest {
    @Test
    public void whenFirstArraySortAndSecondArraySortElementsThenMergeArraysSort() {
        ArraysMerg arraysMerg = new ArraysMerg();
        int[] firstArray = {0, 1, 3, 10, 23, 70};
        int[] secondArray = {1, 2, 4, 15, 17, 32, 100};
        int[] expectArray = {0, 1, 1, 2, 3, 4, 10, 15, 17, 23, 32, 70, 100};
        int[] resultArray = arraysMerg.merge(firstArray, secondArray);
        assertThat(resultArray, is(expectArray));

    }


}
