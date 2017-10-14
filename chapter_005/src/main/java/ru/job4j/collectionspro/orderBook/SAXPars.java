package ru.job4j.collectionspro.orderBook;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

import java.util.ArrayList;
import java.util.List;

/**
 * SAXPars Class.
 * @author Arseniy Kulikov.
 * @since 08.10.2017.
 * @version 1.
 */
public class SAXPars extends DefaultHandler {
    /**
     * Константа AddOrder. Ключ по которому определяется тэг операции добавления в xml файле.
     */
    private static final String ADD_ORDER = "AddOrder";
    /**
     * Константа DeleteOrder. Ключ по которому в xml файле определяется тэг операции удаления заявки.
     */
    private static final String DELETE_ORDER = "DeleteOrder";
    /**
     * Константа BUY. Ключ определяющий тип заявки как BUY.
     */
    private static final String BUY = "BUY";
    /**
     * Константа BOOK. Ключ определяющий атрибут book.
     */
    private static final String BOOK = "book";
    /**
     * Константа orderId. Ключ определяющий атрибут orderId.
     */
    private static final String ORDER_ID = "orderId";
    /**
     * Константа operation. Ключ определяющий атрибут operation.
     */
    private static final String OPERATION = "operation";
    /**
     * Константа price. Ключ определяющий атрибут price.
     */
    private static final String PRICE = "price";
    /**
     * Константа volume. Ключ определяющий атрибут volume.
     */
    private static final String VOLUME = "volume";
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
     * Поле класса element.
     */
    private String element = "";

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
        if (element.equals(ADD_ORDER)) {
            int indexBook = this.checkBook(attr.getValue(BOOK));
            int indexOrder = Integer.parseInt(attr.getValue(ORDER_ID));
            Order order = new Order(
                    attr.getValue(OPERATION).equals(BUY),
                    Double.parseDouble(attr.getValue(PRICE)),
                    Integer.parseInt(attr.getValue(VOLUME))
            );
            books.get(indexBook).add(indexOrder, order);
        } else if (element.equals(DELETE_ORDER)) {
            int indexBook = this.checkBook(attr.getValue(BOOK));
            this.books.get(indexBook).getBuyContainer().remove(Integer.parseInt(attr.getValue(ORDER_ID)));
            this.books.get(indexBook).getSellContainer().remove(Integer.parseInt(attr.getValue(ORDER_ID)));
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
