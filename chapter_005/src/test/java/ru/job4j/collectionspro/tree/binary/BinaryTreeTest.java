package ru.job4j.collectionspro.tree.binary;

import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
 * BinaryTreeTest Class.
 * @author Arseniy Kulikov.
 * @since 02.10.2017
 * @version 1.
 */
public class BinaryTreeTest {

    /**
     * Test.
     */
    @Test
    public void addTest() {
        BinaryTree<Integer> binaryTree = new BinaryTree<>();
        assertThat(binaryTree.add(15), is(true));
        assertThat(binaryTree.add(7), is(true));
        assertThat(binaryTree.add(18), is(true));
        assertThat(binaryTree.add(3), is(true));
        assertThat(binaryTree.add(10), is(true));
        assertThat(binaryTree.add(16), is(true));
        assertThat(binaryTree.add(22), is(true));
    }
}