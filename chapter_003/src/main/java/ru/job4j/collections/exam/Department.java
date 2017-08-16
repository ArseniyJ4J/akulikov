package ru.job4j.collections.exam;

import java.util.ArrayList;

/** Class Класс Department.
 * @author Arseniy Kulkiov
 * @since 15.08.2017
 * @version 1
 */

public class Department {
    /**
     * Поле класса department - название департамента.
     */
    private String department;
    /**
     * Поле класса code - коллекция содержащая "код" обозначающий место в иерархии департаментов.
     */
    private ArrayList<Integer> code;
    /**
     * Конструктор.
     * @param department - департамент.
     * @param code - код департамента.
     */
    public Department(String department, ArrayList<Integer> code) {
        this.department = department;
        this.code = code;
    }
    /**
     * Геттер для поля department.
     * @return - возврат значения.
     */
    public String getDepartment() {
        return department;
    }
    /**
     * Геттер для поля code.
     * @return - возврат значения.
     */
    public ArrayList<Integer> getCode() {
        return code;
    }
}
