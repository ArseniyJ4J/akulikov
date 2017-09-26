package ru.job4j.collectionspro.map;

import java.util.Iterator;

/** Класс Cataloge.
 * @author Arseniy Kulkiov
 * @since 26.09.2017
 * @version 1
 * @param <T> - параметризованный тип.
 * @param <V> - параметризованный тип.
 */
public class Cataloge<T, V> implements Iterable<V> {
    /**
     * Поле класса nodes. Массив-хранилище для пар ключ-значение.
     */
    private Node<T, V>[] nodes;
    /**
     * Поле класса size. Счетчик количества находящихся в хранилище nodes значений.
     */
    private int size = 0;
    /**
     * Коэффициент знагрузки. Опеределяет степерь заполненности хранилища до увеличения его ёмкости.
     */
    private final double loadFactor = 0.75;

    /**
     * Конструктор.
     */
    public Cataloge() {
        this.nodes = new Node[16];
    }
    /**
     * Геттер для nodes.
     * @return - возврат значения.
     */
    public Node[] getNodes() {
        return this.nodes;
    }
    /**
     * Метод добавления значения в хранилище с увеличением size.
     * @param key - ключ.
     * @param value - значение.
     * @return - возврат значения.
     */
    public boolean insert(T key, V value) {
        this.checkSize();
        boolean result = false;
        Node<T, V> node = new Node<>(key, value);
        result = this.add(node, this.nodes);
        if (result) {
            size++;
        }
        return result;
    }
    /**
     * Метод добавления без увеличения size.
     * @param node - добавляемый узел.
     * @param nodes - хранилище.
     * @return - возврат значения.
     */
    private boolean add(Node node, Node<T, V>[] nodes) {
        boolean result = false;
        int index = this.hash((T) node.getKey(), nodes);
        if (nodes[index] == null) {
            nodes[index] = node;
            result = true;
        }
        return result;
    }
    /**
     * Метод получения значения по ключу.
     * @param key - ключ.
     * @return - возврат значения.
     */
    public V get(T key) {
        int index = this.hash(key, this.nodes);
        V result = this.nodes[index].getValue();
        return result;
    }
    /**
     * Метод удаления узла по ключу.
     * @param key - ключ.
     * @return - возврат значения.
     */
    public boolean delete(T key) {
        boolean result = false;
        int index = this.hash(key, this.nodes);
        if (this.nodes[index] != null) {
            this.nodes[index] = null;
            size--;
            result = true;
        }
        return result;
    }
    /**
     * Метод проверяющий необходимость и выполняющий увеличение размера хранилища в два раза.
     */
    private void checkSize() {
        if (size + 1 >= this.nodes.length * this.loadFactor) {
            Node<T, V>[] newNodes = new Node[this.nodes.length * 2];
            for (Node value : this.nodes) {
                if (value != null) {
                    boolean result = add(value, newNodes);
                    if (!result) {
                        size--;
                    }
                }
            }
            this.nodes = newNodes;
        }
    }
    /**
     * Метод генерации индекса на основе хэш кода ключа.
     * @param key - ключ.
     * @param nodes - хранилище.
     * @return - возврат значения.
     */
    private int hash(T key, Node<T, V>[] nodes) {
        int code = key.hashCode();
        int result = code % nodes.length;
        return result;
    }
    /**
     * Внутренний класс Node - узел (пара ключ - значение в одном объекте).
     * @param <T> - параметризованный тип ключа.
     * @param <V> - параметризованный тип значения.
     */
    private class Node<T, V> {
        /**
         * Поле класса key.
         */
        private T key;
        /**
         * Поле класса value.
         */
        private V value;
        /**
         * Контруктор.
         * @param key - ключ.
         * @param value - значение.
         */
        Node(T key, V value) {
            this.key = key;
            this.value = value;
        }
        /**
         * Геттер для key.
         * @return - возврат значения.
         */
        T getKey() {
            return this.key;
        }

        /**
         * Геттер для value.
         * @return - возврат значения.
         */
        public V getValue() {
            return this.value;
        }
    }
    /**
     * Returns an iterator over elements of type {@code T}.
     *
     * @return an Iterator.
     */
    @Override
    public Iterator<V> iterator() {
        return new Iterator<V>() {
            private int bob = 0;

            @Override
            public boolean hasNext() {
                return (bob < size);
            }

            @Override
            public V next() {
                V result = null;
                for  (int check = bob; check <= size; check++) {
                    if (nodes[check] != null) {
                        result = nodes[check].getValue();
                        bob++;
                        break;
                    } else {
                        bob++;
                    }
                }
                return result;
            }
        };
    }
}
