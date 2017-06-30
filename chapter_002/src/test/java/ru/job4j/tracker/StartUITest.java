package ru.job4j.tracker;

import org.junit.Assert;
import org.junit.Test;

import java.util.Scanner;

import static org.hamcrest.core.Is.is;


/** Class Класс StartUITest.
 * @author Arseniy Kulkiov
 * @since 26.06.2017
 * @version 1
 */
public class StartUITest {
    /**
     * Test add method.
     */
    @Test
    public void addTest() {
        Tracker tracker = new Tracker();
        Input input = new StubInput(new String[] {"0", "test name", "desc", "6"});
        new StartUi(input, tracker).init();
        Assert.assertThat(tracker.getItems()[0].getName(), is("test name"));
        Assert.assertThat(tracker.getItems()[0].getDesc(), is("desc"));
    }
    /**
     * Test add method.
     */
    @Test
    public void showTest() {
        Tracker tracker = new Tracker();
        Input input = new StubInput(new String[] {"0", "test name 1", "desc 1", "0", "test name 2", "desc2", "1", "6"});
        new StartUi(input, tracker).init();
        Assert.assertThat(tracker.getItems()[0].getName(), is("test name 1"));
        Assert.assertThat(tracker.getItems()[0].getDesc(), is("desc 1"));
        Assert.assertThat(tracker.getItems()[1].getName(), is("test name 2"));
        Assert.assertThat(tracker.getItems()[1].getDesc(), is("desc2"));
    }
    /**
     * Test edit method.
     */
    @Test
    public void editTest() {
        Tracker tracker = new Tracker();
        Item item = tracker.add(new Item("name 0", "desc 0"));
        Input input = new StubInput(new String[] {"2", item.getId(), "name edited", "desc edited", "6"});
        new StartUi(input, tracker).init();
        Assert.assertThat(tracker.getItems()[0].getName(), is("name edited"));
        Assert.assertThat(tracker.getItems()[0].getDesc(), is("desc edited"));
    }
    /**
     * Test edit method.
     */
    @Test
    public void deleteTest() {
        Tracker tracker = new Tracker();
        Item item = tracker.add(new Item("name 0", "desc 0"));
        Input input = new StubInput(new String[] {"3", item.getId(), "6"});
        new StartUi(input, tracker).init();
        String a = null;
        Assert.assertThat(tracker.getItems()[0], is(a));
    }
}
