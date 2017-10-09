package ru.job4j.collectionspro.orderBook;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * SAXPars Class.
 * @author Arseniy Kulikov.
 * @since 08.10.2017.
 * @version 1.
 */
public class SAXPars extends DefaultHandler {

    /**
     * Поле класса startTime.
     */
    private long startTime;

    /**
     * Поле класса finishTime.
     */
    private long finishTime;

    /**
     * Поле класса books.
     */
    private List<OrderBook> books = new ArrayList<>(10);

    /**
     * Геттер для пола класса books.
     * @return - возврат значения.
     */
    public List<OrderBook> getBooks() {
        return books;
    }

    /**
     * Поле класса book.
     */
    private Map<Integer, OrderBook> book = new HashMap<>();

    /**
     * Поле класса element.
     */
    private String element = "";

    /**
     * Поле класса att.
     */
    private Attributes att = null;

    /**
     * Метод проверки наличия, или (при необходимости) создания книги заявок.
     * @param bookName - имя проверяемой книги.
     * @return - возврат занчения.
     */
    private int checkBook(String bookName) {
        int result = -1;
        boolean isBook = false;
        for (OrderBook value : this.books) {
            if (value.getName().equals(bookName)) {
                result = this.books.indexOf(value);
                isBook = true;
                break;
            }
        }
        if (!isBook) {
            OrderBook book = new OrderBook(bookName);
            this.books.add(book);
            result = this.books.indexOf(book);
        }
        return result;
    }

    @Override
    public void startDocument() throws SAXException {
        System.out.println("Start parse XML...");
        this.startTime = System.currentTimeMillis();
    }

    @Override
    public void startElement(String uri, String localName, String qName, Attributes attr) throws SAXException {
        this.element = qName;
        if (element.equals("AddOrder")) {
            int indexBook = this.checkBook(attr.getValue("book"));
            int indexOrder = Integer.parseInt(attr.getValue("orderId"));
            Order order = new Order(
                    attr.getValue("operation").equals("BUY"),
                    Double.parseDouble(attr.getValue("price")),
                    Integer.parseInt(attr.getValue("volume"))
            );
            books.get(indexBook).add(indexOrder, order);
        } else if (element.equals("DeleteOrder")) {
            int indexBook = this.checkBook(attr.getValue("book"));
            this.books.get(indexBook).getBuyContainer().remove(Integer.parseInt(attr.getValue("orderId")));
            this.books.get(indexBook).getSellContainer().remove(Integer.parseInt(attr.getValue("orderId")));
        }
    }

    @Override
    public void endElement(String uri, String localName, String qName) throws SAXException {
        this.element = "";
    }

    @Override
    public void endDocument() throws SAXException {
        System.out.println("Finish parse XML...");
        this.finishTime = System.currentTimeMillis();
        long executionTime = this.finishTime - this.startTime;
        System.out.printf("Parsing time: %s%n", executionTime);
    }
}
