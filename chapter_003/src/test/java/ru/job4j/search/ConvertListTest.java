package ru.job4j.search;

import org.junit.Test;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;


public class ConvertListTest {
    @Test
    public void whenArrayNumbersThenArrayListWithSameNumbers() {
        ConvertList convertList = new ConvertList();
        int[][] arrays = {{1, 2, 3}, {4, 5}};
        List resultList = convertList.toList(arrays);
        List<Integer> expectedList = new ArrayList<>(Arrays.asList(1, 2, 3, 4, 5));
        assertThat(resultList, is(expectedList));
    }

    @Test
    public void whenArrayLisNumbsThenArraysWithSameNumbers() {
        ConvertList convertList = new ConvertList();
        List<Integer> list = new ArrayList<>(Arrays.asList(1, 2, 3, 4, 5, 6, 7));
        int[][] expectedArrays = {{1, 2, 3}, {4, 5, 6},  {7, 0 ,0}};
        int[][] resultArrays = convertList.toArray(list, 3);
        assertThat(resultArrays, is(expectedArrays));
    }

    @Test
    public void whenArrayLisWithArraysNumbsThenArraysListWithSameNumbers() {
        ConvertList convertList = new ConvertList();
        List<int[]> list = new ArrayList<>(Arrays.asList(new int[]{1, 2}, new int[]{3, 4, 5, 6}));
        List resultList = convertList.convert(list);
        List<Integer> expectedList = new ArrayList<>(Arrays.asList(1, 2, 3, 4, 5, 6));
        assertThat(resultList, is(expectedList));
    }

}
