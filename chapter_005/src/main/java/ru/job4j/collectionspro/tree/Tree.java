package ru.job4j.collectionspro.tree;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * Tree Class.
 * @author Arseniy Kulikov
 * @since 28.09.2017
 * @version 1
 * @param <E> - параметризованный тип.
 */
public class Tree<E extends Comparable<E>> implements SimpleTree<E> {

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
     * Внутренний класс Node.
     * @param <E> - параметризированный тип.
     */
    protected class Node<E> {

        /**
         * Поле класса children.
         */
        private List<Node<E>> children;

        /**
         * Поле класса value.
         */
        private E value;

        /**
         * Конструктор.
         * @param value - значение.
         */
        public Node(E value) {
            this.value = value;
            this.children = new ArrayList<>();
        }

        /**
         * Геттер для getChildren.
         * @return - возврат значения.
         */
        public List<Node<E>> getChildren() {
            return children;
        }

        /**
         * Геттер для getValue.
         * @return - возврат значения.
         */
        public E getValue() {
            return value;
        }
    }

    /**
     * Метод добавления элемента.
     * @param parent parent.
     * @param child child.
     * @return - возврат значения.
     */
    @Override
    public boolean add(E parent, E child) {
        boolean result = false;
        Node<E> newParent = new Node<>(parent);
        Node<E> newChild = new Node<>(child);
        if (this.basis == null) {
            if (parent.compareTo(child) == 0) {
//                System.out.println("Parent compare Child!!!!!!");
                result = false;
            } else {
                this.basis = newParent;
                this.basis.getChildren().add(newChild);
//                System.out.println("Root-parent added!");
//                System.out.println("Check child: " + this.searchDuplicate(newChild));
                result = true;
                size += 2;
            }
        } else {
            Node<E> point = this.searchParent(newParent, this.basis);
            int check = -1;
            if (point != null) {
                for (Node node : point.getChildren()) {
                    check = newChild.getValue().compareTo((E) node.getValue());
                    if (check == 0) {
//                        System.out.println("Already have!!!");
//                        System.out.println("Check child: " + this.searchDuplicate(newChild));
                        break;
                    }
                }
                if (check != 0 && !this.searchDuplicate(newChild)) {
                    point.getChildren().add(newChild);
//                    System.out.println("Less-parent added!!!");
//                    System.out.println("Check child: " + this.searchDuplicate(newChild));
                    result = true;
                    size++;
                }
            }
        }
        return result;
    }

    /**
     * Метод определяющий, является ли дерево бинарным.
     * @return - возврат значения.
     */
    @Override
    public boolean isBinary() {
        return this.checkBinary(this.basis);
    }

    /**
     * Метод определения бинарности с параметром. Что бы можно было реализовать рекурсию.
     * @param node - корень от которого идет анализ.
     * @return - возврат значения.
     */
    private boolean checkBinary(Node<E> node) {
        boolean result = true;
        if (node.getChildren().size() > 2) {
            result = false;
        }
        if (result) {
            for (Node<E> value : node.getChildren()) {
                result = this.checkBinary(value);
                if (!result) {
                    break;
                }
            }
        }
        return result;
    }

    /**
     * Метод определения дубликата.
     * @param value - проверяемое значение.
     * @return - возврат значения. Возвращает true, если элемент Node с таким значением уже есть в дереве.
     */
    private boolean searchDuplicate(Node value) {
//        System.out.println("Duplicate search result: ===============");
        Node<E> result = this.searchParent(value, this.basis);
//        System.out.println("====================");
        return result != null;
    }

    /**
     * Метод нахождения родительского элемента в дереве.
     * @param parent - искомый родительский элемент.
     * @param first - основание от которого ведется поиск.
     * @return - возврат значения.
     */
    private Node<E> searchParent(Node<E> parent, Node<E> first) {
        Node<E> result = null;
        int check = first.getValue().compareTo(parent.getValue());
//        System.out.println(check);
        if (check == 0) {
            result = first;
        } else {
            for (Node item  : first.getChildren()) {
                result = this.searchParent(parent, item);
                if (result != null) {
                    break;
                }
            }
        }
        return result;
    }

    /**
     * Returns an iterator over elements of type {@code T}.
     * @return an Iterator.
     */
    @Override
    public Iterator<E> iterator() {
        return new Iterator<E>() {


            private List<E> result = new ArrayList<>();
            private int it = 0;
            private boolean check = true;


            private void getAllElements(Node<E> node) {
                if (this.check) {
                    result.add(basis.getValue());
                    this.check = false;
                }
                if (this.result.size() <= size) {
                    for (Node value : node.getChildren()) {
                        if (value.getChildren().size() > 0) {
                            getAllElements(value);
                        }
                        if (!result.contains(value.getValue())) {
                            result.add((E) value.getValue());
                        }
                    }
                }
            }

            @Override
            public boolean hasNext() {
                return it < size;
            }

            @Override
            public E next() {
                getAllElements(basis);
                return result.get(it++);
            }
        };
    }
}
