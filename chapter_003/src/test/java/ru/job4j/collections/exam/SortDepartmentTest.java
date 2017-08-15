package ru.job4j.collections.exam;

import org.junit.Test;

import static org.junit.Assert.assertThat;
import static org.hamcrest.core.Is.is;

/** Class Класс SortDepartmentTest.
 * @author Arseniy Kulkiov
 * @since 14.08.2017
 * @version 1
 */

public class SortDepartmentTest {
    /**
     * Тест.
     */
    @Test
    public void loadDepartment() {
        SortDepartment sd = new SortDepartment();
        sd.loadDepartment(sd.getEntryData());
        String expected = ", K1\\SK1, K1, K1\\SK2, K1\\SK1\\SSK1, K1\\SK1\\SSK2, K2, K2\\SK1\\SSK1, K2\\SK1, K2\\SK1\\SSK2";
        String result = "";
        for (Department d : sd.getDepartments()) {
            result = String.format("%s, %s", result, d.getDepartment());
        }
        assertThat(result, is(expected));
    }
    /**
     * Тест.
     */
    @Test
    public void ascendingSort() {
        SortDepartment sd = new SortDepartment();
        sd.loadDepartment(sd.getEntryData());
        sd.ascendingSort(sd.getDepartments());
        String expected = ", K1, K1\\SK1, K1\\SK1\\SSK1, K1\\SK1\\SSK2, K1\\SK2, K2, K2\\SK1, K2\\SK1\\SSK1, K2\\SK1\\SSK2";
        String result = "";
        for (Department d : sd.getDepartments()) {
            result = String.format("%s, %s", result, d.getDepartment());
        }
        assertThat(result, is(expected));
    }
    /**
     * Тест.
     */
    @Test
    public void descendingSort() {
        SortDepartment sd = new SortDepartment();
        sd.loadDepartment(sd.getEntryData());
        sd.descendingSort(sd.getDepartments());
        String expected = ", K2, K2\\SK1, K2\\SK1\\SSK2, K2\\SK1\\SSK1, K1, K1\\SK2, K1\\SK1, K1\\SK1\\SSK2, K1\\SK1\\SSK1";
        String result = "";
        for (Department d : sd.getDepartments()) {
            result = String.format("%s, %s", result, d.getDepartment());
        }
        assertThat(result, is(expected));
    }
}