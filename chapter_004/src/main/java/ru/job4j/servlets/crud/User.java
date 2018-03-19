package ru.job4j.servlets.crud;

import java.sql.Timestamp;

/** Class User.
 * @author Arseniy Kulkiov
 * @since 19.03.2017
 * @version 1
 */
public class User {
    /**
     * Class field.
     */
    private String name;
    /**
     * Class field.
     */
    private String login;
    /**
     * Class field.
     */
    private String email;
    /**
     * Class field.
     */
    private String createDate;

    /**
     * Getter.
     * @return - return statement.
     */
    public String getName() {
        return name;
    }

    /**
     * Setter.
     * @param name - parameter.
     */
    public void setName(String name) {
        this.name = name;
    }
    /**
     * Getter.
     * @return - return statement.
     */
    public String getLogin() {
        return login;
    }
    /**
     * Setter.
     * @param login - parameter.
     */
    public void setLogin(String login) {
        this.login = login;
    }
    /**
     * Getter.
     * @return - return statement.
     */
    public String getEmail() {
        return email;
    }
    /**
     * Setter.
     * @param email - parameter.
     */
    public void setEmail(String email) {
        this.email = email;
    }
    /**
     * Getter.
     * @return - return statement.
     */
    public String getCreateDate() {
        return createDate;
    }
    /**
     * Setter.
     * @param createDate - parameter.
     */
    public void setCreateDate(String createDate) {
        this.createDate = createDate;
    }

    /**
     * Constructor.
     * @param name - parameter.
     * @param login - parameter.
     * @param email - parameter.
     */
    public User(String name, String login, String email) {
        this.name = name;
        this.login = login;
        this.email = email;
        this.createDate = new Timestamp(System.currentTimeMillis()).toString();
    }

    @Override
    public String toString() {
        return String.format("name: %s, login: %s, email: %s,  createDate: %s", this.name, this.login, this.email, this.createDate);
    }
}
