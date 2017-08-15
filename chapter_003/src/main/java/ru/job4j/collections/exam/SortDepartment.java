package ru.job4j.collections.exam;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

import static java.lang.Character.isDigit;

/** Class Класс SortDepartment.
 * @author Arseniy Kulkiov
 * @since 14.08.2017
 * @version 1
 */

public class SortDepartment {
    /**
     * Поле класса - массив со входящими значениями.
     */
    private String[] entryData = new String[] {"K1\\SK1", "K1\\SK2", "K1\\SK1\\SSK1", "K1\\SK1\\SSK2", "K2", "K2\\SK1\\SSK1", "K2\\SK1\\SSK2"};
    /**
     * Поле класса - list с преобразованными входящими значениями в виде множества неповторяющихся объектов Department.
     */
    private List<Department> departments = new ArrayList<>();
    /**
     * Геттер для поля entryData.
     * @return - возврат значения.
     */
    public String[] getEntryData() {
        return entryData;
    }
    /**
     * Геттер для поля departments.
     * @return - возврат значения.
     */
    public List<Department> getDepartments() {
        return departments;
    }
    /**
     * Метод загружающий входящие значения в виде множества объектов Department в List<Department> departments.
     * @param entryData - входящий значения.
     */
    public void loadDepartment(String[] entryData) {
        List<String> list = new ArrayList<>();
        for (String string : entryData) {
            if (!list.contains(string)) {
                list.add(string);
            }
            StringBuilder sb = new StringBuilder(string);
            int index = 0;
            while (index != -1) {
                int delimiter = sb.indexOf("\\", ++index);
                index = delimiter;
                if (delimiter != -1) {
                    String subString = sb.substring(0, delimiter);
                    if (!list.contains(subString)) {
                        list.add(subString);
                    }
                }
            }
        }
        for (String string : list) {
            ArrayList<Integer> result = new ArrayList<>();
            for (int i = 0; i < string.length(); i++) {
                if (isDigit(string.charAt(i))) {
                    result.add(Integer.parseInt(Character.toString(string.charAt(i))));
                }
            }
            departments.add(new Department(string, result));
        }
    }
    /**
     * Метод сортирующий департаменты по возрастанию.
     * @param list - сортируемая коллекция.
     * @return - возврат значения.
     */
    public List<Department> ascendingSort(List<Department> list) {
        list.sort(new Comparator<Department>() {
            @Override
            public int compare(Department o1, Department o2) {
                return o1.getDepartment().compareTo(o2.getDepartment());
            }
        });
        return list;
    }
    /**
     * Метод сортирующий департаменты по убыванию с сохранением иерархии.
     * @param list - сортируемая коллекция.
     * @return - возврат значения.
     */
    public List<Department> descendingSort(List<Department> list) {
        this.ascendingSort(list);
        list.sort(new Comparator<Department>() {
            @Override
            public int compare(Department o1, Department o2) {
                int result = 1;
                if (o1.getCode().size() == o2.getCode().size()) {
                    for (int i = 0; i < o1.getCode().size(); i++) {
                        if (o1.getCode().get(i) > o2.getCode().get(i)) {
                            result = -1;
                            break;
                        }
                    }
                } else {
                    for (int i = 0; i < Integer.min(o1.getCode().size(), o2.getCode().size()); i++) {
                        if (o1.getCode().get(i) > o2.getCode().get(i)) {
                            result = -1;
                            break;
                        }
                    }
                }
                return result;
            }
        });
        return list;
    }
}
