package ru.job4j.collections;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/** Класс ConvertList. Конвертация двумерного массива в List и наоборот.
 * @author Arseniy Kulkiov
 * @since 05.08.2017
 * @version 1
 */

public class ConvertList {
    /**
     * Метод возвращающий List из двумерного массива.
     * @param array - двумерный массив.
     * @return - возврат значения.
     */
    public List<Integer> toList(int[][] array) {
        List<Integer> list = new LinkedList<Integer>();
        for (int[] rowValue : array) {
            for (int cellValue : rowValue) {
                list.add(cellValue);
            }
        }
        return list;
    }
    /**
     * Метод возвращающий двумерный массив из List с распределением значений в заданное количество строк.
     * @param list - лист.
     * @param raw - количество строк в двумерном массиве.
     * @return - возврат значения.
     */
    public int[][] toArray(List<Integer> list, int raw) {
        int tail = 0;
        if (list.size() % raw != 0) {
            tail = 1;
        }
        int col = list.size() / raw + tail;
        int[][] array = new int[raw][col];
        int i = 0;
        int j = 0;
        if (i * col + j < list.size()) {
            for (int value : list) {
                array[i][j] = value;
                if (j != col - 1) {
                    j++;
                } else {
                    i++;
                    j = 0;
                }
            }
        } else {
            for (int h = j; h < col; h++) {
                array[i][h] = 0;
            }
        }
        return array;
    }
    /**
     * Метод main.
     * @param args - массив строк командной строки.
     */
    public static void main(String[] args) {
        int[][] a = {{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};
        ConvertList convertList = new ConvertList();
        List<Integer> list = convertList.toList(a);
        for (Integer b : list) {
            System.out.println(b);
        }
        System.out.println("=====================================");
        int[][] c = convertList.toArray(list, 2);
        for (int i = 0; i < c.length; i++) {
            System.out.println(Arrays.toString(c[i]));
        }
    }
}
