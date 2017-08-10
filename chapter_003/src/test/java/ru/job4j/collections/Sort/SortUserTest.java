package ru.job4j.collections.Sort;

import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/** Class Класс SortUserTest.
 * @author Arseniy Kulkiov
 * @since 06.08.2017
 * @version 1
 */
public class SortUserTest {
    /**
     * Test for SortUser Class.
     */
    @Test
    public void sortUserTest() {
        List<User> list = new LinkedList<>();
        list.add(new User("Ivan", 21));
        list.add(new User("Oleg", 25));
        list.add(new User("Viktor", 19));
        list.add(new User("Sergey", 27));
        SortUser su = new SortUser();
        Set<User> ts = su.sort(list);
        ByteArrayOutputStream out = new ByteArrayOutputStream();
        System.setOut(new PrintStream(out));
        for (User user : ts) {
            System.out.printf("%s ", user.getAge());
        }
        String expect = "19 21 25 27 ";
        assertThat(out.toString(), is(expect));

    }
}
