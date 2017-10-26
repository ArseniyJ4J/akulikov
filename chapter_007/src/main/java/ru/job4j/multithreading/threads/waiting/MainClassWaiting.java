package ru.job4j.multithreading.threads.waiting;

import ru.job4j.multithreading.threads.TxtCalculator;

/**
 * Main Class.
 * @author Arseniy Kulikov.
 * @since 26.10.2017.
 * @version 1.
 */
public class MainClassWaiting {
    /**
     * Поле класса.
     */
    private static final String INPUT = " In this text  is   fourteen whitespaces, and nine words.  ";

    /**
     * Метод mian.
     * @param args - параметр.
     */
    public static void main(String[] args) {
        long start = System.currentTimeMillis();
        System.out.println("Start the program...");
        Thread countSpace = new Thread(new WhiteSpaces(INPUT));
        Thread countWords = new Thread(new Words(INPUT));
        countSpace.start();
        countWords.start();
        try {
            countSpace.join();
            countWords.join();
            long timeWork = System.currentTimeMillis() - start;
            if (timeWork > 1000) {
                countSpace.interrupt();
                countWords.interrupt();
            }

        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("Finish program.");
    }

    /**
     * Внутренний класс.
     */
    private static class WhiteSpaces implements Runnable {

        /**
         * Поле класса.
         */
        private static String input;

        /**
         * Конструктор.
         * @param input - строка для добработки.
         */
        WhiteSpaces(String input) {
            WhiteSpaces.input = input;
        }

        @Override
        public void run() {
            TxtCalculator calc = new TxtCalculator();
            int result = calc.whiteSpace(input);
            System.out.printf("White spaces: %s%n", result);
        }
    }

    /**
     * Внутренний класс.
     */
    private static class Words implements Runnable {

        /**
         * Поле класса.
         */
        private static String input;

        /**
         * Конструктор.
         * @param input - строка для добработки.
         */
        Words(String input) {
            Words.input = input;
        }

        @Override
        public void run() {
            TxtCalculator calc = new TxtCalculator();
            int result = calc.wordsNumber(input);
            System.out.printf("Words in text: %s%n", result);
        }
    }
}
