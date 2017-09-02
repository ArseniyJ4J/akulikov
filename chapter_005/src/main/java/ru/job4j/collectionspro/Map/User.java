package ru.job4j.collectionspro.Map;

import java.util.Calendar;

/** Класс Map.
 * @author Arseniy Kulkiov
 * @since 02.09.2017
 * @version 1
 */

public class User {

    /**
     * Поле класса name.
     */
    private String name;

    /**
     * Поле класса children.
     */
    private int children;

    /**
     * Поле класса birthday.
     */
    private Calendar birthday;

    /**
     * Конструктор.
     * @param name - имя.
     * @param children - количество детей.
     * @param birthday - день рождения.
     */
    public User(String name, int children, Calendar birthday) {
        this.name = name;
        this.children = children;
        this.birthday = birthday;
    }

    /**
     * Геттер для поля Name.
     * @return - возврат значения.
     */
    public String getName() {
        return name;
    }

    /**
     * Геттер для поля children.
     * @return - возврат значения.
     */
    public int getChildren() {
        return children;
    }

    /**
     * Геттер для поля birthday.
     * @return - возврат значения.
     */
    public Calendar getBirthday() {
        return birthday;
    }
}
