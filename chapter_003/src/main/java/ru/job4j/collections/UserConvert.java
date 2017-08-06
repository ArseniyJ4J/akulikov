package ru.job4j.collections;

import java.util.HashMap;
import java.util.List;

/** Class Класс UserConvert.
 * @author Arseniy Kulkiov
 * @since 06.08.2017
 * @version 1
 */

public class UserConvert {
    /**
     * Метод перобразующий List объектов типа User в HashMap этих объектов в полев id в качестве ключа.
     * @param list - Коллекция List объектов User.
     * @return - возврат значения.
     */
    HashMap<Integer, User> process(List<User> list) {
        HashMap<Integer, User> result = new HashMap<>();
        for (User user : list) {
            int id = user.getId();
            result.put(id, user);
        }
        return result;
    }
}
