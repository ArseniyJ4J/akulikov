package ru.job4j.collectionspro.generic;

import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertThat;
/**
 * Created by Ирина on 20.08.2017.
 */
public class SimpleArrayTest {
    /**
     * Test.
     */
    @Test
    public void add() {
        SimpleArray<String> sa = new SimpleArray(3);
        sa.add("test");
        String result = sa.get(0);
        assertThat(result, is("test"));
    }
    /**
     * Test.
     */
    @Test
    public void update() {
        SimpleArray<String> sa = new SimpleArray(3);
        sa.add("test");
        sa.update("update", 0);
        String result = sa.get(0);
        assertThat(result, is("update"));
    }
    /**
     * Test.
     */
    @Test
    public void delete() {
        SimpleArray<String> sa = new SimpleArray(3);
        sa.add("test");
        sa.delete("test");
        assertNull(sa.get(0));
        //boolean result = (sa.get(0)).equals(null);
        //assertThat(result, is(true));

    }
    /**
     * Test.
     */
    @Test
    public void get() {
        SimpleArray<String> sa = new SimpleArray(3);
        sa.add("test");
        String result = sa.get(0);
        assertThat(result, is("test"));
    }

}