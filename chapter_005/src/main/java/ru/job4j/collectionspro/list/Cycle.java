package ru.job4j.collectionspro.list;

/** Класс Cycle.
 * @author Arseniy Kulkiov
 * @since 30.08.2017
 * @version 1
 */

public class Cycle {

    /**
     * Метод проверки цикличности элементов связанного списка.
     * @param first - первый элемент списка.
     * @return - возврат значения.
     */

    public boolean hasCycle(Node first) {
        boolean result = false;
        Node check = first.getNext();
        while (check != null) {
            if (check == first) {
                result = true;
                break;
            }
            check = check.getNext();
        }
            return result;
    }

    /**
     * Внутренний класс Node.
     * @param <T> - параметризированный тип.
     */
    static class Node<T> {

        /**
         * Поле класса.
         */
        private T value;

        /**
         * Поле класса.
         */
        private Node<T> next;

        /**
         * Конструктор.
         * @param value - значение.
         */
        Node(T value) {
            this.value = value;
        }

        /**
         * Геттер для поля next.
         * @return - возврат значения.
         */
        public Node<T> getNext() {
            return next;
        }

        /**
         * Сеттер для поля next.
         * @param next - новое значения поля.
         */
        public void setNext(Node<T> next) {
            this.next = next;
        }
    }
}
