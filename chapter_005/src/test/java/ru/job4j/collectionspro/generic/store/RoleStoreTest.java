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

public class RoleStoreTest {
    /**
     * Test.
     */
    @Test
    public void addRole() {
        Role r1 = new Role("testU1");
        RoleStore us = new RoleStore(3);
        us.add(r1);
        assertThat(us.getSa().get(0).equals(r1), is(true));
    }
    /**
     * Test.
     */
    @Test
    public void updateRole() {
        Role r1 = new Role("testU1");
        Role r2 = new Role("testU1");
        RoleStore us = new RoleStore(3);
        us.add(r1);
        us.update(r2);
        assertThat(us.getSa().get(0).equals(r2), is(true));
    }
    /**
     * Test.
     */
    @Test
    public void removeRole() {
        Role r1 = new Role("testU1");
        RoleStore us = new RoleStore(3);
        us.add(r1);
        us.remove(r1);
        assertNull(us.getSa().get(0));
    }
}