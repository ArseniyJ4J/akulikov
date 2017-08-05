package ru.job4j.collections;

import org.junit.Test;

import java.util.LinkedList;
import java.util.List;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/** Class Класс ConvertListTest.
 * @author Arseniy Kulkiov
 * @since 06.08.2017
 * @version 1
 */
public class ConvertListTest {

    /**
     * Test.
     */
    @Test
    public void testForConvert() {
        ConvertList cl = new ConvertList();
        List<int[]> list = new LinkedList<int[]>();
        int[] a = {1, 2, 3, 5, };
        int[] b = {11, 13, 14};
        int[] c = {1, 2};
        list.add(a);
        list.add(b);
        list.add(c);
        List<Integer> result = cl.convert(list);
        List<Integer> expect = new LinkedList<>();
        int[] array = new int[]{1, 2, 3, 5, 11, 13, 14, 1, 2};
        for (int value : array) {
            expect.add(value);
        }
        assertThat(result, is(expect));
    }
}

