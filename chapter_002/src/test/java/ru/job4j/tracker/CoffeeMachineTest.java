package ru.job4j.tracker;

import org.junit.Test;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public
class CoffeeMachineTest {
    @Test
    public void whenPaindHundredRublForCoffeAtCostThirtyFiveRublThenMachineGaveChange() {
        CoffeeMachine  coffMach = new CoffeeMachine();
        int[] resultArray = coffMach.change(100,35);
        int[] expectArray = {10, 10, 10, 10, 10, 10, 5};
        assertThat(resultArray, is(expectArray));
    }
}
