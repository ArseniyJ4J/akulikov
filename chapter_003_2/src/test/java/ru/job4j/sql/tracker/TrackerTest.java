package ru.job4j.sql.tracker;

import org.junit.Test;
import java.sql.SQLException;
import java.util.List;

/** Class Tracker Test.
 * @author Arseniy Kulkiov
 * @since 07.03.2017
 * @version 2
 */
public class TrackerTest {

    /**
     * Test.
     */
    @Test
    public void test() {
        Item item1 = new Item("First", "First item", "001");
        String[] comments = {"one", "two", "three"};
        item1.setComments(comments);

        Item item2 = new Item("Second", "Second item", "002");
        Item item3 = new Item("Third", "Third item", "003");

        Item itemUpdate = new Item("Update", "Update item", "001");
        String[] commentsUp = {"updateOne", "updateTwo", "updateThree"};
        itemUpdate.setComments(commentsUp);

        Tracker tracker = new Tracker();
        tracker.add(item1);
        tracker.add(item2);
        tracker.add(item3);
        tracker.update(itemUpdate);

    }

    /**
     * Test.
     */
    @Test
    public void test2() {
        Item item1 = new Item("First", "First item", "001");
        String[] comments = {"one", "two", "three"};
        item1.setComments(comments);

        Item item2 = new Item("Second", "Second item", "002");
        Item item3 = new Item("Third", "Third item", "003");

        Tracker tracker = new Tracker();
        tracker.add(item1);
        tracker.add(item2);
        tracker.add(item3);

        tracker.delete(item1);
        tracker.delete(item3);
    }

    /**
     * Test.
     */
    @Test
    public void test3() throws SQLException {
        Item item1 = new Item("First", "First item", "001");
        String[] comments = {"one", "two", "three"};
        item1.setComments(comments);

        Item item2 = new Item("Second", "Second item", "002");
        Item item3 = new Item("Third", "Third item", "003");
        String[] comments3 = {"1", "2"};
        item3.setComments(comments3);

        Tracker tracker = new Tracker();
        tracker.add(item1);
        tracker.add(item2);
        tracker.add(item3);

        List<Item> items = tracker.findAll();

        for (Item item : items) {
            System.out.println(item);
        }
        tracker.tdb.getConnection().close();
    }

    /**
     * Test.
     */
    @Test
    public void test4() throws SQLException {
        Item item1 = new Item("First", "First item", "001");
        String[] comments = {"one", "two", "three"};
        item1.setComments(comments);
        Item item2 = new Item("Second", "Second item", "002");
        Item item3 = new Item("Third", "Third item", "003");
        String[] comments3 = {"1", "2"};
        item3.setComments(comments3);
        Item item4 = new Item("First", "Duplicate", "004");

        Tracker tracker = new Tracker();
        tracker.add(item1);
        tracker.add(item2);
        tracker.add(item3);
        tracker.add(item4);

        List<Item> items = tracker.findByName("First");

        for (Item item : items) {
            System.out.println(item);
        }
        tracker.tdb.getConnection().close();

    }

    /**
     * Test.
     */
    @Test
    public void test5() {
        Item item1 = new Item("First", "First item", "001");
        String[] comments = {"one", "two", "three"};
        item1.setComments(comments);
        Item item2 = new Item("Second", "Second item", "002");
        Item item3 = new Item("Third", "Third item", "003");
        String[] comments3 = {"1", "2"};
        item3.setComments(comments3);
        Item item4 = new Item("First", "Duplicate", "004");

        Tracker tracker = new Tracker();
        tracker.add(item1);
        tracker.add(item2);
        tracker.add(item3);
        tracker.add(item4);

        Item item = tracker.findById("001");
            System.out.println(item);
    }
}