package ru.job4j.multithreading.monitore;

import net.jcip.annotations.ThreadSafe;

import java.util.Iterator;
import java.util.NoSuchElementException;

/** Класс ThreadLinkedList.
 * @author Arseniy Kulkiov
 * @since 30.10.2017
 * @version 1
 * @param <E> - параметризованный тип.
 */

@ThreadSafe
public class ThreadLinkedList<E> implements Iterable {

    /**
     * Поле класса size - текущее количество элементов в контейнере.
     */
    private int size = 0;

    /**
     * Поле класса first - первый элемент контейнера.
     */
    private Node<E> first;

    /**
     * Поле класса last - последний элемент контейнера.
     */
    private Node<E> last;

    /**
     * Поле класса counter - счетчик положения каретки итератора.
     */
    private int counter = 0;

    /**
     * Конструктор.
     */
    public ThreadLinkedList() {
        last = new Node<E>(null, null);
        first = new Node<E>(null,  this.last);
    }

    /**
     * Геттер для поля size.
     * @return - возврат значения.
     */
    public synchronized int getSize() {
        return size;
    }

    /**
     * Метод добавления элемента в контейнер.
     * @param value - добавляемое значение.
     */
    public synchronized void add(E value) {
        Node<E> prev = last;
        prev.setItem(value);
        last = new Node<>(null, null);
        prev.setNext(last);
        size++;
    }

    /**
     * Метод возвращающий значние по индексу.
     * @param index - индекс.
     * @return - возврат значения.
     */
    public synchronized E get(int index) {
        if (index < size) {
            Node<E> target = this.first.getNext();
            for (int i = 0; i < index; i++) {
                target = target.getNext();
            }
            return target.getItem();
        } else {
            throw new NoSuchElementException();
        }
    }

    /**
     * Метод удаляющий и возвращающий элемент из контейнера.
     * @param index - индекс элемента.
     * @return - возврат значения.
     */
    public synchronized E delete(int index) {
        if (index < size) {
            E result = this.get(index);

            Node<E> target = this.first.getNext();
            for (int i = 0; i <= index; i++) {
                if (index == 0) {
                    Node<E> prev = target.getNext();
                    this.first.setNext(prev);
                    target.setNext(null);
                    size--;
                    break;
                }
                if (i >= index - 1) {
                    Node<E> prev = target.getNext().getNext();
                    target.getNext().setNext(null);
                    target.setNext(prev);
                    this.size--;
                    break;
                }  else {
                    target = target.getNext();
                }
            }
            return result;
        } else {
            throw new NoSuchElementException();
        }
    }

    /**
     * Внутренний класс Node.
     * @param <E> - параметризированный тип.
     */
    private class Node<E> {

        /**
         * Поле класса item. Значение элемента контейнера.
         */
        private E item;

        /**
         * Ссылка на следующий связанный элемент.
         */
        private Node<E> next;

        /**
         * Конструктор.
         * @param item - item.
         * @param next - next.
         */
        Node(E item, Node<E> next) {
            this.item = item;
            this.next = next;
        }

        /**
         * Геттер для поля класса Item.
         * @return - возврат значения.
         */
        public synchronized E getItem() {
            return item;
        }

        /**
         * Сеттер для поля item.
         * @param item - параметр.
         */
        public synchronized void setItem(E item) {
            this.item = item;
        }

        /**
         * Геттер для поля Next.
         * @return - возврат значения.
         */
        public synchronized Node<E> getNext() {
            return next;
        }

        /**
         * Сеттер для поля next.
         * @param next - параметр.
         */
        public synchronized void setNext(Node<E> next) {
            this.next = next;
        }
    }

    /**
     * Returns an iterator over elements of type {@code T}.
     *
     * @return an Iterator.
     */
    @Override
    public synchronized Iterator iterator() {
        return new LinkedListIterator<E>();
    }

    /**
     * Внутренний класс LinkedListIterator.
     * @param <E> - параметризированный тип.
     */
    public class LinkedListIterator<E> implements Iterator {

        /**
         * Returns {@code true} if the iteration has more elements.
         * (In other words, returns {@code true} if {@link #next} would
         * return an element rather than throwing an exception.)
         *
         * @return {@code true} if the iteration has more elements
         */
        @Override
        public synchronized boolean hasNext() {
            return counter < size;
        }

        /**
         * Returns the next element in the iteration.
         *
         * @return the next element in the iteration
         * @throws NoSuchElementException if the iteration has no more elements
         */
        @Override
        public synchronized Object next() throws NoSuchElementException {
            if (hasNext()) {
                return get(counter++);
            } else {
                throw new NoSuchElementException();
            }
        }
    }
}
