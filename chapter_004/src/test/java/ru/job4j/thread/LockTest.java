package ru.job4j.thread;

import org.junit.Test;

public class LockTest {
    Integer moneyAmount = 100;
    SimpleLock lock = new SimpleLock();

    public void getMoney(int money) throws InterruptedException {

        lock.lock();
        if (moneyAmount >= money) {
            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            moneyAmount -= money;

            System.err.println("New amount: " + moneyAmount);
        } else {
            System.out.println("No enough money");
        }
        lock.unlock();
    }


    @Test
    public void whenTestLockThreads() throws InterruptedException {
        Thread thread1 = new Thread() {
            @Override
            public void run() {
                try {
                    getMoney(50);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        };

        Thread thread2 = new Thread() {
            @Override
            public void run() {
                try {
                    getMoney(100);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        };


        Thread thread3 = new Thread() {
            @Override
            public void run() {
                try {
                    getMoney(100);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        };

        thread1.start();
        thread2.start();
        thread3.start();
        thread1.join();
        thread2.join();
        thread3.join();

    }
}
