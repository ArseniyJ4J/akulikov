package ru.job4j.collectionspro.list;

import org.junit.Test;
import java.util.Iterator;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/** Класс SimpleLinkedListTest.
 * @author Arseniy Kulkiov
 * @since 28.08.2017
 * @version 1
 */
public class SimpleLinkedListTest {

    /**
     * Test.
     */
    @Test
    public void addAndGetTest() {
        SimpleLinkedList<String> sll = new SimpleLinkedList<>();
        sll.add("monitore");
        String result = sll.get(0);
        assertThat(result, is("monitore"));
    }

    /**
     * Test.
     */
    @Test
    public void iteratorTest() {
        SimpleLinkedList<String> sll = new SimpleLinkedList<>();
        Iterator<String> iterator = sll.iterator();
        sll.add("test1");
        sll.add("test2");
        assertThat(iterator.hasNext(), is(true));
        sll.iterator().next();
        sll.iterator().next();
        assertThat(iterator.hasNext(), is(false));
    }
}