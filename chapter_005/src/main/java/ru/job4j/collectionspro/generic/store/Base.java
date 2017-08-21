package ru.job4j.collectionspro.generic.store;

/** Абстрактный класс Base.
 * @author Arseniy Kulkiov
 * @since 21.08.2017
 * @version 1
 */

public abstract class Base {
    /**
     * Поле класса id.
     */
    private String id;
    /**
     * Геттер id.
     * @return - возврат значения.
     */
    public String getId() {
        return this.id;
    }
    /**
     * Сеттер id.
     * @param id - новый id.
     */
    public void setId(String id) {
        this.id = id;
    }
}
