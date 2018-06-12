package ru.job4j.thread;

import net.jcip.annotations.GuardedBy;
import net.jcip.annotations.ThreadSafe;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 *  Class SimpleLock реализует  механизм блокировок объекта
 *
 * @author Konstantin Inozemcev (9715791@gmail.com)
 * @version $Id$
 * @since 0.1
 */
@ThreadSafe
public class SimpleLock {
    /**
     * Флаг блокировки объекта
     */
    @GuardedBy("this")
    private boolean isLocked = false;

    /**
     * Метод проверяет свободен ли лок?
     * Если да - захватывает, иначе блокируется
     */
   public void lock() throws InterruptedException {
        synchronized (this) {
            while (isLocked) {
                wait();
            }
            isLocked = true;
        }
    }

    /**
     *  Метод проверяет владеет ли поток локом?
     *  Если да то - освобождает.
     */
 public  void unlock() {
        synchronized (this) {
            isLocked = false;
            notify();
        }
    }

}
