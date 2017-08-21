package ru.job4j.collectionspro.generic.store;

/** Интерфейс Store.
 * @author Arseniy Kulkiov
 * @since 21.08.2017
 * @version 1
 * @param <T> - параметризованный тип.
 */

public interface Store<T extends Base> {
    /**
     * Метод добавления.
     * @param value - добавляемый объект.
     */
    void add(T value);
    /**
     * Метод обновления.
     * @param value - обновляемый объект.
     */
    void update(T value);
    /**
     * Метод удаления.
     * @param value - удаляемый объект.
     */
    void remove(T value);
}
