package ru.job4j.collectionspro.generic;

/** Class SimpleArray.
 * @author Arseniy Kulkiov
 * @since 21.08.2017
 * @version 1
 * @param <E> - generic.
 */

public class SimpleArray<E> {
    /**
     * Поле класса.
     */
    private Object[] objects;
    /**
     * Поле класса.
     */
    private int index = 0;
    /**
     * Конструктор.
     * @param size - размер массива.
     */
    public SimpleArray(int size) {
        this.objects = new Object[size];
    }
    /**
     * Метод добавления элемента.
     * @param value - добавляемый элемент.
     */
    public void add(E value) {
        this.objects[index++] = value;
    }
    /**
     * Элемент обновления.
     * @param value - обновление элемента.
     * @param position - индекс элемента который обновится.
     */
    public void update(E value, int position) {
        if (position < objects.length) {
            this.objects[position] = value;
        }
    }
    /**
     * Метод удаления.
     * @param value - значение для удаления.
     */
    public void delete(E value) {
        for (int i = 0; i < objects.length; i++) {
            if (this.objects[i].equals(value)) {
                this.objects[i] = null;
                break;
            }
        }
    }
    /**
     * Метод получения.
     * @param position - индекс позиции получаемого объекта.
     * @return - возврат значения.
     */
    public E get(int position) {
        E result = null;
        if (position < objects.length) {
            result = (E) objects[position];
        }
        return result;
    }

}
