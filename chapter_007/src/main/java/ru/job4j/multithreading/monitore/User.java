package ru.job4j.multithreading.monitore;

/**
 * User Class.
 * @author Arseniy Kulikov.
 * @since 30.10.2017.
 * @version 1.
 */
public class User {

    /**
     * Class field - id of User.
     */
    private int id;

    /**
     * Class field - amount of User.
     */
    private int amount;

    /**
     * Constructor.
     * @param id - id of User.
     * @param amount - amount of User.
     */
    public User(int id, int amount) {
        this.id = id;
        this.amount = amount;
    }

    /**
     * Getter.
     * @return - return statement.
     */
    public int getId() {
        return id;
    }

    /**
     * Getter.
     * @return - return statement.
     */
    public int getAmount() {
        return amount;
    }

    /**
     * Setter.
     * @param amount - new amount.
     */
    public void setAmount(int amount) {
        this.amount = amount;
    }
}
