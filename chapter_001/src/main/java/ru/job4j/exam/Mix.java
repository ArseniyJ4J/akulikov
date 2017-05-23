package ru.job4j.exam;
/**
 * Class Класс складывающий два возрастающих массива в один такой же.
 * @author akulikov
 * @since 23.05.2017
 * @version 1
 */
public class Mix {

    public int[] mix(int[] a, int[] b) {
        int[] mix = new int[a.length + b.length - 2];
        int score = 0;
        for (int i = 0; i < a.length; i++){
            for (int j = 0; j < b.length; j++){
                if (a[i] <= b[j]) {
                 mix[score] = a[i];
                 score++;
                 i++;
                 break;
                } else {
                    mix[score] = b[j];
                    score++;
                }
            }
        }
        return mix;
    }
}
