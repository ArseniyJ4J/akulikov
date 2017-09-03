package ru.job4j.collectionspro.map;

import org.junit.Test;

import java.util.GregorianCalendar;
import java.util.HashMap;
import java.util.Map;

/**
 * UserTest Class.
 * @author Arseniy Kulkiov
 * @since 02.09.2017
 * @version 1
 */

public class UserTest {

    /**
     * Test.
     */
    @Test
    public void firstUserTest() {
        User user1 = new User("Arseniy", 0, new GregorianCalendar(1989, 02,07));
        User user2 = new User("Arseniy", 0, new GregorianCalendar(1989, 02,07));
        Map<User, Object> testMap = new HashMap<>();
        testMap.put(user1, "Engineer");
        testMap.put(user2, "Developer");
        System.out.println(testMap);
        System.out.println(user1.hashCode());
        System.out.println(user2.hashCode());
    }

    /**
     * Test.
     */
    @Test
    public void secondUserOverrideHashCodeTest() {
        UserOverrideHashCode user1 = new UserOverrideHashCode("Arseniy", 0, new GregorianCalendar(1989, 02,07));
        UserOverrideHashCode user2 = new UserOverrideHashCode("Arseniy", 0, new GregorianCalendar(1989, 02,07));
        Map<UserOverrideHashCode, Object> testMap = new HashMap<>();
        testMap.put(user1, "Engineer");
        testMap.put(user2, "Developer");
        System.out.println(testMap);
        System.out.println(user1.hashCode());
        System.out.println(user2.hashCode());
    }

    /**
     * Test.
     */
    @Test
    public void thirdUserOverrideEqualsTest() {
        UserOverrideEquals user1 = new UserOverrideEquals("Arseniy", 0, new GregorianCalendar(1989, 02,07));
        UserOverrideEquals user2 = new UserOverrideEquals("Arseniy", 0, new GregorianCalendar(1989, 02,07));
        Map<UserOverrideEquals, Object> testMap = new HashMap<>();
        testMap.put(user1, "Engineer");
        testMap.put(user2, "Developer");
        System.out.println(testMap);
        System.out.println(user1.hashCode());
        System.out.println(user2.hashCode());
        System.out.println(user1.equals(user2));
    }

}
