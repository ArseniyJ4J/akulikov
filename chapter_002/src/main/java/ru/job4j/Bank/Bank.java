package ru.job4j.Bank;

import java.util.Arrays;

/** Класс Bank.
 * @author Arseniy Kulkiov
 * @since 18.07.2017
 * @version 1
 */

public class Bank {
    /**
     * Константа - время начала работы банка.
     */
    static final double TIME_START = 8;
    /**
     * Константа - время окончания работы банка.
     */
    static final double TIME_FINISH = 20;
    /**
     * Метод возвращающий массив со значениями границ периодов.
     * @param mans - массив посетителей.
     * @return - возврат значения.
     */
    public double[] periods(Man[] mans) {
        double[] periods = new double[mans.length * 2 + 2];
        int j = 2;
        periods[0] = TIME_START;
        periods[1] = TIME_FINISH;
        for (int i = 0; i < mans.length; i++) {
            periods[j++] = mans[i].getTimeEnter();
            periods[j++] = mans[i].getTimeExit();
        }
        int lim = periods.length - 1;
        int z = 0;
        for (int i = 0; i < lim; i++) {
            for (int e = i + 1; e <= lim - z; e++) {
                double buffer;
                if (periods[i] == periods[e]) {
                    buffer = periods[e];
                    periods[e] = periods[lim - z];
                    periods[lim - z] = buffer;
                    z++;
                    e--;
                }
            }
        }
        double[] buffer = Arrays.copyOf(periods, periods.length - z);
        Arrays.sort(buffer);
        return buffer;
    }
    /**
     * Метод возвращающий массив с количеством посетителей в каждом ключевом периоде.
     * @param mans - массив посетителей.
     * @return - возврат значения.
     */
    public double[] result(Man[] mans) {
        double[] periods = this.periods(mans);
        double[] result = new double[periods.length - 1];
        for (int j = 0; j < periods.length - 1; j++) {
            for (int i = 0; i < mans.length; i++) {
                if ((periods[j] >= mans[i].getTimeEnter() && periods[j] <= mans[i].getTimeExit())
                        && (periods[j + 1] >= mans[i].getTimeEnter() && periods[j + 1] <= mans[i].getTimeExit())) {
                    result[j] = result[j] + 1;
                }
            }
        }

        return result;
    }

    /**
     * Метод определения и вывода на консоль периоды времени, когда в банке было максимальное количество посетителей.
     * @param man - массив посетителей.
     */
    public void outPut(Man[] man) {
        double[] periods = this.periods(man);
        double[] result = this.result(man);
        int max = 0;
        int[] index = new int[result.length];
        for (int i = 0; i < result.length; i++) {
            for (int j = 1; j < result.length; j++) {
                if (result[i] >= result[j]) {
                    index[i] = 1;
                    if (result[i] > max) {
                        max = (int) result[i];
                    }
                } else  {
                    index[i] = 0;
                    break;
                }
            }
        }
        System.out.printf("Максимальное количество посетителей: %s", max);
        System.out.printf(" в период(ы) времени: ");
        for (int i = 0; i < index.length; i++) {
            if (index[i] == 1) {
                System.out.printf("%s - %s; ", Double.toString(periods[i]), Double.toString(periods[i + 1]));
            }
        }
    }
    /**
    public static void main (String[] args) {
        Man[] man = {
                new Man(8, 12),
                new Man(8, 13),
                new Man(8, 11),
                new Man(9, 11),
                new Man(10, 12),
                new Man(15, 20),
        };
        Bank bank = new Bank();
        bank.outPut(man);
    }
     */
}
