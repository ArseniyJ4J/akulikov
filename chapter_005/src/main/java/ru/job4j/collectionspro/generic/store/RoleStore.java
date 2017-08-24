package ru.job4j.collectionspro.generic.store;

/** Класс UserStore.
 * @author Arseniy Kulkiov
 * @since 21.08.2017
 * @version 1
 * @param <T> - параметризованный тип.
 */

public class RoleStore<T extends Role> extends BaseStore<T> {
    /**
     * Конструктор.
     * @param size - размер хранилища.
     */
    public RoleStore(int size) {
        super(size);
    }
}
