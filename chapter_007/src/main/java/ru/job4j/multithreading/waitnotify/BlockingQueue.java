package ru.job4j.multithreading.waitnotify;

import java.util.LinkedList;
import java.util.List;

/**
 * BlockingQueue Class.
 * @author Arseniy Kulikov.
 * @since 01.11.2017.
 * @version 1.
 * @param <T> - параметризованный тип.
 */
public class BlockingQueue<T> {

    /**
     * Поле класса.
     */
    private List<T> queue = new LinkedList();

    /**
     * Поле класса.
     */
    private int limit = 0;

    /**
     * Поле класса.
     */
    private boolean somethingElse = true;

    /**
     * Геттер для поля somethingElse.
     * @return - возврат значения.
     */
    public boolean getSomethingElse() {
        return somethingElse;
    }

    /**
     * Сеттер для поля somethingElse.
     * @param somethingElse - новое значение поля.
     */
    public void setSomethingElse(boolean somethingElse) {
        this.somethingElse = somethingElse;
    }

    /**
     * Метод возращающий размер контейнера.
     * @return - возвра значения.
     */
    public int size() {
        return queue.size();
    }

    /**
     * Конструктор.
     * @param limit - новый размер.
     */
    public BlockingQueue(int limit) {
        this.limit = limit;
    }

    /**
     * Метод добавления элемента в контейнер.
     * @param item - добавляемое значение.
     * @throws InterruptedException - исключение.
     */
    public synchronized void put(T item) throws InterruptedException {
        while (this.queue.size() == this.limit) {
            System.out.printf("Thread: %s, BQ PUT method waiting..%n", Thread.currentThread().getName());
            wait();
        }
        if (this.queue.size() == 0) {
            System.out.printf("Thread: %s, BQ PUT method notifyall!%n", Thread.currentThread().getName());
            notifyAll();
        }
        System.out.printf("Thread: %s, BQ PUT method add item \"%s\".%n", Thread.currentThread().getName(), item);
        this.queue.add(item);
    }

    /**
     * Метод получения элемента из контейнера.
     * @return - возврат значения.
     * @throws InterruptedException - исключение.
     */
    public synchronized T take() throws InterruptedException {
        while (this.queue.size() == 0) {
            System.out.printf("Thread: %s, BQ TAKE method waiting..%n", Thread.currentThread().getName());
            wait();
        }
        if (this.queue.size() == this.limit) {
            System.out.printf("Thread: %s, BQ TAKE method notifyall!%n", Thread.currentThread().getName());
            notifyAll();
        }
        T item = this.queue.remove(0);
        System.out.printf("Thread: %s, BQ TAKE item - \"%s\" done.%n", Thread.currentThread().getName(), item);
        return item;
    }
}
