package ru.job4j.collectionspro.list;

import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/** Класс SimpleQueueTest.
 * @author Arseniy Kulkiov
 * @since 29.08.2017
 * @version 1
 */

public class SimpleQueueTest {

    /**
     * Test.
     */
    @Test
    public void pushAndPollTest() {
        SimpleQueue<String> ss = new SimpleQueue<>();
        ss.push("test");
        ss.push("test2");
        String result = ss.poll();
        assertThat(result, is("test"));
        ss.poll();
        int resultSize = ss.size();
        assertThat(resultSize, is(0));
    }
}