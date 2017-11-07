package ru.job4j.multithreading.waitnotify;

/**
 * Producer Class.
 * @author Arseniy Kulikov.
 * @since 02.11.2017.
 * @version 1.
 */
public class Customer implements Runnable {

    /**
     * Поле класса.
     */
    private final BlockingQueue bq;

    /**
     * Конструктор.
     * @param bq - буфер-контенер.
     */
    public Customer(BlockingQueue bq) {
        this.bq = bq;
    }

    @Override
    public void run() {
        while (true) {
            try {
                bq.take();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}