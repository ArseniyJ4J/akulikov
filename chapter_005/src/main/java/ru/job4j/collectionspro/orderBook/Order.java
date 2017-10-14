package ru.job4j.collectionspro.orderBook;

/**
 * OrderF Class.
 * @author Arseniy Kulikov.
 * @since 03.10.2017
 * @version 1
 */
public class Order implements Comparable<Order> {
    /**
     * Тип заявки (OrderF).
     * Eсли покупка (sell или ask), то FALSE.
     * Если продажа (bid или buy), то TRUE.
     */
    private boolean type;
    /**
     * Цена покупки\продажи.
     */
    private Double price;
    /**
     * Объем сделки.
     */
    private int volume;

    /**
     * Геттер для поля класса type.
     * @return - возврат значения.
     */
    public boolean getType() {
        return type;
    }

    /**
     * Геттер для поля класса price.
     * @return - возврат значения.
     */
    public double getPrice() {
        return price;
    }

    /**
     * Геттер для поля класса volume.
     * @return - возврат значения.
     */
    public int getVolume() {
        return volume;
    }

    /**
     * Сеттер для поля класса volume.
     * @param volume - новое значения volume.
     */
    public void setVolume(int volume) {
        this.volume = volume;
    }

    /**
     * Конструктор.
     * @param type - тип.
     * @param price - цена.
     * @param volume - объем.
     */
    public Order(boolean type, Double price, int volume) {
        this.type = type;
        this.price = price;
        this.volume = volume;
    }

    /**
     * @param o the object to be compared.
     * @return a negative integer, zero, or a positive integer as this object
     * is less than, equal to, or greater than the specified object.
     * @throws NullPointerException if the specified object is null
     * @throws ClassCastException   if the specified object's type prevents it
     *                              from being compared to this object.
     */
    @Override
    public int compareTo(Order o) {
        return this.price.compareTo(o.getPrice());
    }
}
