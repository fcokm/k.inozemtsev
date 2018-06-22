package ru.job4j.thread;

/**
 * Class CachePoint
 *
 * @author Konstantin Inozemcev (9715791@gmail.com)
 * @version $Id$
 * @since 0.1
 */
public class CachePoint {
     static int moneyAmount = 100;

    static  void getMoney(int money) {
        //synchronized (moneyAmount) {
            if (moneyAmount >= money) {
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                moneyAmount -= money;

                System.err.println("New amount: " + moneyAmount);
            } else {
                System.out.println("No enough money");
            }
       // }
    }

    public static void main(String[] args) {
        new Thread(new Runnable() {
            @Override
            public void run() {
              getMoney(50);
            }
        }).start();

        new Thread(new Runnable() {
            @Override
            public void run() {
                getMoney(100);
            }
        }).start();

        new Thread(new Runnable() {
            @Override
            public void run() {
                getMoney(100);
            }
        }).start();
    }


}
