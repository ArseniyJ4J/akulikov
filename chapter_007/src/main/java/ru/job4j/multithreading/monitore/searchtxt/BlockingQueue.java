package ru.job4j.multithreading.monitore.searchtxt;

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
    private boolean willBeNew = true;

    /**
     * Геттер для поля willBeNew.
     * @return - возврат значения.
     */
    public boolean getWillBeNew() {
        return willBeNew;
    }

    /**
     * Сеттер для поля willBeNew.
     * @param willBeNew - новое значение поля.
     */
    public void setWillBeNew(boolean willBeNew) {
        this.willBeNew = willBeNew;
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
            wait();
        }
        if (this.queue.size() == 0) {
            notifyAll();
        }
        this.queue.add(item);
    }

    /**
     * Метод получения элемента из контейнера.
     * @return - возврат значения.
     * @throws InterruptedException - исключение.
     */
    public synchronized T take() throws InterruptedException {
        while (this.queue.size() == 0) {
            wait();
        }
        if (this.queue.size() == this.limit) {
            notifyAll();
        }
        T item = this.queue.remove(0);
        return item;
    }
}
