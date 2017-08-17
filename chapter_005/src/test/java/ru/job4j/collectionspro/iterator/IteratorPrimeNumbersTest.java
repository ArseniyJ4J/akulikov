package ru.job4j.collectionspro.iterator;

import org.junit.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;

/** Класс IteratorPrimeNumbersTest.
 * @author Arseniy Kulkiov
 * @since 17.08.2017
 * @version 1
 */

public class IteratorPrimeNumbersTest {
    /**
     * Test hasNext Method.
     */
    @Test
    public void hasNextTrue1() {
        int[] numbers = {3, 4, 5, 6, 7};
        IteratorPrimeNumbers ien = new IteratorPrimeNumbers(numbers);
        boolean result = ien.hasNext();
        boolean expected = true;
        assertThat(result, is(expected));
    }
    /**
     * Test hasNext Method.
     */
    @Test
    public void hasNextTrue2() {
        int[] numbers = {4, 6, 7};
        IteratorPrimeNumbers ien = new IteratorPrimeNumbers(numbers);
        boolean result = ien.hasNext();
        boolean expected = true;
        assertThat(result, is(expected));
    }
    /**
     * Test hasNext Method.
     */
    @Test
    public void hasNextFalse1() {
        int[] numbers = {4, 6, 8};
        IteratorPrimeNumbers ien = new IteratorPrimeNumbers(numbers);
        boolean result = ien.hasNext();
        boolean expected = false;
        assertThat(result, is(expected));
    }
    /**
     * Test next method.
     */
    @Test
    public void nextTest1() {
        int[] numbers = {3, 4, 5, 6, 7};
        IteratorPrimeNumbers ien = new IteratorPrimeNumbers(numbers);
        String result = "";
        String expected = "3, 5, 7, ";
        for (int i = 0; i < 3; i++) {
            result = String.format("%s%s, ", result, Integer.toString((Integer) (ien.next())));
        }
        assertThat(result, is(expected));
    }
    /**
     * Test next method.
     */
    @Test
    public void nextTest2() {
        int[] numbers = {3, 4, 6};
        IteratorPrimeNumbers ien = new IteratorPrimeNumbers(numbers);
        String result = "";
        String expected = "3, ";
        for (int i = 0; i < 1; i++) {
            result = String.format("%s%s, ", result, Integer.toString((Integer) (ien.next())));
        }
        assertThat(result, is(expected));
    }
    /**
     * Test next method.
     */
    @Test
    public void nextTest3() {
        int[] numbers = {4, 6, 8, 11};
        IteratorPrimeNumbers ien = new IteratorPrimeNumbers(numbers);
        String result = "";
        String expected = "11, ";
        for (int i = 0; i < 1; i++) {
            result = String.format("%s%s, ", result, Integer.toString((Integer) (ien.next())));
        }
        assertThat(result, is(expected));
    }
}