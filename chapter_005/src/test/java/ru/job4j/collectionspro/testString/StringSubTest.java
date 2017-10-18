package ru.job4j.collectionspro.testString;

import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
 * StringSubTest Class.
 * @author Arseniy Kulikov.
 * @since 15.10.2017.
 * @version 1.
 */
public class StringSubTest {

    /**
     * Test.
     */
    @Test
    public void test() {
        StringSub ss = new StringSub();
        assertThat(ss.compareString("ask", "kas"), is(true));
        assertThat(ss.compareString("ask", "sak"), is(true));
        assertThat(ss.compareString("kAs", "Aks"), is(true));
        assertThat(ss.compareString("kaa", "saa"), is(false));
        assertThat(ss.compareString("ask", "Ask"), is(false));
        assertThat(ss.compareString("Xd", "Nn"), is(false));
    }

    /**
     * Test.
     */
    @Test
    public void test2() {
        String symbols = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZабвгдеёжзийклмнопрстуфхцчшщъыьэюяАБВГДЕЁЖЗИЙКЛМНОПРСТУФХЦЧШЩЪЫЬЭЮЯ0123456789";
        for (int i = 0; i < symbols.length(); i++) {
            Character value = symbols.charAt(i);
            System.out.printf("Symbol: %s - %s HashCode.%n", value, value.hashCode());
        }
    }
}