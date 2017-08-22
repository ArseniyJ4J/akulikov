package ru.job4j.collectionspro.list;

import java.util.Iterator;
import java.util.NoSuchElementException;

/** Класс SimpleArrayList.
 * @author Arseniy Kulkiov
 * @since 22.08.2017
 * @version 1
 * @param <E> - параметризованный тип.
 */

public class SimpliArrayList<E> implements Iterable<E> {
    /**
     * Поле класса.
     */
    private Object[] container = new Object[10];
    /**
     * Поле класса.
     */
    private int index = 0;

    /**
     * Метод добавления.
     * @param value - добавляемое значение.
     */
    public void add(E value) {
        if (index == container.length) {
            int newSize = ((container.length * 3) / 2) + 1;
            Object[] newContainer = new Object[newSize];
            System.arraycopy(this.container, 0, newContainer, 0, container.length);
            this.container = newContainer;
        } else {
            container[index++] = value;
        }
    }

    /**
     * Метод получения значения.
     * @param index - индекс значения.
     * @return - возврат значения.
     */
    public E get(int index) {
        return (E) this.container[index];
    }

    /**
     * Returns an iterator over elements of type {@code T}.
     *
     * @return an Iterator.
     */
    @Override
    public Iterator<E> iterator() {
        return new Iterator<E>() {

            private int point = 0;

            @Override
            public boolean hasNext() {
                return this.point < index;
            }

            @Override
            public E next() {
                if (point < index) {
                    return (E) container[this.point++];
                } else {
                    throw new NoSuchElementException();
                }
            }
        };
    }
}
