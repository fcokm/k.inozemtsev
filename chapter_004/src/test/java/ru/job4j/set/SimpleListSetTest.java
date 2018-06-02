package ru.job4j.set;


import org.hamcrest.MatcherAssert;
import org.junit.Before;
import org.junit.Test;
import ru.job4j.iterator.IteratorArray;

import java.util.Iterator;
import java.util.NoSuchElementException;

import static junit.framework.TestCase.assertTrue;
import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertFalse;


public class SimpleListSetTest {
    private SimpleListSet<Integer> set;
    private Iterator<Integer> it;

    @Before
    public void beforeTest() {
        set = new SimpleListSet<>();
        set.add(1);
        set.add(2);
        set.add(3);
        it = set.iterator();
    }

    @Test
    public void whenAddThreeElementsThenContainsTwoResultTrue() {
        assertTrue(set.contains(2));
    }

    @Test
    public void whenAddThreeElementsThenContainsFiveResultFalse() {
        assertFalse(set.contains(5));
    }

    @Test
    public void testsThatNextMethodDoesntDependsOnPriorHasNextInvocation () {
        MatcherAssert.assertThat(it.next(), is(3));
        MatcherAssert.assertThat(it.next(), is(2));
        MatcherAssert.assertThat(it.next(), is(1));
    }

    @Test
    public void hasNextNextSequentialInvocation () {
        MatcherAssert.assertThat(it.hasNext(), is(true));
        MatcherAssert.assertThat(it.next(), is(3));
        MatcherAssert.assertThat(it.hasNext(), is(true));
        MatcherAssert.assertThat(it.next(), is(2));
        MatcherAssert.assertThat(it.hasNext(), is(true));
        MatcherAssert.assertThat(it.next(), is(1));
    }

    @Test
    public void sequentialHasNextInvocationDoesntAffectRetrievalOrder () {
        MatcherAssert.assertThat(it.hasNext(), is(true));
        MatcherAssert.assertThat(it.hasNext(), is(true));
        MatcherAssert.assertThat(it.next(), is(3));
        MatcherAssert.assertThat(it.next(), is(2));
        MatcherAssert.assertThat(it.next(), is(1));
    }

    @Test(expected = NoSuchElementException.class)
    public void shoulThrowNoSuchElementException () {
        it = new IteratorArray(new int[][]{});
        it.next();
    }
}
