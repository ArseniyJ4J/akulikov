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
public class MixTest {
    /**
     * Test.
     */
    @Test
    public void mixTwoRiseArray() {
        Mix mix = new Mix();
        int[] a = {3, 6};
        int[] b = {1, 2, 3, 9, 11, 13};
        int[] resultArray = mix.mix(a, b);
        int[] expectArray = {1, 2, 3, 3, 6, 9, 11, 13};
        assertThat(resultArray, is(expectArray));
    }
    /**
     * Test.
     */
    @Test
    public void mixTwoRiseArray2() {
        Mix mix = new Mix();
        int[] a = {1, 2, 3, 9, 11, 13};
        int[] b = {3, 6};
        int[] resultArray = mix.mix(a, b);
        int[] expectArray = {1, 2, 3, 3, 6, 9, 11, 13};
        assertThat(resultArray, is(expectArray));
    }
}
