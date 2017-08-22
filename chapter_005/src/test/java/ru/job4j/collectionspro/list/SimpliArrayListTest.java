package ru.job4j.collectionspro.list;

import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
 * SimpleArrayTest Class.
 * @author Arseniy Kulkiov
 * @since 22.08.2017
 * @version 1
 */

public class SimpliArrayListTest {
    /**
     * Test.
     */
    @Test
    public void addAndGetTest() {
        String s1 = "string1";
        String s2 = "string2";
        SimpliArrayList<String> sal = new SimpliArrayList<>();
        sal.add(s1);
        sal.add(s2);
        assertThat(sal.get(0), is("string1"));
    }
}