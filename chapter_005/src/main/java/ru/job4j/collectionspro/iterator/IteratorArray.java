package ru.job4j.collectionspro.iterator;

import java.util.Iterator;
import java.util.NoSuchElementException;

/** Class Класс IteratorArray.
 * @author Arseniy Kulkiov
 * @since 16.08.2017
 * @version 1
 */

public class IteratorArray implements Iterator {
    /**
     * Поле класса value. Двумерный массив.
     */
    private int[][] value;
    /**
     * Поле rowIndex - индекс по строке.
     */
    private int rowIndex = 0;
    /**
     * Поле colimnIndex - индекс по-вертикали.
     */
    private int columnIndex = 0;
    /**
     * Конструктор.
     * @param value - входящий двумерный массив.
     */
    public IteratorArray(int[][] value) {
        this.value = value;
    }
    /**
     * Геттер для поля value.
     * @return - возврат значения.
     */
    public int[][] getValue() {
        return this.value;
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
        return columnIndex < value.length && rowIndex < value[columnIndex].length;
    }
    /**
     * Returns the next element in the iteration.
     *
     * @return the next element in the iteration
     * @throws NoSuchElementException if the iteration has no more elements
     */
    @Override
    public Object next() {
        int result = 0;
        if (rowIndex == this.value[columnIndex].length) {
            columnIndex++;
            rowIndex = 0;
        }
        if (hasNext()) {
            result = this.value[columnIndex][rowIndex++];
        } else {
            throw new NoSuchElementException();
        }
        return result;
    }
}
