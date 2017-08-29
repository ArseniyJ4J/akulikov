package ru.job4j.collectionspro.list;

import java.util.NoSuchElementException;

/** Класс SimpleQueue.
 * @author Arseniy Kulkiov
 * @since 29.08.2017
 * @version 1
 * @param <E> - параметризованный тип.
 */

public class SimpleQueue<E> {

    /**
     * Поле класса SimpleLinkedList - контейнер для элементов очереди.
     */
    private SimpleLinkedList<E> sll = new SimpleLinkedList<>();

    /**
     * Метод возвращающий текущее значение размера контейнера.
     * @return - возврат значения.
     */
    public int size() {
        return sll.getSize();
    }

    /**
     * Метод добавления в очередь.
     * @param value - добавляемое значение.
     */
    public void push(E value) {
        sll.add(value);
    }

    /**
     * Метод возвращающий и удаляющий последнее добавленное в контейнер значение.
     * @return - возврат значения.
     */
    public E poll() {
        if (this.size() != 0) {
            E result = sll.delete(0);

            return result;
        } else {
            throw new NoSuchElementException();
        }
    }
}
