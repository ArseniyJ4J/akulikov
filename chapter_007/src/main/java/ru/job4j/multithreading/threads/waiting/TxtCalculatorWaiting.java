package ru.job4j.multithreading.threads.waiting;

/**
 * TxtCalculatorWaiting Class.
 * @author Arseniy Kulikov.
 * @since 26.10.2017.
 * @version 1.
 */
public class TxtCalculatorWaiting {

    /**
     * Метод считающий количество слов в текстовом объекте.
     * @param input - текстовый объект.
     * @return - возврат значения.
     */
    public int wordsNumber(String input) {
        int result = 0;
        int counter = 0;

        for (int i = 0; i < input.length(); i++) {
            if (counter == 1) {
                result++;
            }
            Character ch = input.charAt(i);
            if (!ch.equals(' ')) {
                counter++;
            } else {
                counter = 0;
            }
        }
        return result;
    }

    /**
     * Метод считающий количество пробелов в текстовом объекте.
     * @param input - текстовый объект.
     * @return - возврат значения.
     */
    public int whiteSpace(String input) {
        int result = 0;

        for (int i = 0; i < input.length(); i++) {
            Character ch = input.charAt(i);
            if (ch.equals(' ')) {
                result++;
            }
        }
        return result;
    }
}
