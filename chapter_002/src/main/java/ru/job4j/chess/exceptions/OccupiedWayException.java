package ru.job4j.chess.exceptions;

/**
 * Created by Ирина on 20.07.2017.
 */
public class OccupiedWayException extends RuntimeException {
    /**
     * Метод обработки исключения.
     * @param msg - Название исключения.
     */
    public OccupiedWayException(String msg) {
        super(msg);
    }
}
