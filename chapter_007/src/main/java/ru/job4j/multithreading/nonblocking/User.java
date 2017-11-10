package ru.job4j.multithreading.nonblocking;

/**
 * User Class.
 * @author Arseniy Kulikov.
 * @since 10.11.2017.
 * @version 1.
 */
public class User {
    /**
     * Поле класса.
     */
    private int key;
    /**
     * Поле класса.
     */
    private String value;
    /**
     * Поле класса.
     */
    private int version;

    /**
     * Конструктор.
     * @param key - ключ.
     * @param value - значение.
     */
    public User(int key, String value) {
        this.key = key;
        this.value = value;
    }

    /**
     * Сеттер для поля класса value.
     * @param value - новое значение..
     */
    public void setValue(String value) {
        this.value = value;
        this.version++;
    }
    /**
     * Геттер для поля класса key.
     * @return - возврат значения.
     */
    public int getKey() {
        return key;
    }

    /**
     * Геттер для поля класса Value.
     * @return - возврат значения.
     */
    public String getValue() {
        return value;
    }

    /**
     * Геттер для поля класса Version.
     * @return - возврат значения.
     */
    public int getVersion() {
        return version;
    }
}
