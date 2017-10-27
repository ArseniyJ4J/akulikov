package ru.job4j.multithreading.threads.waiting;

/**
 * Waiting Class.
 * @author Arseniy Kulikov.
 * @since 27.10.2017.
 * @version 1.
 */
public class Waiting {

    /**
     * Поле класса.
     */
    private static final String INPUT = " In this text  is   fourteen whitespaces, and nine words.  ";

    /**
     * Внутренний класс WordsCalc.
     */
    private static class WordsCalc implements Runnable {

        /**
         * Метод считающий количество слов в текстовом объекте.
         * @param input - текстовый объект.
         * @return - возврат значения.
         */
        public int wordsNumber(String input) {
            int result = 0;
            int counter = 0;

            for (int i = 0; i < input.length(); i++) {

                if (Thread.currentThread().isInterrupted()) {
                    break;
                }

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

        @Override
        public void run() {
            int count = this.wordsNumber(INPUT);
            if (Thread.currentThread().isInterrupted()) {
                return;
            }
            System.out.printf("There are %s words in string.%n", count);
        }
    }

    /**
     * Внутренний класс SpaceCalc.
     */
    private static class SpacesCalc implements Runnable {

        /**
         * Метод считающий количество пробелов в текстовом объекте.
         * @param input - текстовый объект.
         * @return - возврат значения.
         */
        public int whiteSpace(String input) {
            int result = 0;
            for (int i = 0; i < input.length(); i++) {
                if (Thread.currentThread().isInterrupted()) {
                    break;
                }
                Character ch = input.charAt(i);
                if (ch.equals(' ')) {
                    result++;
                }
            }
            return result;
        }

        @Override
        public void run() {
            int count = this.whiteSpace(INPUT);
            if (Thread.currentThread().isInterrupted()) {
                return;
            }
            System.out.printf("There are %s words in string.%n", count);
        }
    }

    /**
     * Метод main.
     * @param args - параметр.
     */
    public static void main(String[] args) {

        long start = System.currentTimeMillis();

        System.out.println("Start program...");

        Thread wt = new Thread(new WordsCalc());
        Thread st = new Thread(new SpacesCalc());

        wt.start();
        st.start();
        try {
            long current = System.currentTimeMillis();
            long buffer = current - start;
            Thread.sleep(1000 - buffer);
            if (wt.isAlive()) {
                wt.interrupt();
            }
            if (st.isAlive()) {
                st.interrupt();
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("Finish program.");
    }
}
