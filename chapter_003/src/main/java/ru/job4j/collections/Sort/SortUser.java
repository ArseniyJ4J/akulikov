package ru.job4j.collections.Sort;

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
}

