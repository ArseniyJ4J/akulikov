package ru.job4j.multithreading.nonblocking;

import org.junit.Test;
import static org.junit.Assert.assertThat;
import static org.hamcrest.core.Is.is;

/** Class Класс NonBlockingCacheTest.
 * @author Arseniy Kulkiov
 * @since 10.11.2017
 * @version 1
 */
public class NonBlockingCacheTest {

    /**
     * Поле класса.
     */
    private NonBlockingCache nbc = new NonBlockingCache();

    /**
     * Test.
     */
    @Test
    public void addElementTest() {
        nbc.add(new User(1, "User1"));
        nbc.add(new User(4, "User4"));
        nbc.add(new User(5, "User5"));
        nbc.add(new User(7, "User7"));
        assertThat(nbc.size(), is(4));
    }

    /**
     * Test.
     */
    @Test
    public void deleteElementTest() {
        nbc.add(new User(1, "User1"));
        nbc.add(new User(4, "User4"));
        nbc.add(new User(5, "User5"));
        nbc.add(new User(7, "User7"));
        nbc.remove(5);
        assertThat(null, is(nbc.get(5)));
    }

    /**
     * Test.
     */
    @Test
    public void deleteElementTest2() {
        nbc.add(new User(1, "User1"));
        nbc.add(new User(4, "User4"));
        nbc.add(new User(5, "User5"));
        nbc.add(new User(7, "User7"));
        nbc.remove(2);
        assertThat(nbc.size(), is(4));
    }

    /**
     * Test.
     */
    @Test
    public void updateElementTest() {
        User user = new User(5, "User5");
        nbc.add(user);
        User user1 = new User(5, "User005");
        nbc.update(user1);
        assertThat(nbc.get(5), is(user));
    }
}