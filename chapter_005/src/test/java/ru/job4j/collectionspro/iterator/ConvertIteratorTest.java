package ru.job4j.collectionspro.iterator;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/** Class ConvertIteratorTest.
 * @author Arseniy Kulkiov
 * @since 18.08.2017
 * @version 1
 */

public class ConvertIteratorTest {
    /**
     * Test.
     */
    @Test
    public void convert() {

        Iterator<Integer> it1 = Arrays.asList(new Integer[] {4, 2, 0, 4, 6, 4, 9}).iterator();
        Iterator<Integer> it2 = Arrays.asList(new Integer[] {0, 9, 8, 7, 5}).iterator();
        Iterator<Integer> it3 = Arrays.asList(new Integer[] {1, 3, 5, 6, 7, 0, 9, 8, 4}).iterator();

        Iterator<Iterator<Integer>> it = Arrays.asList(it1, it2, it3).iterator();

        List<Integer> expected = new ArrayList<>(Arrays.asList(new Integer[] {4, 2, 0, 4, 6, 4, 9, 0, 9, 8, 7, 5, 1, 3, 5, 6, 7, 0, 9, 8, 4}));

        ConvertIterator ci = new ConvertIterator(it);
        Iterator<Integer> iter = ci.convert(it);
        List<Integer> result = new ArrayList<>();
        while (iter.hasNext()) {
            result.add(iter.next());
        }

        assertThat(result, is(expected));
    }
}