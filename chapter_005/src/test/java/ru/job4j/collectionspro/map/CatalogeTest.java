package ru.job4j.collectionspro.map;

import org.junit.Test;

import java.util.Iterator;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertThat;

/**
 * CatalogeTest Class.
 * @author Arseniy Kulkiov
 * @since 26.09.2017
 * @version 1
 */
public class CatalogeTest {
    /**
     * Test.
     */
    @Test
    public void testInsertAndGet() {
        Cataloge cataloge = new Cataloge();
        String key = "1";
        String value = "one";
        boolean insertResult = cataloge.insert(key, value);
        String getResult = (String) cataloge.get("1");
        assertThat(insertResult, is(true));
        assertThat(getResult, is("one"));
    }
    /**
     * Test.
     */
    @Test(expected = NullPointerException.class)
    public void testDelete() {
        Cataloge cataloge = new Cataloge();
        String key = "1";
        String value = "one";
        cataloge.insert(key, value);
        boolean deleteResult = cataloge.delete(key);
        assertThat(deleteResult, is(true));
        assertNull(cataloge.get(key));
    }
    /**
     * Test.
     */
    @Test
    public void testIterator() {
        Cataloge cataloge = new Cataloge();
        cataloge.insert("1", "one");
        cataloge.insert("2", "two");
        cataloge.insert("3", "three");
        Iterator it = cataloge.iterator();
        assertThat(it.hasNext(), is(true));
        assertThat(it.next(), is("one"));
        it.next();
        it.next();
        assertThat(it.hasNext(), is(false));
    }
}





