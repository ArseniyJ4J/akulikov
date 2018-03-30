package ru.job4j.jslt.crud;

import org.junit.Test;

import java.util.List;

import static org.junit.Assert.*;

public class UserStoreTest {

    @Test
    public void test() {
        UserStore us = UserStore.getInstance();
        User user1 = new User("1239", "1239", "1239");
        User user2 = new User("123678", "123678", "123678");
        us.createUser(user1);
        us.createUser(user2);
        List<User> list = us.allUsers();
        for (User user : list) {
            System.out.println(user.toString());
        }

    }


}