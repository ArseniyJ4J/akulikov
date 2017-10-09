package ru.job4j.collectionspro.orderBook;


import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * BookOrder Class.
 * @author Arseniy Kulikov.
 * @since 03.10.2017.
 * @version 1.
 */
public class OrderBook {
    /**
     * Номер книги заявок.
     */
    private String name;
    /**
     * Контейнер для хранения заявок BUY.
     */
    private Map<Integer, Order> buyContainer;
    /**
     * Контейнер для хранения заявок SELL.
     */
    private Map<Integer, Order> sellContainer;
    /**
     * Контейнер для хранения обработанных зявок BUY.
     */
    private List<Map.Entry<Integer, Order>> buyContainerList;
    /**
     * Контейнер для хранения обработанных заявок SELL.
     */
    private List<Map.Entry<Integer, Order>> sellContainerList;

    /**
     * Геттер для поля класса name.
     * @return - возврат значения.
     */
    public String getName() {
        return name;
    }

    /**
     * Сеттер для поля класса name.
     * @param name - новое значение поля.
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Геттер для поля класса buyContainer.
     * @return - возврат значения.
     */
    public Map<Integer, Order> getBuyContainer() {
        return buyContainer;
    }

    /**
     * Сеттер для поля класса sellContainer.
     * @return - возврат значения.
     */
    public Map<Integer, Order> getSellContainer() {
        return sellContainer;
    }
    /**
     * Геттер для поля класса buyContainerList.
     * @return - возврат значения.
     */
    public List<Map.Entry<Integer, Order>> getBuyContainerList() {
        return buyContainerList;
    }

    /**
     * Сеттер для поля класса butContainerList.
     * @param buyContainerList - новое значения.
     */
    public void setBuyContainerList(List<Map.Entry<Integer, Order>> buyContainerList) {
        this.buyContainerList = buyContainerList;
    }
    /**
     * Геттер для поля класса sellContainerList.
     * @return - возврат значения.
     */
    public List<Map.Entry<Integer, Order>> getSellContainerList() {
        return sellContainerList;
    }

    /**
     * Сеттер для поля класса sellContainerList.
     * @param sellContainerList - новое значение.
     */
    public void setSellContainerList(List<Map.Entry<Integer, Order>> sellContainerList) {
        this.sellContainerList = sellContainerList;
    }

    /**
     * Конструктор.
     * @param name - имя книги.
     */
    public OrderBook(String name) {
        this.name = name;
        this.buyContainer = new HashMap<>(1000000);
        this.sellContainer = new HashMap<>(1000000);
    }

    /**
     * Метод добавления заявки в книгу.
     * @param id - id заявки.
     * @param order - заявка.
     */
    public void add(Integer id, Order order) {
        if (order.getType()) {
            this.buyContainer.put(id, order);
        } else {
            this.sellContainer.put(id, order);
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        OrderBook book = (OrderBook) o;
        return name != null ? name.equals(book.name) : book.name == null;
    }

    @Override
    public int hashCode() {
        return name != null ? name.hashCode() : 0;
    }
}
