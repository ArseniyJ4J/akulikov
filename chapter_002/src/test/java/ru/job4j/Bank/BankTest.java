package ru.job4j.Bank;

import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
 * Created by Ирина on 18.07.2017.
 */
public class BankTest {

    /**
     * Test.
     */
    @Test
    public void periodsArrayTest() {
        Man[] man = {
                new Man(8, 12),
                new Man(9, 13),
                new Man(10, 14),
                new Man(12, 16),
                new Man(15, 19),
                new Man(15, 20),
        };
        Bank bank = new Bank();
        double[] resultArray = bank.periods(man);
        double[] expectArray = {8, 9, 10, 12, 13, 14, 15, 16, 19, 20};
        assertThat(resultArray, is(expectArray));
    }

    /**
     * Test.
     */
    @Test
    public void resultArrayTest() {
        Man[] man = {
                new Man(8, 12),
                new Man(9, 13),
                new Man(10, 14),
                new Man(12, 16),
                new Man(15, 19),
                new Man(15, 20),
        };
        Bank bank = new Bank();
        double[] resultArray = bank.result(man);
        double[] expectArray = {1, 2, 3, 3, 2, 1, 3, 2, 1};
        assertThat(resultArray, is(expectArray));
    }

    /**
     * Test.
     */
    @Test
    public void outPutTest() {
        Man[] man = {
                new Man(8, 12),
                new Man(9, 13),
                new Man(10, 14),
                new Man(12, 16),
                new Man(15, 19),
                new Man(15, 20),
        };
        Bank bank = new Bank();
        ByteArrayOutputStream out = new ByteArrayOutputStream();
        System.setOut(new PrintStream(out));
        bank.outPut(man);
        String output = out.toString();
        boolean expect = output.contains("Максимальное количество посетителей: 3 в период(ы) времени: 10.0 - 12.0; 12.0 - 13.0; 15.0 - 16.0; ");
        assertThat(expect, is(true));
    }
}
