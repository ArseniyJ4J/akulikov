package ru.job4j.multithreading.monitore;

import net.jcip.annotations.ThreadSafe;

import java.util.Iterator;
import java.util.NoSuchElementException;

/** Класс ThreadArrayList.
 * @author Arseniy Kulkiov
 * @since 30.10.2017
 * @version 1
 * @param <E> - параметризованный тип.
 */

@ThreadSafe
public class ThreadArrayList<E> implements Iterable<E> {
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
    public synchronized void add(E value) {
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
    public synchronized E get(int index) {
        return (E) this.container[index];
    }

    /**
     * Returns an iterator over elements of type {@code T}.
     *
     * @return an Iterator.
     */
    @Override
    public synchronized Iterator<E> iterator() {
        return new Iterator<E>() {

            private int point = 0;

            @Override
            public synchronized boolean hasNext() {
                return this.point < index;
            }

            @Override
            public synchronized E next() {
                if (point < index) {
                    return (E) container[this.point++];
                } else {
                    throw new NoSuchElementException();
                }
            }
        };
    }
}
