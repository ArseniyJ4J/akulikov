package ru.job4j.collectionspro.generic.store;

import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertThat;

/** Class RoleStoreTest.
 * @author Arseniy Kulkiov
 * @since 21.08.2017
 * @version 1
 */

public class UserStoreTest {
    /**
     * Test.
     */
    @Test
    public void addUser() {
        User u1 = new User("testU1");
        UserStore us = new UserStore(3);
        us.add(u1);
        assertThat(us.getSa().get(0).equals(u1), is(true));
    }
    /**
     * Test.
     */
    @Test
    public void updateUser() {
        User u1 = new User("testU1");
        User u2 = new User("testU1");
        UserStore us = new UserStore(3);
        us.add(u1);
        us.update(u2);
        assertThat(us.getSa().get(0).equals(u2), is(true));
    }
    /**
     * Test.
     */
    @Test
    public void remove() {
        User u1 = new User("testU1");
        UserStore us = new UserStore(3);
        us.add(u1);
        us.remove(u1);
        assertNull(us.getSa().get(0));
    }
}