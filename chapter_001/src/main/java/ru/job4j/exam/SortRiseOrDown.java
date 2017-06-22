package ru.job4j.exam;
/**
 * Class Класс определения сортировки массива чисел по убыванию или возрастанию.
 * @author akulikov
 * @since 23.05.2017
 * @version 1
 */
public class SortRiseOrDown {
    /**
     * Метод определяющий наличие одного набора символов строки в другой строке.
     *
     * @param array - анализируемый массив.
     * @return - возвращение значения.
     */
    public boolean sort(int[] array) {
        boolean result = true;
        int score = 0;
        for (int i = 0; i < array.length - 1; i++) {
            if (array[i] < array[i + 1]) {
                score++;
            } else if (array[i] > array[i + 1]) {
                score--;
            }
        }
            if (Math.abs(score) != array.length - 1) {
                result = false;
            }
        return result;
    }
}
