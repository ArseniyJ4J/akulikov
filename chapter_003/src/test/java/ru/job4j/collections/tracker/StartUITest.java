package ru.job4j.collections.tracker;

import org.junit.Assert;
import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

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
        Input input = new StubInput(new String[] {"0", "test name", "desc", "n", "6"});
        new StartUi(input, tracker).init();
        Assert.assertThat(tracker.getItems().get(0).getName(), is("test name"));
        Assert.assertThat(tracker.getItems().get(0).getDesc(), is("desc"));
    }
    /**
     * Test add method.
     */
    @Test
    public void showTest() {
        Tracker tracker = new Tracker();
        Input input = new StubInput(new String[] {"0", "test name 1", "desc 1", "n", "0", "test name 2", "desc2", "n", "1", "n", "6"});
        new StartUi(input, tracker).init();
        Assert.assertThat(tracker.getItems().get(0).getName(), is("test name 1"));
        Assert.assertThat(tracker.getItems().get(0).getDesc(), is("desc 1"));
        Assert.assertThat(tracker.getItems().get(1).getName(), is("test name 2"));
        Assert.assertThat(tracker.getItems().get(1).getDesc(), is("desc2"));
    }
    /**
     * Test edit method.
     */
    @Test
    public void editTest() {
        Tracker tracker = new Tracker();
        Item item = tracker.add(new Item("name 0", "desc 0"));
        Input input = new StubInput(new String[] {"2", item.getId(), "name edited", "desc edited", "n", "6"});
        new StartUi(input, tracker).init();
        Assert.assertThat(tracker.getItems().get(0).getName(), is("name edited"));
        Assert.assertThat(tracker.getItems().get(0).getDesc(), is("desc edited"));
    }
    /**
     * Test edit method.
     */
    @Test
    public void deleteTest() {
        Tracker tracker = new Tracker();
        Item item = tracker.add(new Item("name 0", "desc 0"));
        Input input = new StubInput(new String[] {"3", item.getId(), "n", "6"});
        new StartUi(input, tracker).init();
        Item a = null;
        Assert.assertThat(tracker.getItems().get(0), is(a));
    }
    /**
     * Test edit method.
     */
    @Test
    public void menuOutExceptionTest() {
        Tracker tracker = new Tracker();
        Input input = new StubInput(new String[] {"-1", "1", "y"});
        ByteArrayOutputStream out = new ByteArrayOutputStream();
        System.setOut(new PrintStream(out));
        new StartUi(input, tracker).init();
        String output = out.toString();
        boolean expect = output.contains("Please select key from menu.");
        Assert.assertThat(expect, is(true));
    }
    /**
     * Test edit method.
     */
    @Test
    public void numberFormatExceptionTest() {
        Tracker tracker = new Tracker();
        Input input = new StubInput(new String[] {"a", "1", "y"});
        ByteArrayOutputStream out = new ByteArrayOutputStream();
        System.setOut(new PrintStream(out));
        new StartUi(input, tracker).init();
        String output = out.toString();
        boolean expect = output.contains("Please enter validate data again.");
        Assert.assertThat(expect, is(true));
    }
}
