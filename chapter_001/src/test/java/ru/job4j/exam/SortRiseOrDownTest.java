package ru.job4j.exam;

import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;
/**
 * Test for SubString.
 * @author Arseniy Kulikov (mailto:arsmail424@gmail.com)
 * @version 1.0
 * @since 1.0
 */
public class SortRiseOrDownTest {
    /**
     * Test.
     */
    @Test
    public void sortArrayNineElements() {
        SortRiseOrDown sortRiseOrDown = new SortRiseOrDown();
        int[] array = {1, 2, 3, 4, 5, 6, 7};
        boolean result = sortRiseOrDown.sort(array);
        boolean expect = true;
        assertThat(result, is(expect));
    }
    /**
     * Test.
     */
    @Test
    public void sortArrayNineElements2() {
        SortRiseOrDown sortRiseOrDown = new SortRiseOrDown();
        int[] array = {7, 6, 5, 4, 3, 2, 1};
        boolean result = sortRiseOrDown.sort(array);
        boolean expect = true;
        assertThat(result, is(expect));
    }
    /**
     * Test.
     */
    @Test
    public void sortArrayNineElements3() {
        SortRiseOrDown sortRiseOrDown = new SortRiseOrDown();
        int[] array = {1, 2, 3, 4, 5, 7, 6};
        boolean result = sortRiseOrDown.sort(array);
        boolean expect = false;
        assertThat(result, is(expect));
    }
}
