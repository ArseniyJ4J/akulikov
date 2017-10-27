package ru.job4j.multithreading.threads.jmmtrouble;

/**
 * JMMTrouble Class.
 * @author Arseniy Kulikov.
 * @since 27.10.2017.
 * @version 1.
 */
public class JMMTrouble {

    /**
     * Поле класса.
     */
    private static int check = 0;

    /**
     * Поле класса.
     */
    private static int value = 500000;

    /**
     * Метод производящий прибавление по единице к переменной со значением ноль в одном потоке и вычитание в другом, одинаковое количество раз.
     * @return - возврат значения переменной.
     */
    public static int result() {

        Thread threadInc = new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < value; i++) {
                    check--;
                }
                return;
            }
        });

        Thread threadDec = new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < value; i++) {
                    check++;
                }
                return;
            }
        });
        threadInc.start();
        threadDec.start();
        try {
            threadDec.join();
            threadInc.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        int result = check;
        check = 0;
        return result;
    }

    /**
     * Метод main.
     * @param args - параметр.
     */
    public static void main(String[] args) {
        int zero = 0;
        int lessZero = 0;
        int aboveZero = 0;
        for (int i = 0; i < 1000; i++) {
            int result = result();
            if (result == 0) {
                zero++;
            } else if (result < 0) {
                lessZero++;
            } else {
                aboveZero++;
            }
        }
        System.out.printf("Для %s циклов повторений %s операций прибавления/вычитания единицы к нулю имеем следующий результаты:%n", 1000, value);
        System.out.printf("0: - %s раз (верный результат)%n", zero);
        System.out.printf(">0: - %s раз (ошибочный результат)%n", aboveZero);
        System.out.printf("<0: - %s раз (ошибочный результат)%n", lessZero);
    }
}
