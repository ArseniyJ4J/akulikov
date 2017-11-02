package ru.job4j.multithreading.waitnotify;

/**
 * Customer Class.
 * @author Arseniy Kulikov.
 * @since 02.11.2017.
 * @version 1.
 */
public class Customer implements Runnable {

    /**
     * Поле класса.
     */
    private BlockingQueue bq;

    /**
     * Конструктор.
     * @param bq - буфер-контенер.
     */
    public Customer(BlockingQueue bq) {
        this.bq = bq;
    }

    @Override
    public void run() {
        for (int i = 0; i < 20; i++) {
            try {
                this.bq.put(i);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        bq.setSomethingElse(false);
    }
}
