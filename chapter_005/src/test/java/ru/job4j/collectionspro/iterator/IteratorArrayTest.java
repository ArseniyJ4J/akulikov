package ru.job4j.collectionspro.iterator;

import org.junit.Test;

import static org.junit.Assert.assertThat;
import static org.hamcrest.core.Is.is;

/** Class Класс IteratorArrayTest.
 * @author Arseniy Kulkiov
 * @since 16.08.2017
 * @version 1
 */

public class IteratorArrayTest {
    /**
     * Test.
     */
    @Test
    public void testForNext() {
        int[][] value = {{1, 2}, {3, 4}};
        IteratorArray ita = new IteratorArray(value);
        String result = "";
        String expected = "1, 2, 3, 4, ";
        for (int i = 0; i < 4; i++) {
            result = String.format("%s%s, ", result, Integer.toString((Integer) (ita.next())));
        }
        assertThat(result, is(expected));
    }
    /**
     * Test.
     */
    @Test
    public void testForHasNextFalse() {
        int[][] value = {{1, 2}, {3, 4}};
        IteratorArray ita = new IteratorArray(value);
        ita.next();
        ita.next();
        ita.next();
        ita.next();
        boolean result = ita.hasNext();
        boolean expected = false;
        assertThat(result, is(expected));
    }
    /**
     * Test.
     */
    @Test
    public void testForHasNextTrue() {
        int[][] value = {{1, 2}, {3, 4}};
        IteratorArray ita = new IteratorArray(value);
        ita.next();
        ita.next();
        ita.next();
        boolean result = ita.hasNext();
        boolean expected = true;
        assertThat(result, is(expected));
    }
}