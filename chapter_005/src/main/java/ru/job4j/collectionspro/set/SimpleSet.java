package ru.job4j.collectionspro.set;

import java.util.Iterator;
import java.util.NoSuchElementException;

/** Класс SimpleSet.
 * @author Arseniy Kulkiov
 * @since 31.08.2017
 * @version 1
 * @param <E> - параметризованный тип.
 */

public class SimpleSet<E> implements Iterable<E> {

    /**
     * Поле класса.
     */
    private Object[] container = new Object[5];

    /**
     * Поле класса.
     */
    private int count = 0;

    /**
     * Геттер для поля класса container.
     * @return - возврат значения.
     */
    public Object[] getContainer() {
        return container;
    }

    /**
     * Метод проверяющий уникальность добавляемого элемента.
     * @param e - добавляемый элемент.
     * @return - возврат значения.
     */
    private boolean checkUnique(E e) {
        boolean result = false;
        for (int i = 0; i < count; i++) {
            if (result) {
                break;
            }
            result = this.container[i].equals(e);
        }
        return !result;
    }

    /**
     * Метод добавления элемента в контейнер.
     * @param e - добавляемый элемент.
     */
    public void add(E e) {
        if (count == container.length) {
            int newSize = ((container.length * 3) / 2) + 1;
            Object[] newContainer = new Object[newSize];
            System.arraycopy(this.container, 0, newContainer, 0, container.length);
            this.container = newContainer;
        }
        if (checkUnique(e)) {
            container[count++] = e;
        }
    }

    /**
     * Returns an iterator over elements of type {@code T}.
     * @return an Iterator.
     */
    @Override
    public Iterator<E> iterator() {
        return new Iterator<E>() {
            private int point = 0;
            @Override
            public boolean hasNext() {
                return count > this.point;
            }

            @Override
            public E next() {
                if (count > this.point) {
                    return (E) container[this.point++];
                } else {
                    throw new NoSuchElementException();
                }
            }
        };
    }
}
