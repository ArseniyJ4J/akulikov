package ru.job4j.multithreading.threads.stop;

/**
 * TimeStop Class.
 * @author Arseniy Kulikov.
 * @since 27.10.2017.
 * @version 1.
 */
public class TimeStop {

    /**
     * Поле класса.
     */
    private static final String TEXT = " In this text  is 25   characters.  ";

    /**
     * Поле класса.
     */
    private static final long STOPTIME = 2500;

    /**
     * Внутренний класс CountChar.
     */
    public static class CountChar implements Runnable {

        /**
         * Поле класса.
         */
        private String text;

        /**
         * Конструктор.
         * @param text - текст.
         */
        public CountChar(String text) {
            this.text = text;
        }

        @Override
        public void run() {

            int count = 0;

            for (char value : this.text.toCharArray()) {
                if (Thread.currentThread().isInterrupted()) {
                    return;
                }
                Character element = value;
                if (!element.equals(' ')) {
                    count++;
                }
            }
            System.out.printf("There are %s characters in text.%n", count);
        }
    }

    /**
     * Метод main.
     * @param args - параметр.
     */
    public static void main(String[] args) {
        long start = System.currentTimeMillis();

        System.out.println("Start program...");

        Thread cc = new Thread(new CountChar(TEXT));
        long current = System.currentTimeMillis();
        cc.start();
        long buffer = current - start;

        try {
            Thread.sleep(STOPTIME - buffer);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        if (cc.isAlive()) {
            cc.interrupt();
            System.out.println("Time out!");
        }

        if (!cc.isAlive()) {
            System.out.println("All right!");
        }
    }
}
