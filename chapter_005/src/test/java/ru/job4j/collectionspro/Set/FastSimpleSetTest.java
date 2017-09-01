package ru.job4j.collectionspro.Set;

import org.junit.Test;

/**
 * FastSetTest Class.
 * @author Arseniy Kulkiov
 * @since 01.09.2017
 * @version 1
 */

public class FastSimpleSetTest {

    public Integer[] randomeArray(int size) {
        Integer[] result = new Integer[size];
        int buffer = 0;
        for (int i = 0; i < size; i++) {
            if (i % 2 == 0) {
                result[i] = size / 2 - buffer++;
            } else if (i % 2 != 0) {
                result[i] = size / 2 + buffer;
            }
        }
        return result;
    }

    public Integer[] lineArray(int size) {
        Integer[] result = new Integer[size];
        for (int i = 0; i < size; i++) {
            result[i] = i;
        }
        return result;
    }

    private Integer[] array = this.lineArray(1000);

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

//    @Test
//    public void addTest() {
//        FastSimpleSet<Integer> fss = new FastSimpleSet<>();
//        fss.add(5);
//        fss.add(6);
//        fss.add(4);
//        fss.add(3);
//        fss.add(7);
//        fss.add(2);
//        fss.add(8);
//        fss.add(1);
//        fss.add(9);
//        fss.add(0);
//        fss.add(10);
//        fss.add(11);
//        fss.add(12);
//        fss.add(13);
//        fss.add(14);
//        fss.add(15);
//        fss.add(16);
//        for (Object value : fss.getContainer()) {
//            System.out.println((Integer) value);
//        }
//    }
//    @Test
//    public void trash() {
//        Integer a = 1;
//        Integer b = 123434;
//        String c = "c";
//        String d = "d";
//        System.out.println(a.hashCode());
//        System.out.println(b.hashCode());
//        System.out.println(c.hashCode());
//        System.out.println(d.hashCode());
//        Integer res = a / 2;
//        System.out.println("================");
//        System.out.println(res);
//    }
}