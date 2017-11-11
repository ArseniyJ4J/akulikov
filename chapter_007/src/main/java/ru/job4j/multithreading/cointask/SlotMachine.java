package ru.job4j.multithreading.cointask;

import java.util.ArrayList;
import java.util.List;

/** Class SlotMachine.
 * @author Arseniy Kulkiov
 * @since 11.11.2017
 * @version 1
 */
public class SlotMachine {

    /**
     * Поле класса.
     */
    private final int[] coinsType = {1, 2, 5, 10, 50, 100, 200, 500, 1000, 2000, 5000};

    /**
     * Метод для покупки кофе в автомате.
     * @param price - цена кофе.
     * @param banknote - сумма, которую передали в автомат.
     * @return - возврат массива монет со сдачей.
     */
    public int[] changes(int price, int banknote) {
        System.out.printf("Coffee price: %s. Your money: %s%n===================================%n", price, banknote);
        int[] result;
        int residual = banknote - price;
        if (residual > 0) {
            result = this.coinReturn(residual);
            System.out.printf("Take your cofee, and money:%n");
            for (int value : result) {
                if (value > 0) {
                    System.out.printf("%s%n", value);
                } else {
                    break;
                }

            }
        } else if (residual < 0) {
            System.out.println("Not enough money!");
            result = null;
        } else {
            System.out.println("Please, take your cofee.");
            result = null;
        }
        return result;
    }

    /**
     * Метод считающий монеты для сдачи.
     * @param residual - размер сдачи.
     * @return - возврат значения.
     */
    private int[] coinReturn(int residual) {
        List<Integer> container = new ArrayList<Integer>(30);
        int buffer = residual;
        for (int i = coinsType.length - 1; i >= 0; i--) {
            if (buffer == 0) {
                break;
            }
            int coin = this.coinsType[i];
            if (coin < residual) {
                while (buffer >= coin) {
                    container.add(coin);
                    buffer -= coin;
                }
            }
        }
        int[] result = new int[container.size()];
        int index = 0;
        for (Integer value : container) {
            result[index++] = value;
        }
        return result;
    }
}
