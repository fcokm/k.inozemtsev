package ru.job4j.list;

import org.hamcrest.MatcherAssert;
import org.junit.Before;
import org.junit.Test;
import ru.job4j.iterator.IteratorArray;

import java.util.Iterator;
import java.util.NoSuchElementException;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

public class SimpleListTest {
    private  SimpleList<Integer> list;
    private Iterator<Integer> it;

    @Before
    public void beforeTest() {
        list = new SimpleList<>();
        list.add(1);
        list.add(2);
        list.add(3);
       it = list.iterator();
    }

    @Test
    public void whenAddThreeElementsThenUseGetOneResultTwo() {
        assertThat(list.get(1), is(2));
    }

    @Test
    public void testsThatNextMethodDoesntDependsOnPriorHasNextInvocation () {
        MatcherAssert.assertThat(it.next(), is(1));
        MatcherAssert.assertThat(it.next(), is(2));
        MatcherAssert.assertThat(it.next(), is(3));
    }

    @Test
    public void hasNextNextSequentialInvocation () {
        MatcherAssert.assertThat(it.hasNext(), is(true));
        MatcherAssert.assertThat(it.next(), is(1));
        MatcherAssert.assertThat(it.hasNext(), is(true));
        MatcherAssert.assertThat(it.next(), is(2));
        MatcherAssert.assertThat(it.hasNext(), is(true));
        MatcherAssert.assertThat(it.next(), is(3));
    }

    @Test
    public void sequentialHasNextInvocationDoesntAffectRetrievalOrder () {
        MatcherAssert.assertThat(it.hasNext(), is(true));
        MatcherAssert.assertThat(it.hasNext(), is(true));
        MatcherAssert.assertThat(it.next(), is(1));
        MatcherAssert.assertThat(it.next(), is(2));
        MatcherAssert.assertThat(it.next(), is(3));
    }

    @Test(expected = NoSuchElementException.class)
    public void shoulThrowNoSuchElementException () {
        it = new IteratorArray(new int[][]{});
        it.next();
    }
}
