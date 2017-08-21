package ru.job4j.collectionspro.generic.store;

/** Класс User.
 * @author Arseniy Kulkiov
 * @since 21.08.2017
 * @version 1
 */

public class User extends Base {
    /**
     * Конструктор.
     * @param id - идентификатор.
     */
    public User(String id) {
        super.setId(id);
    }
}
