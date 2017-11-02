package ru.job4j.multithreading.waitnotify;

/**
 * Producer Class.
 * @author Arseniy Kulikov.
 * @since 02.11.2017.
 * @version 1.
 */
public class Producer implements Runnable {

    /**
     * Поле класса.
     */
    private BlockingQueue bq;

    /**
     * Конструктор.
     * @param bq - буфер-контенер.
     */
    public Producer(BlockingQueue bq) {
        this.bq = bq;
    }

    @Override
    public void run() {
        while (bq.getSomethingElse() || bq.size() > 0) {
            try {
                bq.take();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
