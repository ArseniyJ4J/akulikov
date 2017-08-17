package ru.job4j.collectionspro.iterator;

import java.math.BigInteger;
import java.util.Iterator;
import java.util.NoSuchElementException;

/** Класс IteratorPrimeNumbers.
 * @author Arseniy Kulkiov
 * @since 17.08.2017
 * @version 1
 */

public class IteratorPrimeNumbers implements Iterator {
    /**
     * Поле класса numbers. Массив целых чисел.
     */
    private final int[] numbers;
    /**
     * Поле класса index. Текущее значение итератора.
     */
    private int index = 0;
    /**
     * Конструктор.
     * @param numbers - входящий массив целых чисел.
     */
    public IteratorPrimeNumbers(final int[] numbers) {
        this.numbers = numbers;
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
        boolean result = false;
        if (index < numbers.length) {
            for (int i = index; i < numbers.length; i++) {
                BigInteger value = BigInteger.valueOf(numbers[i]);
                if (value.isProbablePrime((int) Math.log(numbers[i]))) {
                    result = true;
                    index = i;
                    break;
                }
            }
        }
        return result;
    }
    /**
     * Returns the next element in the iteration.
     *
     * @return the next element in the iteration
     * @throws NoSuchElementException if the iteration has no more elements
     */
    @Override
    public Object next() {
        int value;
        if (hasNext()) {
            value = numbers[index++];
        } else {
            throw new NoSuchElementException();
        }
        return value;
    }
}
