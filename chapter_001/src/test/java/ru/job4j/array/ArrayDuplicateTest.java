package ru.job4j.array;

import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.hamcrest.collection.IsArrayContainingInAnyOrder.arrayContainingInAnyOrder;
import static org.junit.Assert.*;





    public class ArrayDuplicateTest {

        @Test
        public void whenRemoveDuplicatesThenArrayWithoutDuplicate() {

            String[] input = {"Привет", "Мир", "Привет", "Супер", "Мир"};
            String[] except = {"Привет", "Мир", "Супер"};
            ArrayDuplicate arrayDupl = new ArrayDuplicate();
            String[] result = arrayDupl.removeDuplicates(input);
            assertThat(result, arrayContainingInAnyOrder(except));

        }
    }