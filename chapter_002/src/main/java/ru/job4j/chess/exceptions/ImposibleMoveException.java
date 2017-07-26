package ru.job4j.chess.exceptions;

/**
 * Created by Ирина on 20.07.2017.
 */
public class ImposibleMoveException extends RuntimeException {
    /**
     * Метод обработки исключения.
     * @param msg - Название исключения.
     */
    public ImposibleMoveException(String msg) {
        super(msg);
    }
}
