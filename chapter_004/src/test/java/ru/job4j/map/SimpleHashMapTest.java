package ru.job4j.map;


import org.junit.Before;
import org.junit.Test;


import java.util.Iterator;

import static junit.framework.TestCase.assertTrue;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;
import static org.hamcrest.Matchers.stringContainsInOrder;
import static org.junit.Assert.assertFalse;

public class SimpleHashMapTest {
    private SimpleHashMap<String, Integer> map;
    private Iterator<Integer> it;

    @Before
    public void beforeTest() {
        map = new SimpleHashMap<>();
        map.insert("one", 1);
        map.insert("two", 2);
        map.insert("three", 3);
        it = map.iterator();

    }

    @Test
    public void whenAddThreeElementsThenContainsTwoResultTrue() {
        assertThat(map.get("two"), is(2));
    }

    @Test
    public void whenAddThreeElementsThenDeleteThreeResultFalse() {
        // assertFalse(map.contains(5));
        map.delete("three");
        assertFalse(map.contains("three"));
    }


    @Test
    public void testsThatNextMethodDoesntDependsOnPriorHasNextInvocation () {
        System.out.println(it.next());
        assertThat(it.hasNext(), is(true));
        System.out.println(it.next());
        assertThat(it.hasNext(), is(true));
        System.out.println(it.next());
        assertThat(it.hasNext(), is(false));

    }
}
