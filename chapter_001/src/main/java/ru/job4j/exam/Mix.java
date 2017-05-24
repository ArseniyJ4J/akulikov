package ru.job4j.exam;
/**
 * Class Класс складывающий два возрастающих массива в один такой же.
 * @author akulikov
 * @since 23.05.2017
 * @version 1
 */
public class Mix {

    public int[] mix(int[] a, int[] b) {
        int[] mix = new int[a.length + b.length];
        int ascore = 0;
        int bscore = 0;
        for (int i = 0; i < mix.length; i++){
            if (ascore < a.length && bscore < b.length) {
                if (a[ascore] <= b[bscore]) {
                  mix[i] = a[ascore];
                  ascore++;
                } else {
                    mix[i] = b[bscore];
                    bscore++;
                }
            } else if (ascore < a.length) {
                mix[i] = a[ascore];
                ascore++;
            } else {
                mix[i] = b[bscore];
                bscore++;
            }
        }
        return mix;
    }
}
