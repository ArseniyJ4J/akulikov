package ru.job4j.collections.bank;
/** Class Класс User.
 * @author Arseniy Kulkiov
 * @since 11.08.2017
 * @version 1
 */
public class User {
    /**
     * Поле класса name.
     */
    private String name;
    /**
     * Поле класса passport.
     */
    private int passport;

    /**
     * Конструктор.
     * @param name - имя.
     * @param passport - паспорт.
     */
    public User(String name, int passport) {
        this.name = name;
        this.passport = passport;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }

        User user = (User) o;

        if (passport != user.passport) {
            return false;
        }
        return name != null ? name.equals(user.name) : user.name == null;
    }

    @Override
    public int hashCode() {
        int result = name != null ? name.hashCode() : 0;
        result = 31 * result + passport;
        return result;
    }
}
