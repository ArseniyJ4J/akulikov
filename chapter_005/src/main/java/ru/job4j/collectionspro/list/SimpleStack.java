package ru.job4j.collectionspro.list;

import java.util.NoSuchElementException;

/** Класс SimpleStack.
 * @author Arseniy Kulkiov
 * @since 29.08.2017
 * @version 1
 * @param <E> - параметризованный тип.
 */

public class SimpleStack<E> {

    /**
     * Поле класса SimpleLinkedList - контейнер для элементов стека.
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
     * Метод добавления в стек.
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
            E result = sll.delete(this.size() - 1);
            return result;
        } else {
            throw new NoSuchElementException();
        }
    }
}
