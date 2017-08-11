package ru.job4j.collections.bank.exceptions;

/**
 * Created by Ирина on 20.07.2017.
 */
public class UncorrectUser extends RuntimeException {
    /**
     * Метод обработки исключения.
     * @param msg - Название исключения.
     */
    public UncorrectUser(String msg) {
        super(msg);
    }
}
