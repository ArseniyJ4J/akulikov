package ru.job4j.collectionspro.tree;

import org.junit.Test;

import java.util.Iterator;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
 * TreeTest Class.
 * @author Arseniy Kulikov
 * @since 28.09.2017
 * @version 1
 */

public class TreeTest {

    /**
     * Test.
     */
    @Test
    public void addTest() {
        Tree<Integer> tree = new Tree();
        assertThat(tree.add(1, 1), is(false));
        assertThat(tree.add(1, 2), is(true));
        assertThat(tree.add(1, 3), is(true));
        assertThat(tree.add(2, 1), is(false));
        assertThat(tree.add(2, 2), is(false));
        assertThat(tree.add(2, 4), is(true));
        assertThat(tree.add(4, 6), is(true));
        assertThat(tree.add(6, 7), is(true));
    }

    /**
     * Test.
     */
    @Test
    public void iteratorTest() {
        Tree<Integer> tree = new Tree();
        tree.add(1, 2);
        tree.add(2, 3);
        tree.add(1, 4);
        Iterator it = tree.iterator();
        assertThat(it.hasNext(), is(true));
        assertThat(!it.next().equals(0), is(true));
        it.next();
        it.next();
        assertThat(it.hasNext(), is(true));
        it.next();
        assertThat(it.hasNext(), is(false));
    }
}