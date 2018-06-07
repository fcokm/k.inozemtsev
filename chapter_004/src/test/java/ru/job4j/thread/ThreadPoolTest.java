package ru.job4j.thread;

import org.junit.Test;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.CountDownLatch;


public class ThreadPoolTest {
    SimpleDateFormat sdf = null;
    private final int COUNT = 4;



    @Test
    public void whenThreadPoolTest() throws InterruptedException {
        ThreadPool pool = new ThreadPool();
        for (int i = 0; i < 10; i++) {
            pool.work(new WorkerThread(Thread.currentThread().getName()));
        }
        pool.shutdown();
    }

    @Test
    public void whenThreadPoolTestTwo() throws InterruptedException {
        ThreadPool pool = new ThreadPool();
        sdf = new SimpleDateFormat("HH:mm:ss.S");
        CountDownLatch cdl1 = new CountDownLatch(COUNT);
        CountDownLatch cdl2 = new CountDownLatch(COUNT);
        CountDownLatch cdl3 = new CountDownLatch(COUNT);
        CountDownLatch cdl4 = new CountDownLatch(COUNT);
        System.out.println("Запуск потоков");
        pool.work(new MyThread(cdl1, Thread.currentThread().getName()));
        pool.work(new MyThread(cdl2, Thread.currentThread().getName()));
        pool.work(new MyThread(cdl3, Thread.currentThread().getName()));
        pool.work(new MyThread(cdl4, Thread.currentThread().getName()));
        try {
            cdl1.await();
            cdl2.await();
            cdl3.await();
            cdl4.await();
        } catch (InterruptedException exc) {
        }

        pool.shutdown();
        System.out.println("Завершение потоков");

    }
    public class WorkerThread implements Runnable {

        private String command;

        public WorkerThread(String s) {
            this.command = s;
        }

        @Override
        public void run() {
            System.out.printf("%5s %5s %s %n", Thread.currentThread().getName(), " Start. Command =", command);
            processCommand();

            System.out.println(Thread.currentThread().getName() + " End.");
        }

        private void processCommand() {
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {

            }
        }
    }


    class Task implements Runnable {
        @Override
        public void run() {
            try {
                Thread.sleep(1000);
                System.out.println(Thread.currentThread().getName()
                        + " is executing task.");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    class MyThread implements Runnable {
        String name;
        CountDownLatch latch;


        MyThread(CountDownLatch c, String n) {
            latch = c;
            name = n;
            new Thread(this);
        }

        void printMessage(final String templ) {
            String text = sdf.format(new Date()) + " : " + templ;
            System.out.println(text);
        }

        public void run() {
            try {
                for (int i = 0; i < COUNT; i++) {
                    printMessage(name + " - " + i);
                    latch.countDown();
                    Thread.sleep(100);
                    Thread.sleep((long) (Math.random() * 500));
                }
                printMessage(name + " completed");
            } catch (InterruptedException e) {
            }
        }
    }
}


