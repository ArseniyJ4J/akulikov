package ru.job4j.collectionspro.Set;

import org.junit.Test;

import java.util.Iterator;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
 * SimpleSetTest Class.
 * @author Arseniy Kulkiov
 * @since 31.08.2017
 * @version 1
 */

public class SimpleSetTest {

    /**
     * Test.
     */
    @Test
    public void addTest() {
        SimpleSet<String> ss = new SimpleSet<>();
        String[] array = {"Test1", "Test2", "Test3", "Test1"};
        String[] result = {"Test1", "Test2", "Test3", null, null};
        for (String value : array) {
            ss.add(value);
        }
        assertThat(ss.getContainer(), is(result));
    }

    /**
     * Test.
     */
    @Test
    public void iteratorTest() {
        SimpleSet<String> ss = new SimpleSet<>();
        String[] array = {"Test1", "Test2", "Test3", "Test1"};
        for (String value : array) {
            ss.add(value);
        }
        Iterator iterator = ss.iterator();
        iterator.next();
        iterator.next();
        boolean result = iterator.hasNext();
        assertThat(result, is(true));
        iterator.next();
        result = iterator.hasNext();
        assertThat(result, is(false));
    }
}