package ru.job4j.thread;

import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

public class SimpleBlockingQueueTest {
    private SimpleBlockingQueue<Integer> queue;
    private List<Integer> actual;

    @Before
    public void setUp() {
        queue = new SimpleBlockingQueue<>(4);
        actual = new ArrayList<>();
    }


    @Test
    public void whenSimpleBlockingQueueTest() throws InterruptedException {
        Thread produce = new Thread() {
            @Override
            public void run() {
                try {
                    queue.offer(1);
                    queue.offer(2);
                    queue.offer(3);
                    queue.offer(4);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        };
        Thread consumer = new Thread() {
            @Override
            public void run() {
                try {
                    actual.add(queue.poll());
                    actual.add(queue.poll());
                    actual.add(queue.poll());
                    actual.add(queue.poll());
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        };
        consumer.start();
        produce.start();
        produce.join();
        consumer.join();
        List<Integer> expected = Arrays.asList(1, 2, 3, 4);
        assertThat(actual, is(expected));
        assertThat(queue.size(), is(0));

    }
}
