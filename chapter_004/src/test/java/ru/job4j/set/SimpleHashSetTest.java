package ru.job4j.set;


import org.hamcrest.MatcherAssert;
import org.junit.Before;
import org.junit.Test;
import static junit.framework.TestCase.assertTrue;
import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertFalse;


public class SimpleHashSetTest {
    private SimpleHashSet<Integer> hashSet;


    @Before
    public void beforeTest() {
        hashSet = new SimpleHashSet<>();
        hashSet.add(1);
        hashSet.add(2);
        hashSet.add(3);

    }

    @Test
    public void whenAddThreeElementsThenContainsTwoResultTrue() {
        assertTrue(hashSet.contains(2));
    }

    @Test
    public void whenAddThreeElementsThenContainsFiveResultFalse() {
        assertFalse(hashSet.contains(5));
    }

    @Test
    public void whenAddThreeElementsThenRemoveElementAndContainsTwoResultFalse() {
        hashSet.remove(2);
        assertFalse(hashSet.contains(2));
    }

}
