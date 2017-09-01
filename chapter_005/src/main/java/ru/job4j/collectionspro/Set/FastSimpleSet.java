package ru.job4j.collectionspro.Set;

/** Класс FastSimpleSet.
 * @author Arseniy Kulkiov
 * @since 01.09.2017
 * @version 1
 * @param <E> - параметризованный тип.
 */

public class FastSimpleSet<E> {

    private Object[] container = new Object[10];

    private int count = 0;

    private int middle = count / 2;

    public Object[] getContainer() {
        return container;
    }

    public void add(E value) {
        this.changeSize();
        if (count == 0) {
            this.container[count++] = value;
        } else if (value.hashCode() == container[middle].hashCode()) {
            System.out.println("Такой элемент уже есть!");
        } else {
            this.check(value.hashCode() > container[middle].hashCode(), value);
        }
    }

    public void check(boolean result, E value) {
        if (result) {
            for (int i = middle + 1; i <= count; i++) {
                if (this.container[i] == null || value.hashCode() < this.container[i].hashCode()) {
                    this.container[i] = value;
                    this.count++;
                    break;
                } else if (value.hashCode() == this.container[i].hashCode()) {
                    System.out.println("Такой элемент уже есть!");
                    break;
                }
            }
        } else {
            for (int i = middle; i >= 0; i--) {
                if (value.hashCode() == this.container[i].hashCode()) {
                    System.out.println("Такой элемент уже есть!");
                    break;
                } else if (value.hashCode() > this.container[i].hashCode() || i == 0) {
                    System.arraycopy(this.container, i, this.container, i + 1, this.count);
                    this.container[i] = value;
                    this.count++;
                    break;
                }
            }
        }
    }

    public void changeSize() {
        if (this.count == this.container.length) {
            int newSize = container.length * 2;
            Object[] newContainer = new Object[newSize];
            System.arraycopy(this.container, 0, newContainer, 0, container.length);
            this.container = newContainer;
        }
    }

}
