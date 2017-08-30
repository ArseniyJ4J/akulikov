package ru.job4j.collectionspro.list;

import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/** Класс CycleTest.
 * @author Arseniy Kulkiov
 * @since 30.08.2017
 * @version 1
 */

public class CycleTest {

    /**
     * Test.
     */
    @Test
    public void hasCycleTrueTest() {
        Cycle.Node<Integer> first = new Cycle.Node<>(1);
        Cycle.Node<Integer> second = new Cycle.Node<>(2);
        Cycle.Node<Integer> third = new Cycle.Node<>(3);
        Cycle.Node<Integer> fourth = new Cycle.Node<>(4);
        first.setNext(second);
        second.setNext(third);
        third.setNext(fourth);
        fourth.setNext(first);
        Cycle cycle = new Cycle();
        assertThat(cycle.hasCycle(first), is(true));
    }

    /**
     * Test.
     */
    @Test
    public void hasCycleFalseTest() {
        Cycle.Node<Integer> first = new Cycle.Node<>(1);
        Cycle.Node<Integer> second = new Cycle.Node<>(2);
        Cycle.Node<Integer> third = new Cycle.Node<>(3);
        Cycle.Node<Integer> fourth = new Cycle.Node<>(4);
        first.setNext(second);
        second.setNext(third);
        third.setNext(fourth);
        Cycle cycle = new Cycle();
        assertThat(cycle.hasCycle(first), is(false));
    }
}