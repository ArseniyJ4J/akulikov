package ru.job4j.multithreading.waitnotify;

/**
 * CustomerProducer Class.
 * @author Arseniy Kulikov.
 * @since 02.11.2017.
 * @version 1.
 */
public class CustomerProducer {

    /**
     * Метод main.
     * @param args - параметр.
     */
    public static void main(String[] args) {

        System.out.printf("Thread: %s, start...%n============================%n", Thread.currentThread().getName());

        BlockingQueue bq = new BlockingQueue(5);

        Thread customer = new Thread(new Customer(bq));
        Thread producer = new Thread(new Producer(bq));
        customer.start();
        producer.start();

        try {
            producer.join();
            customer.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.printf("============================%nThread: %s, FINISH!%n", Thread.currentThread().getName());
    }
}
