package ru.job4j.multithreading.threads;

/**
 * Main Class.
 * @author Arseniy Kulikov.
 * @since 16.10.2017.
 * @version 1.
 */
public class MainClass {
    /**
     * Метод mian.
     * @param args - параметр.
     */
    public static void main(String[] args) {

        TxtCalculator calc = new TxtCalculator();
        String text = "In this text is eight whitespaces, and nine words.";

        new Thread(new Runnable() {
            @Override
            public void run() {
                int result = calc.whiteSpace(text);
                System.out.printf("White spaces: %s%n", result);
            }
        }).start();

        new Thread(new Runnable() {
            @Override
            public void run() {
                int result = calc.wordsNumber(text);
                System.out.printf("Words in text: %s%n", result);
            }
        }).start();
    }
}
