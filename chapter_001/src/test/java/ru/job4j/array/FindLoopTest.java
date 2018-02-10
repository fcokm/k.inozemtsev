package ru.job4j.array;  

import org.junit.Test;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;



   

   public class FindLoopTest {

        @Test
        public void whenTwoThenArrayElementIndex() {
            FindLoop findloop = new FindLoop();
			int[] arr = {1, 2, 9, 15, 7};
            int result = findloop.indexOf(arr, 2);
            assertThat(result, is(1));
        }	
		
		
		
		
		 @Test
         public void whenTenThenMinusOne() {
            FindLoop findloop = new FindLoop();
			int[] arr = {1, 2, 9, 15, 7};
            int  result = findloop.indexOf(arr, 10);
            assertThat(result, is(-1));
        }
		
    }