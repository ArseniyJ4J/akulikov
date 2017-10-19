package ru.job4j.multithreading.threads;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * TxtCalculator Class.
 * @author Arseniy Kulikov.
 * @since 16.10.2017.
 * @version 1.
 */
public class TxtCalculator {

    /**
     * Метод считающий количество слов в текстовом объекте.
     * @param input - текстовый объект.
     * @return - возврат значения.
     */
    public int wordsNumber(String input) {
        String regex = "\\S+";
        int result = 0;
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(input);
        while (matcher.find()) {
            result++;
        }
        return result;
    }

    /**
     * Метод считающий количество пробелов в текстовом объекте.
     * @param input - текстовый объект.
     * @return - возврат значения.
     */
    public int whiteSpace(String input) {
        String regex = "\\s";
        int result = 0;
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(input);
        while (matcher.find()) {
            result++;
        }
        return result;
    }
}
