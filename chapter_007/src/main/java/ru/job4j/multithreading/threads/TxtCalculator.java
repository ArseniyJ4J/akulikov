package ru.job4j.multithreading.threads;

/**
 * TxtCalculator Class.
 * @author Arseniy Kulikov.
 * @since 16.10.2017.
 * @version 1.
 */
public class TxtCalculator {

    /**
     * Метод считающий количество слов в текстовом объекте.
     * @param text - текстовый объект.
     * @return - возврат значения.
     */
    public int wordsNumber(String text) {
        int result = text.split(" ").length;
        return result;
    }

    /**
     * Метод считающий количество пробело в текстовом объекте.
     * @param text - текстовый объект.
     * @return - возврат значения.
     */
    public int whiteSpace(String text) {
        int result = text.split(" ").length - 1;
        return result;
    }
}
