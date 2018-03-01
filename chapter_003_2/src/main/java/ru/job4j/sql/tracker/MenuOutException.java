package ru.job4j.sql.tracker;

/** Class Класс MenuOutException.
 * @author Arseniy Kulkiov
 * @since 10.07.2017
 * @version 1
 */

public class MenuOutException extends RuntimeException {
    /**
     * Метод обработки исключения.
     * @param msg - Название исключения.
     */
    public MenuOutException(String msg) {
        super(msg);
    }
}
