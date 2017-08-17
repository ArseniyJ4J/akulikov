package ru.job4j.collectionspro.iterator;

import org.junit.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;

/** Класс IteratorEvenNumbersTest.
 * @author Arseniy Kulkiov
 * @since 17.08.2017
 * @version 1
 */

public class IteratorEvenNumbersTest {
    /**
     * Test hasNext Method.
     */
    @Test
    public void hasNextTrue1() {
        int[] numbers = {2, 1, 1};
        IteratorEvenNumbers ien = new IteratorEvenNumbers(numbers);
        boolean result = ien.hasNext();
        boolean expected = true;
        assertThat(result, is(expected));
    }
    /**
     * Test hasNext Method.
     */
    @Test
    public void hasNextTrue2() {
        int[] numbers = {1, 1, 2};
        IteratorEvenNumbers ien = new IteratorEvenNumbers(numbers);
        boolean result = ien.hasNext();
        boolean expected = true;
        assertThat(result, is(expected));
    }
    /**
     * Test hasNext Method.
     */
    @Test
    public void hasNextFalse1() {
        int[] numbers = {1, 1, 1};
        IteratorEvenNumbers ien = new IteratorEvenNumbers(numbers);
        boolean result = ien.hasNext();
        boolean expected = false;
        assertThat(result, is(expected));
    }
    /**
     * Test hasNext Method.
     */
    @Test
    public void hasNextFalse2() {
        int[] numbers = {2, 1, 1};
        IteratorEvenNumbers ien = new IteratorEvenNumbers(numbers);
        ien.hasNext();
        ien.next();
        ien.hasNext();
        boolean result = ien.hasNext();
        boolean expected = false;
        assertThat(result, is(expected));
    }
    /**
     * Test next method.
     */
    @Test
    public void nextTest1() {
        int[] numbers = {2, 4, 1, 1};
        IteratorEvenNumbers ien = new IteratorEvenNumbers(numbers);
        String result = "";
        String expected = "2, 4, ";
        for (int i = 0; i < 2; i++) {
            result = String.format("%s%s, ", result, Integer.toString((Integer) (ien.next())));
        }
        assertThat(result, is(expected));
    }
    /**
     * Test next method.
     */
    @Test
    public void nextTest2() {
        int[] numbers = {2, 1, 4, 1};
        IteratorEvenNumbers ien = new IteratorEvenNumbers(numbers);
        String result = "";
        String expected = "2, 4, ";
        for (int i = 0; i < 2; i++) {
            result = String.format("%s%s, ", result, Integer.toString((Integer) (ien.next())));
        }
        assertThat(result, is(expected));
    }
    /**
     * Test next method.
     */
    @Test
    public void nextTest3() {
        int[] numbers = {2, 4, 1, 1, 4};
        IteratorEvenNumbers ien = new IteratorEvenNumbers(numbers);
        String result = "";
        String expected = "2, 4, 4, ";
        for (int i = 0; i < 3; i++) {
            result = String.format("%s%s, ", result, Integer.toString((Integer) (ien.next())));
        }
        assertThat(result, is(expected));
    }
    /**
     * Test next method.
     */
    @Test
    public void nextTest4() {
        int[] numbers = {3, 2, 4, 1, 0, 1};
        IteratorEvenNumbers ien = new IteratorEvenNumbers(numbers);
        String result = "";
        String expected = "2, 4, 0, ";
        for (int i = 0; i < 3; i++) {
            result = String.format("%s%s, ", result, Integer.toString((Integer) (ien.next())));
        }
        assertThat(result, is(expected));
    }
    /**
     * Test next method.
     */
    @Test
    public void nextTest5() {
        int[] numbers = {1, 4, 1, 1};
        IteratorEvenNumbers ien = new IteratorEvenNumbers(numbers);
        String result = "";
        String expected = "4, ";
        for (int i = 0; i < 1; i++) {
            result = String.format("%s%s, ", result, Integer.toString((Integer) (ien.next())));
        }
        assertThat(result, is(expected));
    }
}