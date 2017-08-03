package ru.job4j.collections;

import java.util.ArrayList;
import java.util.Collection;
import java.util.LinkedList;
import java.util.TreeSet;

/** Класс Time. Проверка времени выполнения добавления\удаления на различных типах коллекций.
 * @author Arseniy Kulkiov
 * @since 03.08.2017
 * @version 1
 */

public class Time {
    /**
     * Метод выполняющий добавление элементов в коллекцию.
     * @param collection - коллекция.
     * @param amount - количество элементов коллекции.
     * @return - возврат значения затраченного времени.
     */
    public long add(Collection<String> collection, int amount) {
        String[] array = new String[amount];
        for (int i = 0; i < amount; i++) {
            array[i] = this.randome();
        }
        long start = System.nanoTime();
        for (int i = 0; i < amount; i++) {
            collection.add(array[i]);
        }
        long finish = System.nanoTime();
        long addTime = finish - start;
        return addTime;
    }
    /**
     * Метод выполняющий удаление первой половины элементов коллекции.
     * @param collection - коллекция.
     * @param amount - количество элементов коллекции.
     * @return - возврат значения затраченного времени.
     */
    public long delete(Collection<String> collection, int amount) {
        String[] array = new String[amount];
        for (int i = 0; i < amount; i++) {
            array[i] = this.randome();
        }
        for (int i = 0; i < amount; i++) {
            collection.add(array[i]);
        }
        long start = System.nanoTime();
        for (int i = 0; i <= amount / 2; i++) {
            collection.remove(array[i]);
        }
        long finish = System.nanoTime();
        long deleteTime = finish - start;
        return deleteTime;
    }

    /**
     * Метод генерирующий строку из 10-ти случайных символов.
     * @return - возврат значения.
     */
    private String randome() {
        String symbols = "qwertyuiopasdfghjklzxcvbnm";
        StringBuilder generate = new StringBuilder();
        for (int i = 0; i != 10; i++) {
            generate.append(symbols.charAt((int) (Math.random() * symbols.length())));
        }
        return generate.toString();
    }

    /**
     * Метод main.
     * @param args - массив строк командной строки.
     */
    public static void main(String[] args) {
        Time time = new Time();
        LinkedList<String> linkedList = new LinkedList<>();
        ArrayList<String> arrayList = new ArrayList<>();
        TreeSet<String> treeSet = new TreeSet<>();
        System.out.printf("Time for add to LinkedList: %s %n", time.add(linkedList, 100000));
        System.out.printf("Time for add to ArrayList:  %s %n", time.add(arrayList, 100000));
        System.out.printf("Time for add to Treeset:    %s %n", time.add(treeSet, 100000));
        LinkedList<String> linkedList2 = new LinkedList<>();
        ArrayList<String> arrayList2 = new ArrayList<>();
        TreeSet<String> treeSet2 = new TreeSet<>();
        System.out.printf("Time for delete to LinkedList: %s %n", time.delete(linkedList2, 100000));
        System.out.printf("Time for delete to ArrayList:  %s %n", time.delete(arrayList2, 100000));
        System.out.printf("Time for delete to Treeset:    %s %n", time.delete(treeSet2, 100000));

    }
}
