package ru.job4j.thread;

import net.jcip.annotations.GuardedBy;
import net.jcip.annotations.ThreadSafe;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.concurrent.LinkedBlockingQueue;

/**
 * Class User
 *
 * @author Konstantin Inozemcev (9715791@gmail.com)
 * @version $Id$
 * @since 0.1
 */
@ThreadSafe
public class ThreadPool {
    /**
     *Список для хранения нитей
     */
    private final List<Thread> threads = new LinkedList<>();
    /**
     *Блокирующая очередь для хранения задач
     */
    @GuardedBy("this")
    private final Queue<Runnable> tasks = new LinkedBlockingQueue<>();

    /**
     * Количество нитей
     */
    private static final int CORESIZE = Runtime.getRuntime().availableProcessors();

    /**
     * Флаг блокировки нити
     */
    private boolean isRunning = true;


    /**
     * Конструктор - создание нового объекта
     */
    public ThreadPool() {
        init();
    }


    /**
     * Метод инициализирует пул нитей
     */
    private void init() {
        for (int i = 0; i < CORESIZE; i++) {
            Thread thread = new Thread(new PoolsThread(tasks));
            threads.add(thread);
            thread.start();
        }
    }

    /**
     * Метод возвращает количество нитей
     * @return CORESIZE
     */
    public int getSize() {
        return CORESIZE;
    }

    /**
     * Class PoolsThread
     *
     */
    private class PoolsThread extends Thread {
        private Queue<Runnable> tasks;

        public PoolsThread(Queue<Runnable> tasks) {
            this.tasks = tasks;
        }

        public void run() {
            Runnable r = null;
            while (isRunning) {
                synchronized (tasks) {
                    while (tasks.isEmpty() && isRunning) {
                        try {
                            tasks.wait();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                    r = (Runnable) tasks.poll();
                }
                try {
                    if (r != null) {
                        r.run();
                    }
                } catch (RuntimeException e) {
                    System.out.println("Thread pool is interrupted due to an issue: " + e.getMessage());
                }
            }
        }
    }
    /**
     * Метод добавляет задачи в блокирующую очередь
     * @param job
     */
    public void work(Runnable job) {
        synchronized (tasks) {
            this.tasks.add(job);
            tasks.notifyAll();
        }
    }

    /**
     * Метод  останавливает все нити из пула
     */
    public void shutdown() {
        isRunning = false;
        synchronized (tasks) {
            for (Thread th : threads) {
                if (!th.isInterrupted())
                    try {
                        th.interrupt();
                    } catch (SecurityException ignore) {
                    } finally {
                        tasks.notifyAll();
                    }
            }
        }
    }

}
