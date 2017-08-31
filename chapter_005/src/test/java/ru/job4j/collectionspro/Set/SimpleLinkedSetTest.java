package ru.job4j.collectionspro.Set;

import org.junit.Test;

import java.util.Iterator;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
 * SimpleLinkedSetTest Class.
 * @author Arseniy Kulkiov
 * @since 31.08.2017
 * @version 1
 */

public class SimpleLinkedSetTest {

    /**
     * Test.
     */
    @Test
    public void addTest() {
        SimpleLinkedSet<String> ssl = new SimpleLinkedSet<>();
        String[] array = {"Test1", "Test2", "Test3", "Test1"};
        String[] result = {"Test1", "Test2", "Test3"};
        for (String value : array) {
            ssl.add(value);
        }
        String[] expect = new String[3];
        Iterator it = ssl.iterator();
        for (int i = 0; i < ssl.getContainer().getSize(); i++) {
            expect[i] = (String) it.next();
        }
        assertThat(expect, is(result));
    }

    /**
     * Test.
     */
    @Test
    public void iterator() {
        SimpleLinkedSet<String> ssl = new SimpleLinkedSet<>();
        ssl.add("001");
        ssl.add("002");
        ssl.add("003");
        Iterator<String> iterator = ssl.iterator();
        assertThat(iterator.hasNext(), is(true));
        iterator.next();
        iterator.next();
        assertThat(iterator.next(), is("003"));
        assertThat(iterator.hasNext(), is(false));
    }
}