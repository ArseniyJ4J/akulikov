package ru.job4j.multithreading.threads;

/**
 * Main Class.
 * @author Arseniy Kulikov.
 * @since 16.10.2017.
 * @version 1.
 */
public class MainClass {
    /**
     * Поле класса.
     */
    private static final String INPUT = " In this text  is   fourteen whitespaces, and nine words.  ";

    /**
     * Метод mian.
     * @param args - параметр.
     */
    public static void main(String[] args) {

        TxtCalculator calc = new TxtCalculator();

        new Thread(new Runnable() {
            @Override
            public void run() {
                int result = calc.whiteSpace(INPUT);
                System.out.printf("White spaces: %s%n", result);
            }
        }).start();

        new Thread(new Runnable() {
            @Override
            public void run() {
                int result = calc.wordsNumber(INPUT);
                System.out.printf("Words in text: %s%n", result);
            }
        }).start();
    }
}
