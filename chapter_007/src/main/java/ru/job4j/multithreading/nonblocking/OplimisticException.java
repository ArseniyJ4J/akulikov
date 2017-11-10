package ru.job4j.multithreading.nonblocking;

/**
 * OplimisticException Class.
 * @author Arseniy Kulikov.
 * @since 10.11.2017.
 * @version 1.
 */
public class OplimisticException extends Exception {

    /**
     * Исключение.
     * @param text - текст.
     */
    public OplimisticException(String text) {
        super(text);
    }
}
