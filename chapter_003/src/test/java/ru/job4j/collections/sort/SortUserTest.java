package ru.job4j.collections.sort;

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
    public void sortUserAgeTest() {
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
    /**
     * Test for SortUser Class.
     */
    @Test
    public void sortUserNameLengthTest() {
        List<User> list = new LinkedList<>();
        list.add(new User("Archibald", 25));
        list.add(new User("Aleksey", 19));
        list.add(new User("Sergey", 27));
        list.add(new User("Boris", 21));
        SortUser su = new SortUser();
        List<User> result = su.sortNameLength(list);
        ByteArrayOutputStream out = new ByteArrayOutputStream();
        System.setOut(new PrintStream(out));
        for (User user : result) {
            System.out.printf("%s ", user.getName());
        }
        String expect = "Boris Sergey Aleksey Archibald ";
        assertThat(out.toString(), is(expect));
    }
    /**
     * Test for SortUser Class.
     */
    @Test
    public void sortUserByAllFieldsTest() {
        List<User> list = new LinkedList<>();
        list.add(new User("Archibald", 25));
        list.add(new User("Aleksey", 19));
        list.add(new User("Sergey", 27));
        list.add(new User("Boris", 21));
        list.add(new User("Aleksey", 27));
        SortUser su = new SortUser();
        List<User> result = su.sortByAllField(list);
        ByteArrayOutputStream out = new ByteArrayOutputStream();
        System.setOut(new PrintStream(out));
        for (User user : result) {
            System.out.printf("%s, %s; ", user.getName(), user.getAge());
        }
        String expect = "Aleksey, 19; Aleksey, 27; Archibald, 25; Boris, 21; Sergey, 27; ";
        assertThat(out.toString(), is(expect));
    }
}
