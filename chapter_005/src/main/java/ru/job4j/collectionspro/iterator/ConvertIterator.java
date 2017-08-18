package ru.job4j.collectionspro.iterator;

import java.util.Iterator;

/** Class ConvertIterator.
 * @author Arseniy Kulkiov
 * @since 18.08.2017
 * @version 1
 */

public class ConvertIterator implements Iterator {
    /**
     * Поле класса итератор итераторов целых чисел.
     */
    private Iterator<Iterator<Integer>> it;
    /**
     * Поле класса внутренний итератор.
     */
    private Iterator<Integer> inner;
    /**
     * Конструктор.
     * @param it - параметр.
     */
    public ConvertIterator(Iterator<Iterator<Integer>> it) {
        this.it = it;
    }
    /**
     * Returns {@code true} if the iteration has more elements.
     * (In other words, returns {@code true} if {@link #next} would
     * return an element rather than throwing an exception.)
     *
     * @return {@code true} if the iteration has more elements
     */
    @Override
    public boolean hasNext() {
        return (inner.hasNext() || it.hasNext());
    }
    /**
     * Returns the next element in the iteration.
     *
     * @return the next element in the iteration
     * @throws NoSuchElementException if the iteration has no more elements
     */
    @Override
    public Object next() {
        Integer result;
        if (inner.hasNext()) {
            result = inner.next();
        } else {
            inner = it.next();
            result = inner.next();
        }
        return result;
    }
    /**
     * Метод конвертирующий итератор итераторов целых чисел в итератор целых чисел.
     * @param it - параметр типа Iterator<Iterator<Integer>>.
     * @return - возврат значения.
     */
    public Iterator<Integer> convert(Iterator<Iterator<Integer>> it) {
        this.it = it;
        if (it.hasNext()) {
            this.inner = it.next();
        }
        return this;
    }
}
