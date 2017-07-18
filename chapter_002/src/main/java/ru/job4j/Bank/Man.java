package ru.job4j.Bank;

/** Класс Man.
 * @author Arseniy Kulkiov
 * @since 18.07.2017
 * @version 1
 */

public class Man {
    /**
     * Время входа посетителя в банк.
     */
    private double timeEnter;
    /**
     * Время выхода посетителя из банка.
     */
    private double timeExit;
    /**
     * Конструктор посетителя Man.
     * @param timeEnter - время прихода посетителя.
     * @param timeExit - время выхода посетителя.
     */
    public Man(double timeEnter, double timeExit) {
        this.timeEnter = timeEnter;
        this.timeExit = timeExit;
    }
    /**
     * Геттер для поля timeEnter.
     * @return - возврат значения.
     */
    public double getTimeEnter() {
        return timeEnter;
    }
    /**
     * Геттер для поля timeExit.
     * @return - возврат значения.
     */
    public double getTimeExit() {
        return timeExit;
    }
}
