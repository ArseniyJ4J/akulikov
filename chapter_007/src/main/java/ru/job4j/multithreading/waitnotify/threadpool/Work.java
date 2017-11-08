package ru.job4j.multithreading.waitnotify.threadpool;

/**
 * Work Class.
 * @author Arseniy Kulikov.
 * @since 08.11.2017.
 * @version 1.
 */
public class Work implements Runnable {

    /**
     * Поле класса.
     */
    private int number;

    /**
     * Конструктор.
     * @param number - номер.
     */
    public Work(int number) {
        this.number = number;
    }

    @Override
    public void run() {
        try {
            Thread.sleep(2);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.printf("Work-%s done.%n", this.number);
    }
}
