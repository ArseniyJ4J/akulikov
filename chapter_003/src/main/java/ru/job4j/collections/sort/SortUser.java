package ru.job4j.collections.sort;

//import ru.job4j.collections.User;


import java.util.Comparator;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

/** Class Класс SortUser.
 * @author Arseniy Kulkiov
 * @since 08.08.2017
 * @version 1
 */

public class SortUser  {
    /**
     * Метод возвращающий Set объектов User отсоритрованных по возрастанию поля age.
     * @param list - list неотсортированных объектов User
     * @return - возврат значения.
     */
    public Set<User> sort(List<User> list) {
        TreeSet<User> result = new TreeSet<>();
        list.sort(
                new Comparator<User>() {
                    @Override
                    public int compare(User o1, User o2) {
                        return o1.compareTo(o2);
                    }
                }
        );
        for (User user : list) {
            result.add(user);
        }
        return result;
    }
    /**
     * Метод сортирующий коллекцию объектов User по длине поля name.
     * @param list - входящий для сортировки list объектов User.
     * @return - возврат значения.
     */
    public List<User> sortNameLength(List<User> list) {
        list.sort(
                new Comparator<User>() {
                    @Override
                    public int compare(User o1, User o2) {
                        int result = 0;
                        result = o1.getName().length() < o2.getName().length() ? -1 : 1;
                        return result;
                    }
                });
        return list;
    }
    /**
     * Метод сортирующий коллекцию объектов User сначала по полю name, а затем по полю age.
     * @param list - входящий для сортировки list объектов User.
     * @return - возврат значения.
     */
    public List<User> sortByAllField(List<User> list) {
        list.sort(
                new Comparator<User>() {
                    @Override
                    public int compare(User o1, User o2) {
                        int result = o1.getName().compareTo(o2.getName());
                        if (result == 0) {
                            result = o1.compareTo(o2);
                        }
                        return result;
                    }
                }
        );
        return list;
    }
}

