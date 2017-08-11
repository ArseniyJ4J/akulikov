package ru.job4j.collections.bank;
/** Class Класс Account.
 * @author Arseniy Kulkiov
 * @since 11.08.2017
 * @version 1
 */
public class Account {
    /**
     * Поле класса value - сумма на счету.
     */
    private double value;
    /**
     * Поле класса requisites - реквизиты счета.
     */
    private int requisites;
    /**
     * Конструктор.
     *
     * @param value      - сумма на счету.
     * @param requisites - реквизиты счета.
     */
    public Account(double value, int requisites) {
        this.value = value;
        this.requisites = requisites;
    }
    /**
     * Герре дла value.
     *
     * @return - возврат значения.
     */
    public double getValue() {
        return this.value;
    }
    /**
     * Сеттер для value.
     *
     * @param value - новая сумма на счету.
     */
    public void setValue(double value) {
        this.value = value;
    }
}
