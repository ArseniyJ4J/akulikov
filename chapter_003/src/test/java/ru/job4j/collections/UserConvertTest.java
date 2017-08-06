package ru.job4j.collections;

import org.junit.Test;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/** Class Класс UserConvertTest.
 * @author Arseniy Kulkiov
 * @since 06.08.2017
 * @version 1
 */

public class UserConvertTest {

    /**
     * Test.
     */
    @Test
    public void userconvertTest() {
        User ivan = new User(0001, "Ivan", "Arzamas");
        User oleg = new User(0002, "Oleg", "Vladivostok");
        User viktor = new User(0003, "Viktor", "Moscow");
        List<User> list = new LinkedList<>();
        list.add(ivan);
        list.add(oleg);
        list.add(viktor);
        UserConvert uc = new UserConvert();
        HashMap<Integer, User> hashMap = uc.process(list);
        boolean result = false;
        for (User user : list) {
            if (hashMap.containsKey(user.getId())) {
                result = true;
            } else {
                result = false;
                break;
            }
        }
        assertThat(result, is(true));

    }
}
