package ru.job4j.multithreading.monitore;

import net.jcip.annotations.GuardedBy;
import net.jcip.annotations.ThreadSafe;

/**
 * Count Class.
 * @author Arseniy Kulikov.
 * @since 29.10.2017.
 * @version 1.
 */
@ThreadSafe
public class Count {

    /**
     * Поле класса.
     */
    private int count = 0;

    /**
     * Внутренний класс Counter.
     */
    public static class Counter implements Runnable {

        /**
         * Поле класса count.
         */
        @GuardedBy("this")
        Count count;

        /**
         * Конструктор.
         * @param count - параметр.
         */
        Counter(Count count) {
            this.count = count;
        }

        @Override
        public void run() {
            count.incremant(1);
        }
    }

    /**
     * Метод инкрементирования.
     * @param value - значение, на которое следует увеличить.
     */
    void incremant(int value) {
        synchronized (this) {
            for (int i = 0; i < 1_00_000_000; i++) {
                this.count += value;
            }
        }
    }

    /**
     * Метод main.
     * @param args - параметр.
     */
    public static void main(String[] args) {
        Count count = new Count();
        Thread thread1 = new Thread(new Counter(count));
        Thread thread2 = new Thread(new Counter(count));
        Thread thread3 = new Thread(new Counter(count));
        thread1.start();
        thread2.start();
        thread3.start();
        try {
            thread1.join();
            thread2.join();
            thread3.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(count.count);
    }
}
