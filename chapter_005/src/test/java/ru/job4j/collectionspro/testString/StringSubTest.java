package ru.job4j.collectionspro.testString;

import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
 * StringSubTest Class.
 * @author Arseniy Kulikov.
 * @since 15.10.2017.
 * @version 1.
 */
public class StringSubTest {

    /**
     * Test.
     */
    @Test
    public void test() {
        StringSub ss = new StringSub();
        assertThat(ss.compareString("ask", "kas"), is(true));
        assertThat(ss.compareString("ask", "sak"), is(true));
        assertThat(ss.compareString("kAs", "Aks"), is(true));
        assertThat(ss.compareString("kaa", "saa"), is(false));
        assertThat(ss.compareString("ask", "Ask"), is(false));

    }
}