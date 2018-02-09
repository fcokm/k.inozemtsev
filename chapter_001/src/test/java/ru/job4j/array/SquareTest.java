package ru.job4j.array;  

import org.junit.Test;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;



   

   public class SquareTest {

        @Test
        public void whenTenThenArrayNumbersSquared() {
            Square square = new Square();
			int[] arr = {1, 4, 9, 16, 25, 36, 49, 64, 81, 100};
            int[] resultArray = square.calculate(10);
            assertThat(resultArray, is(arr));
        }	
		
    }