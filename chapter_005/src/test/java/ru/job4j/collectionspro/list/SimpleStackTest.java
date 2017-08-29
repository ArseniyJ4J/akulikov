package ru.job4j.collectionspro.list;

import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/** Класс SimpleStackTest.
 * @author Arseniy Kulkiov
 * @since 29.08.2017
 * @version 1
 */

public class SimpleStackTest {

    /**
     * Test.
     */
    @Test
    public void push() {
        SimpleStack<String> ss = new SimpleStack<>();
        ss.push("test");
        ss.push("test2");
        String result = ss.poll();
        assertThat(result, is("test2"));
        ss.poll();
        int resultSize = ss.size();
        assertThat(resultSize, is(0));

    }
}