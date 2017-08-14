package ru.job4j.collections.exam;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

/** Class Класс SortDepartment.
 * @author Arseniy Kulkiov
 * @since 14.08.2017
 * @version 1
 */
public class SortDepartment {

    public String[] departments = new String[] {"K1\\SK1", "K1\\SK2", "K1\\SK1\\SSK1", "K1\\SK1\\SSK2", "K2", "K2\\SK1\\SSK1", "K2\\SK1\\SSK2"};

    public List<String> list = new ArrayList<String>();

    public void loadDepartment(String[] stringArray) {
        for (String string : stringArray) {
            if (!this.list.contains(string)) {
                this.list.add(string);
            }
            StringBuilder sb = new StringBuilder(string);
            int index = 0;
            while (index != -1) {
                int delimiter = sb.indexOf("\\", ++index);
                index = delimiter;
                if (delimiter != -1) {
                    String subString = sb.substring(0, delimiter);
                    if (!this.list.contains(subString)) {
                        this.list.add(subString);
                    }
                }
            }
        }
    }

    public List<String> ascendingSort(List<String> list) {
        list.sort(new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                return o1.compareTo(o2);
            }
        });
        return list;
    }

    public List<String> descendingSort(List<String> list) {
        list.sort(new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                int result = o2.compareTo(o1);
//                =================================================
//                int result = 0;
//                if (o2.contains(o1)) {
//                    result = o2.compareTo(o1);
//                }
//===============================================================
//                int result = o2.compareTo(o1);
//                if (result == -1) {
//                    result = o2.contains(o1) ? -1 : 1;
//                }
//                int result = o1.contains(o2) ? 1 : -1;
//                System.out.println(result);
//                if (result == -1) {
//                    result = o2.compareTo(o1);
//                }
                return result;
            }
        });
        return list;
    }

    public static void main(String[] args) {
        SortDepartment sd = new SortDepartment();
        sd.loadDepartment(sd.departments);
        for (String string : sd.list) {
            System.out.println(string);
        }
        System.out.println("***********************************************");
        sd.ascendingSort(sd.list);
        for (String string : sd.list) {
            System.out.println(string);
        }
        System.out.println("***********************************************");
        sd.descendingSort(sd.list);
        for (String string : sd.list) {
            System.out.println(string);
        }
    }
}
