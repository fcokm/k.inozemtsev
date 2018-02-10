package ru.job4j.array;   


import org.junit.Test;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;


    


    public class TurnTest {

        @Test
        public void whenTurnArrayWithEvenAmountOfElementsThenTurnedArray() {
          
		    Turn  turn = new Turn();
			int[] array = {2, 6, 1, 4};
			int[] expectArray = {4, 1, 6, 2};
			int[] resultArray = turn.back(array);
            assertThat(resultArray, is(expectArray));
			
        }

        @Test
        public void whenTurnArrayWithOddAmountOfElementsThenTurnedArray() {
          
		    Turn  turn = new Turn();
			int[] array = {1, 2, 3, 4, 5 };
			int[] expectArray = {5, 4, 3, 2, 1 };
			int[] resultArray = turn.back(array);
            assertThat(resultArray, is(expectArray));
        }
    }