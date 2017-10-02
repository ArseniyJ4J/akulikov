package ru.job4j.collectionspro.tree.binary;

/**
 * SimpleBinaryTree Interface.
 * @author Arseniy Kulikov
 * @since 01.10.2017
 * @version 1
 * @param <E> - параметризованный тип.
 */

public interface SimpleBinaryTree<E extends Comparable<E>> extends Iterable<E> {
    /**
     * Метод добавления элемента.
     * @param value - добавляемое значение.
     * @return - возврат значения.
     */
    boolean add(E value);
}
