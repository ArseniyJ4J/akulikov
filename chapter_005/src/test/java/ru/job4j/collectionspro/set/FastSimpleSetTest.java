package ru.job4j.collectionspro.set;

import org.junit.Test;

/**
 * FastSimpleSetTest Class.
 * @author Arseniy Kulkiov
 * @since 21.09.2017
 * @version 1
 */

public class FastSimpleSetTest {
    /**
     * Метод генерации массива целых чисел для последующего использования в тесте.
     * @param size - размер массива.
     * @return - возврат значения.
     */
    private Integer[] lineArray(int size) {
        Integer[] result = new Integer[size];
        for (int i = 0; i < size; i++) {
            result[i] = i;
        }
        return result;
    }
    /**
     * Поле класса.
     */
    private Integer[] array = this.lineArray(1000);
    /**
     * Test.
     */
    @Test
    public void fastSempleSetTest() {
        FastSimpleSet<Integer> fss = new FastSimpleSet<>();
        long startTimeFSS = System.currentTimeMillis();
        for (Integer value : this.array) {
            fss.add(value);
        }
        long finishTimeFSS = System.currentTimeMillis();
        long resultTimeFSS = finishTimeFSS - startTimeFSS;
        System.out.printf("Время добавления 1000 объектов Integer в FastSimpleSet:  %s%n", resultTimeFSS);
    }
    /**
     * Test.
     */
    @Test
    public void simpleSetTest() {
        SimpleLinkedSet<Integer> sll = new SimpleLinkedSet<>();
        long startTimeSLL = System.currentTimeMillis();
        for (Integer value : this.array) {
            sll.add(value);
        }
        long finishTimeSLL = System.currentTimeMillis();
        long resultTimeSLL = finishTimeSLL - startTimeSLL;
        System.out.printf("Время добавления 1000 объектов Integer в SimpleLinkedSet: %s%n", resultTimeSLL);
    }
    /**
     * Test.
     */
    @Test
    public void simpleArraySetTest() {
        SimpleSet<Integer> ss = new SimpleSet<>();
        long startTimeSS = System.currentTimeMillis();
        for (Integer value : this.array) {
            ss.add(value);
        }
        long finishTimeSS = System.currentTimeMillis();
        long resultTimeSS = finishTimeSS - startTimeSS;
        System.out.printf("Время добавления 1000 объектов Integer в SimpleArraySet: %s%n", resultTimeSS);
    }
}