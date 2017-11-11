package ru.job4j.multithreading.cointask;

import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertThat;

/** Class SlotMachineTest.
 * @author Arseniy Kulkiov
 * @since 11.11.2017
 * @version 1
 */
public class SlotMachineTest {

    /**
     * Test.
     */
    @Test
    public void test() {
        SlotMachine sm = new SlotMachine();
        int[] result = sm.changes(30, 20);
        assertNull(result);
    }

    /**
     * Test.
     */
    @Test
    public void test2() {
        SlotMachine sm = new SlotMachine();
        int[] result = sm.changes(50, 50);
        assertNull(result);
    }

    /**
     * Test.
     */
    @Test
    public void test3() {
        SlotMachine sm = new SlotMachine();
        int[] expect = {2000, 2000, 500, 200, 200, 50, 10, 10, 10, 10, 5, 2, 2};
        int[] result = sm.changes(1, 5000);
        assertThat(result, is(expect));
    }

    /**
     * Test.
     */
    @Test
    public void test4() {
        SlotMachine sm = new SlotMachine();
        int[] expect = {5000, 5000, 5000, 5000, 5000, 5000, 5000, 2000, 2000, 500, 200, 200, 50, 10, 10, 10, 10, 5, 2, 2};
        int[] result = sm.changes(1, 40000);
        assertThat(result, is(expect));
    }
}