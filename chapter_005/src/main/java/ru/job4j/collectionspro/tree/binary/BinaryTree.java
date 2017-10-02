package ru.job4j.collectionspro.tree.binary;

import java.util.Iterator;

/**
 * BinaryTree Class.
 * @author Arseniy Kulikov.
 * @since 02.10.2017
 * @version 1.
 * @param <E> - параметризированный тип.
 */
public class BinaryTree<E extends Comparable<E>> implements SimpleBinaryTree<E> {
    /**
     * Поле класса basis.
     * Корень дерева.
     */
    private Node<E> basis;

    /**
     * Поле класса size - количество элементов в дереве.
     */
    private int size = 0;

    /**
     * Геттер поля size.
     * @return - возврат значения.
     */
    public int getSize() {
        return size;
    }

    /**
     * Внутренний класс Node.
     * @param <E> - параметризированный тип.
     */
    protected class Node<E> {

        /**
         * Поле класса value.
         */
        private E value;

        /**
         * Поле класса left.
         */
        private Node<E> left;

        /**
         * Поле класса right.
         */
        private Node<E> right;

        /**
         * Геттер для getValue.
         * @return - возврат значения.
         */
        public E getValue() {
            return value;
        }

        /**
         * Сеттер для поля класса value.
         * @param value - передаваемое значение.
         */
        public void setValue(E value) {
            this.value = value;
        }

        /**
         * Геттер для поля класса left.
         * @return - возврат значения.
         */
        public Node<E> getLeft() {
            return left;
        }

        /**
         * Сеттер для поля класса left.
         * @param left - передаваемое значение.
         */
        public void setLeft(Node<E> left) {
            this.left = left;
        }

        /**
         * Геттер для поля класса right.
         * @return - возврат значения.
         */
        public Node<E> getRight() {
            return right;
        }

        /**
         * Сеттер для поля класса right.
         * @param right - передаваемое значение.
         */
        public void setRight(Node<E> right) {
            this.right = right;
        }

        /**
         * Конструктор.
         * @param value - значение.
         */
        public Node(E value) {
            this.value = value;
        }
    }

    /**
     * Метод добавления элемента.
     * @param value - добавляемое значение.
     * @return - возврат значения.
     */
    @Override
    public boolean add(E value) {
        boolean result = false;
        Node<E> newValue = new Node<>(value);
        if (this.basis == null) {
            this.basis = newValue;
            size++;
            result = true;
        } else {
            Node<E> node = this.searchAddPoint(this.basis, newValue);
            int check = newValue.getValue().compareTo(node.getValue());
            if (check <= 0) {
                node.setLeft(newValue);
            } else if (check > 0) {
                node.setRight(newValue);
            }
            size++;
            result = true;
        }
        return result;
    }

    /**
     * Метод поиска узла, в одном из полей которого должно быть помещено добавляемое значение.
     * @param start - корень дерева, от которого начинается поиск.
     * @param target - добавляемый элемент.
     * @return - возврат значения.
     */
    private Node<E> searchAddPoint(Node<E> start, Node<E> target) {
        Node<E> result = null;
        int check = target.getValue().compareTo(start.getValue());
        if (check <= 0) {
            if (start.getLeft() == null) {
                result = start;
            } else {
                result = this.searchAddPoint(start.getLeft(), target);
            }
        } else if (check > 0) {
            if (start.getRight() == null) {
                result = start;
            } else {
                result = this.searchAddPoint(start.getRight(), target);
            }
        }
        return result;
    }

    /**
     * Returns an iterator over elements of type {@code T}.
     *
     * @return an Iterator.
     */
    @Override
    public Iterator<E> iterator() {
        return null;
    }
}
