package ru.job4j.collectionspro.set;

import java.util.Arrays;
import java.util.Iterator;

/** Класс FastSimpleSet.
 * @author Arseniy Kulkiov
 * @since 21.09.2017
 * @version 1
 * @param <E> - параметризованный тип.
 */

public class FastSimpleSet<E> implements Iterable<E> {
    /**
     * Поле класса.
     */
    private Object[] container;
    /**
     * Поле класса.
     */
    private int index = 0;
    /**
     * Поле класса.
     */
    private int[] hash;
    /**
     * Поле класса.
     */
    private int indexHash = 0;
    /**
     * Конструктор.
     */
    public FastSimpleSet() {
        this.container = new Object[16];
        this.hash = new int[16];
    }

    /**
     * Метод добавления элемента в контейнер.
     * @param value - добавляемое значение.
     */
    public void add(E value) {
        int searchResult = Arrays.binarySearch(this.hash, 0, this.indexHash, value.hashCode());
        if (searchResult < 0) {
            if (this.index > (this.container.length - 1)) {
                this.container = Arrays.copyOf(this.container, this.container.length * 2);
            }
            this.container[this.index++] = value;
        }
        this.addHash((Math.abs(searchResult) - 1), value);
    }
    /**
     * Метод добавления хэша в массив hash в отсортированном порядке.
     * @param indexHash - индекс позиции добавления.
     * @param value - элемент хэш-код которого будет добавлен.
     */
    public void addHash(int indexHash, E value) {
        if (this.indexHash >= (this.hash.length - 1)) {
            this.hash = Arrays.copyOf(this.hash, this.hash.length * 2);
        }
        if (this.indexHash > indexHash) {
            this.hash[this.indexHash++] = value.hashCode();
        } else {
            System.arraycopy(this.hash, indexHash, this.hash, indexHash + 1, this.hash.length - index - 1);
            this.hash[indexHash] = value.hashCode();
            this.indexHash++;
        }
    }

    /**
     * Метод получения элемента из контейнера по индексу.
     * @param index - индекс.
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

            private int itIndex = 0;
            /**
             * Returns {@code true} if the iteration has more elements.
             * (In other words, returns {@code true} if {@link #next} would
             * return an element rather than throwing an exception.)
             *
             * @return {@code true} if the iteration has more elements
             */
            @Override
            public boolean hasNext() {
                return index > this.itIndex;
            }

            /**
             * Returns the next element in the iteration.
             *
             * @return the next element in the iteration
             */
            @Override
            public E next() {
                return (E) container[this.itIndex++];
            }
        };
    }
}
