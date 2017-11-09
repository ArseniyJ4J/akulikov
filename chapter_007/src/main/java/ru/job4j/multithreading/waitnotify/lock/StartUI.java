package ru.job4j.multithreading.waitnotify.lock;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * StratUI Class.
 * @author Arseniy Kulikov.
 * @since 09.11.2017.
 * @version 1.
 */
public class StartUI {

    /**
     * Внутренний класс Demonstration.
     */
    private static class Demostration {

        /**
         * Поле класса.
         */
        Lock locker;

        /**
         * Поле класса.
         */
        private int result = 0;

        /**
         * Конструктор.
         * @param locker - параметр.
         */
        public Demostration(Lock locker) {
            this.locker = locker;
        }

        /**
         * Метод инкрементирования.
         */
        public void inc() {
            locker.lock();
            this.result++;
            locker.unlock();
        }

        /**
         * Метод декрементирования.
         */
        public void dec() {
            locker.lock();
            this.result--;
            locker.unlock();
        }
    }

    /**
     * Метод main.
     * @param args - параметр.
     */
    public static void main(String[] args) {

        Lock locker = new SimpleLock();

        Lock locker2 = new ReentrantLock();

        for (int i = 0; i < 1000; i++) {

//            Demostration demo = new Demostration(locker2);

            Demostration demo = new Demostration(locker);

            Thread thread0 = new Thread(new Runnable() {
                @Override
                public void run() {
                    for (int i = 0; i < 100000; i++) {
                        demo.dec();
                    }
                }
            });

            Thread thread1 = new Thread(new Runnable() {
                @Override
                public void run() {
                    for (int i = 0; i < 100000; i++) {
                        demo.inc();
                    }
                }
            });

            thread0.start();
            thread1.start();

            try {
                thread0.join();
                thread1.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            if (demo.result != 0) {
                System.out.println(demo.result);
            }
        }
    }
}
