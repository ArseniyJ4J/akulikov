package ru.job4j.collections.exam;

import org.junit.Test;

import static org.junit.Assert.*;

/** Class Класс SortDepartmentTest.
 * @author Arseniy Kulkiov
 * @since 14.08.2017
 * @version 1
 */

public class SortDepartmentTest {
    @Test
    public void loadDepartment() {
        SortDepartment sd = new SortDepartment();
        sd.loadDepartment(sd.departments);
    }

    @Test
    public void ascendingSort() throws Exception {
    }

    @Test
    public void descendingSort() throws Exception {
    }

}