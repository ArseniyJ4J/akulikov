package ru.job4j.servlets.crud;

import org.junit.Test;

/** Class UserStoreTest.
 * @author Arseniy Kulkiov
 * @since 19.03.2017
 * @version 1
 */
public class UserStoreTest {
    /**
     * Test.
     */
    @Test
    public void test() {
        UserStore us = UserStore.getInstance();
        System.out.println();
    }
    /**
     * Test.
     */
    @Test
    public void test2() {
        User user = new User("Ivan", "van", "asdf@asdf");
        System.out.println(user.getCreateDate());
    }
    /**
     * Test.
     */
    @Test
    public void test3() {
        User user = new User("Ivan", "van", "asdf@asdf");
        UserStore us = UserStore.getInstance();
        us.createUser(user);
    }
    /**
     * Test.
     */
    @Test
    public void test4() {
        User user1 = new User("Ivan", "van", "asdf@asdf");
        User user2 = new User("Dima", "dim", "dim@dim");
        User user3 = new User("Sergey", "sr", "serg@serg");
        User user4 = new User("Pavel", "pav", "pav@pavl");
        User user5 = new User("VanHelsing", "van", "van@hels");
        UserStore us = UserStore.getInstance();
        us.createUser(user1);
        us.createUser(user2);
        us.createUser(user3);
        us.createUser(user4);
        us.updateUser(user5);
        System.out.println(us.getUser("sr"));
        us.deleteUser("dim");
    }
}