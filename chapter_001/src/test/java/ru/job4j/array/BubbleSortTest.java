package ru.job4j.array;  

import org.junit.Test;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;



   

   public class BubbleSortTest {

        @Test
        public void whenSortArrayNotSortedElementsThenSortedAscendingArray() {
          
		    BubbleSort  bubbleSort = new BubbleSort();
			int[] array = {5, 1, 2, 7, 3};
			int[] expectArray = {1, 2, 3, 5, 7};
			int[] resultArray = bubbleSort.sort(array);
            assertThat(resultArray, is(expectArray));
			
        }
    }