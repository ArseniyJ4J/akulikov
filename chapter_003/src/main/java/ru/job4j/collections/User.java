package ru.job4j.collections;

/** Class Класс User.
 * @author Arseniy Kulkiov
 * @since 06.08.2017
 * @version 1
 */

public class User {
    /**
     * Конструктор User.
     * @param id - id номер.
     * @param name - имя.
     * @param city - город.
     */
    public User(int id, String name, String city) {
        this.id = id;
        this.name = name;
        this.city = city;
    }
    /**
     * Поле класса id.
     */
    private int id;
    /**
     * Поле класса name.
     */
    private String name;
    /**
     * Поле класса city.
     */
    private String city;
    /**
     * Геттер id.
     * @return - возврат значения.
     */
    public int getId() {
        return this.id;
    }
}
