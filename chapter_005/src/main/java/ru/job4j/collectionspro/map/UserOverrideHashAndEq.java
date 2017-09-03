package ru.job4j.collectionspro.map;

import java.util.Calendar;

/** Класс Map.
 * @author Arseniy Kulkiov
 * @since 02.09.2017
 * @version 1
 */

public class UserOverrideHashAndEq {

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
     *
     * @param name     - имя.
     * @param children - количество детей.
     * @param birthday - день рождения.
     */
    public UserOverrideHashAndEq(String name, int children, Calendar birthday) {
        this.name = name;
        this.children = children;
        this.birthday = birthday;
    }

    /**
     * Геттер для поля Name.
     *
     * @return - возврат значения.
     */
    public String getName() {
        return name;
    }

    /**
     * Геттер для поля children.
     *
     * @return - возврат значения.
     */
    public int getChildren() {
        return children;
    }

    /**
     * Геттер для поля birthday.
     *
     * @return - возврат значения.
     */
    public Calendar getBirthday() {
        return birthday;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        UserOverrideHashAndEq that = (UserOverrideHashAndEq) o;

        if (children != that.children) return false;
        if (name != null ? !name.equals(that.name) : that.name != null) return false;
        return birthday != null ? birthday.equals(that.birthday) : that.birthday == null;
    }

    @Override
    public int hashCode() {
        int result = name != null ? name.hashCode() : 0;
        result = 31 * result + children;
        result = 31 * result + (birthday != null ? birthday.hashCode() : 0);
        return result;
    }

}