package ru.job4j.tracker;

import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
 * Test for tracker.
 * @author Kulikov Arseniy (mailto:arsmail424@gmail.com)
 * @version 1.0
 * @since 1.0
 */
public class TrackerTest {
    /**
     * Test add method.
     */
    @Test
    public void addTest() {
        Tracker tracker = new Tracker();
        Item item = new Item("item1", "Test item for TrackerTest");
        Item result = tracker.add(item);
        Item expect = item;
        assertThat(result, is(expect));
    }

    /**
     * Test update method.
     */
    @Test
    public void updateTest() {
        Tracker tracker = new Tracker();
        Item item = new Item("item0", "Test item for Tracker Test");
        tracker.add(item);
        Item itemUpdate = new Item("itemUpdate", "Test for update method of TrackerTest", item.getId());
        tracker.update(itemUpdate);
        Item[] result = tracker.getItems();
        Item expect = itemUpdate;
        assertThat(result[0], is(expect));
    }
    /**
     * Test update method.
     */
    @Test
    public void updateTest2() {
        Tracker tracker = new Tracker();
        Item item = new Item("item0", "Test item for Tracker Test");
        item.setId("fake");
        boolean result = tracker.update(item);
        assertThat(result, is(false));
    }
    /**
     * Test delete method.
     */
    @Test
    public void deleteTest() {
        Tracker tracker = new Tracker();
        Item item1 = new Item("item0", "Test item for Tracker Test");
        Item item2 = new Item("item1", "Test item for Tracker Test");
        tracker.add(item1);
        tracker.add(item2);
        tracker.delete(item2);
        Item[] result = tracker.getItems();
        Item expect = null;
        assertThat(result[1], is(expect));
    }
    /**
     * Test delete method.
     */
    @Test
    public void deleteTest2() {
        Tracker tracker = new Tracker();
        Item item1 = new Item("item0", "Test item for Tracker Test");
        Item item2 = new Item("item1", "Test item for Tracker Test");
        tracker.add(item1);
        tracker.add(item2);
        Item item3 = new Item("item2", "Test item for Tracker Test");
        boolean result = tracker.delete(item3);
        boolean expect = false;
        assertThat(result, is(expect));
    }
    /**
     * Test findAll method.
     */
    @Test
    public void findAllTest() {
        Tracker tracker = new Tracker();
        Item item1 = new Item("item0", "Test item for Tracker Test");
        Item item2 = new Item("item1", "Test item for Tracker Test");
        tracker.add(item1);
        tracker.add(item2);
        Item[] result = tracker.findAll();
        Item[] expect = {item1, item2};
        assertThat(result, is(expect));
    }
    /**
     * Test findByName method.
     */
    @Test
    public void findByNameTest() {
        Tracker tracker = new Tracker();
        Item item1 = new Item("item0", "Test item for Tracker Test");
        Item item2 = new Item("item1", "Test item for Tracker Test");
        Item item3 = new Item("item1", "Test item for Tracker Test");
        tracker.add(item1);
        tracker.add(item2);
        tracker.add(item3);
        Item[] result = tracker.findByName("item1");
        Item[] expect = {item2, item3};
        assertThat(result, is(expect));
    }
    /**
     * Test findById method.
     */
    @Test
    public void findByIdTest() {
        Tracker tracker = new Tracker();
        Item item1 = new Item("item0", "Test item for Tracker Test", "001");
        Item item2 = new Item("item1", "Test item for Tracker Test", "002");
        Item item3 = new Item("item2", "Test item for Tracker Test", "003");
        tracker.add(item1);
        tracker.add(item2);
        tracker.add(item3);
        Item[] items = tracker.findAll();
        Item result = tracker.findById(items[1].getId());
        Item expect = item2;
        assertThat(result, is(expect));
    }
    /**
     * Test indexFromId method.
     */
    @Test
    public void indexFromIdTest() {
        Tracker tracker = new Tracker();
        Item item1 = new Item("item0", "Test item for Tracker Test");
        Item item2 = new Item("item1", "Test item for Tracker Test");
        Item item3 = new Item("item1", "Test item for Tracker Test");
        tracker.add(item1);
        tracker.add(item2);
        tracker.add(item3);
        //Item[] items = tracker.getItems();
        int result = tracker.indexFromId(item2);
        int expect = 1;
        assertThat(result, is(expect));
    }
    /**
     * Test indexFromId method.
     */
    @Test
    public void indexFromIdTest2() {
        Tracker tracker = new Tracker();
        Item item = new Item("item0", "Test item for Tracker Test");
        item.setId("fake");
        int result = tracker.indexFromId(item);
        assertThat(result, is(-1));
    }


}