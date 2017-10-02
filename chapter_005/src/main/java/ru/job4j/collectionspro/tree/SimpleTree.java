package ru.job4j.collectionspro.tree;

/**
 * SimpleTree Interface.
 * @author Arseniy Kulikov
 * @since 28.09.2017
 * @version 1
 * @param <E> - параметризованный тип.
 */

public interface SimpleTree<E extends Comparable<E>> extends Iterable<E> {

    /**
     * Метод добавления элемента.
     * @param parent parent.
     * @param child child.
     * @return - возврат значения.
     */
    boolean add(E parent, E child);

    /**
     * Метод определяющий, является ли дерево бинарным.
     * @return - возврат значения.
     */
    boolean isBinary();
}
