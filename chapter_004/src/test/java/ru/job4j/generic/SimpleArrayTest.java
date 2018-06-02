package ru.job4j.generic;

import org.junit.Before;
import org.junit.Test;
import ru.job4j.iterator.IteratorArray;

import java.util.Iterator;
import java.util.NoSuchElementException;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;


/**
 * Class SimpleArrayTest
 *
 * @author Konstantin Inozemcev (9715791@gmail.com)
 * @version $Id$
 * @since 0.1
 */
public class SimpleArrayTest {
  private SimpleArray array;
    private Iterator<Integer> it;

    @Before
    public void setUp(){
        array = new SimpleArray(5);
        array.add(1);
        array.add(4);
        array.add(7);
        it = array.iterator();
    }

    @Test
    public void whenAddThreeElementsThenGetFirstElementResultFour () {
        assertThat(array.get(1), is(4));
    }

    @Test
    public void whenAddThreeElementsThenDeleteSecondElementResultFour () {
        array.delete(2);
        assertThat(array.get(1), is(4));
    }

    @Test
    public void whenAddThreeElementsThenSecondElementSetFiveResultFive () {
        array.set(2, 5);
        assertThat(array.get(2), is(5));
    }

    @Test
    public void testsThatNextMethodDoesntDependsOnPriorHasNextInvocation () {
        assertThat(it.next(), is(1));
        assertThat(it.next(), is(4));
        assertThat(it.next(), is(7));
    }

    @Test
    public void hasNextNextSequentialInvocation () {
        assertThat(it.hasNext(), is(true));
        assertThat(it.next(), is(1));
        assertThat(it.hasNext(), is(true));
        assertThat(it.next(), is(4));
        assertThat(it.hasNext(), is(true));
        assertThat(it.next(), is(7));
    }

    @Test
    public void sequentialHasNextInvocationDoesntAffectRetrievalOrder () {
        assertThat(it.hasNext(), is(true));
        assertThat(it.hasNext(), is(true));
        assertThat(it.next(), is(1));
        assertThat(it.next(), is(4));
        assertThat(it.next(), is(7));
    }

    @Test(expected = NoSuchElementException.class)
    public void shoulThrowNoSuchElementException () {
        it = new IteratorArray(new int[][]{});
        it.next();
    }
}
