package ru.job4j.collectionspro.set;

import ru.job4j.collectionspro.list.SimpleLinkedList;

import java.util.Iterator;
import java.util.NoSuchElementException;

/** Класс SimpleLinkedSet.
 * @author Arseniy Kulkiov
 * @since 31.08.2017
 * @version 1
 * @param <E> - параметризованный тип.
 */

public class SimpleLinkedSet<E> implements Iterable<E> {
    /**
     * Поле класса container.
     */
    private SimpleLinkedList<E> container = new SimpleLinkedList<>();

    /**
     * Геттер для поля container.
     * @return - возврат значения.
     */
    public SimpleLinkedList<E> getContainer() {
        return container;
    }

    /**
     * Метод проверяющий уникальность добавляемого элемента.
     * @param e - добавляемый элемент.
     * @return - возврат значения.
     */
    public boolean checkUniq(E e) {
        boolean result = true;
        for (int i = 0; i < this.container.getSize(); i++) {
            if (this.container.get(i) == e) {
                result = false;
                break;
            }
        }
        return result;
    }

    /**
     * Метод добавления элемента в контейнер.
     * @param e - добавляемый элемент.
     */
    public void add(E e) {
        if (this.checkUniq(e)) {
            this.container.add(e);
        }
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
                return this.point < container.getSize();
            }

            @Override
            public E next() {
                if (this.point < container.getSize()) {
                    return container.get(point++);
                } else {
                    throw new NoSuchElementException();
                }
            }
        };
    }
}
