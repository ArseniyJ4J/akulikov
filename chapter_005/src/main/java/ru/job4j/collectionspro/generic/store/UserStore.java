package ru.job4j.collectionspro.generic.store;

/** Класс UserStore.
 * @author Arseniy Kulkiov
 * @since 21.08.2017
 * @version 1
 * @param <T> - параметризованный тип.
 */

public class UserStore<T extends User> extends BaseStore<T> {
    /**
     * Конструктор.
     * @param size - размер хранилища.
     */
    public UserStore(int size) {
        super(size);
    }
}
