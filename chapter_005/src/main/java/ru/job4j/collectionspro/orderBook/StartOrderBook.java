package ru.job4j.collectionspro.orderBook;

import org.xml.sax.SAXException;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Map;


/**
 * StartOrderBookF Class.
 * @author Arseniy Kulikov.
 * @since 03.10.2017.
 * @version 1.
 */
public class StartOrderBook {

    /**
     * Поле класса books.
     */
    private List<OrderBook> books = null;

    /**
     * Метод выполняющий всю обработку заявок.
     * @throws ParserConfigurationException - exception.
     * @throws SAXException - exception.
     * @throws IOException - exception.
     */
    public void start() throws ParserConfigurationException, SAXException, IOException {
        long timeStart = System.currentTimeMillis();
        SAXParserFactory factory = SAXParserFactory.newInstance();
        SAXParser parser = factory.newSAXParser();
        SAXPars saxp = new SAXPars();
        parser.parse("orders.xml", saxp);
        this.books = saxp.getBooks();
        this.sort(this.books);
        this.merge();
        this.sum();
        this.print();
        long timeFinish = System.currentTimeMillis();
        long timeExecution = timeFinish - timeStart;
        System.out.printf("Execution time: %s%n", timeExecution);
    }

    /**
     * Метод сортирующий заявки в книгах.
     * @param books - контенер с книгами заявок.
     */
    private void sort(List<OrderBook> books) {
        for (OrderBook book : this.books) {
            List<Map.Entry<Integer, Order>> buyList = new ArrayList<>(book.getBuyContainer().entrySet());
            book.setBuyContainerList(this.sortComp(buyList));
            List<Map.Entry<Integer, Order>> sellList = new ArrayList<>(book.getSellContainer().entrySet());
            book.setSellContainerList(this.sortComp(sellList));
        }
    }

    /**
     * Метод определяющий порядок сортировки заявок BUY  и заявок SELL.
     * @param list - книги с заявками.
     * @return - возврат значения.
     */
    private List<Map.Entry<Integer, Order>> sortComp(List<Map.Entry<Integer, Order>> list) {
        Collections.sort(list, new Comparator<Map.Entry<Integer, Order>>() {
            @Override
            public int compare(Map.Entry<Integer, Order> o1, Map.Entry<Integer, Order> o2) {
                int result = 0;
                int check = o1.getValue().getType() ? -1 : 1;
                if (o1.getValue().getPrice() > o2.getValue().getPrice()) {
                    result = check;
                } else if (o1.getValue().getPrice() < o2.getValue().getPrice()) {
                    result = check * -1;
                }
                return result;
            }
        });
        return list;
    }

    /**
     * Метод объединяющий заявки с одинаковой ценой.
     */
    private void merge() {
        for (OrderBook book : this.books) {
            for (int i = 0; i < book.getBuyContainerList().size() - 1; i++) {
                Order order = book.getBuyContainerList().get(i).getValue();
                Order orderNext = book.getBuyContainerList().get(i + 1).getValue();
                if (order.getPrice() == orderNext.getPrice()) {
                    order.setVolume(order.getVolume() + orderNext.getVolume());
                    book.getBuyContainerList().remove(i + 1);
                    i--;
                }
            }
            for (int i = 0; i < book.getSellContainerList().size() - 1; i++) {
                Order order = book.getSellContainerList().get(i).getValue();
                Order orderNext = book.getSellContainerList().get(i + 1).getValue();
                if (order.getPrice() == orderNext.getPrice()) {
                    order.setVolume(order.getVolume() + orderNext.getVolume());
                    book.getSellContainerList().remove(i + 1);
                    i--;
                }
            }
        }
    }

    /**
     * Метод сопоставляющий заявки, подходящие по условию сделок.
     */
    private void sum() {
        for (OrderBook book : this.books) {
            boolean check = true;
            while (check) {
                int min = 1;
                for (int i = 0; i < min; i++) {
                    Order buyOrder = book.getBuyContainerList().get(i).getValue();
                    Order sellOrder = book.getSellContainerList().get(i).getValue();
                    double buy = buyOrder.getPrice();
                    double sell = sellOrder.getPrice();
                    if (buy >= sell) {
                        int sub = buyOrder.getVolume() - sellOrder.getVolume();
                        if (sub > 0) {
                            buyOrder.setVolume(sub);
                            book.getSellContainerList().remove(i);
                            i--;
                        } else if (sub < 0) {
                            sellOrder.setVolume(Math.abs(sub));
                            book.getBuyContainerList().remove(i);
                            i--;
                        } else if (sub == 0) {
                            book.getSellContainerList().remove(i);
                            book.getBuyContainerList().remove(i);
                            i--;
                        }
                        min = Math.min(book.getBuyContainerList().size(), book.getSellContainerList().size());
                    } else {
                        check = false;
                        break;
                    }
                }
            }
        }
    }

    /**
     * Метод, выводящий на печать результат обработки заявок.
     */
    private void print() {
        for (OrderBook book : this.books) {
            int max = Math.max(book.getBuyContainerList().size(), book.getSellContainerList().size());
            System.out.printf("OrderF book: %s%n", book.getName());
            System.out.println("    BID          ASK");
            for (int i = 0; i < max; i++) {
                String buy = "--------";
                String sell = "--------";
                if (i < book.getBuyContainerList().size()) {
                    buy = String.format("%s @ %s", book.getBuyContainerList().get(i).getValue().getVolume(), book.getBuyContainerList().get(i).getValue().getPrice());
                }
                if (i < book.getSellContainerList().size()) {
                    sell = String.format("%s @ %s", book.getSellContainerList().get(i).getValue().getVolume(), book.getSellContainerList().get(i).getValue().getPrice());
                }
                System.out.printf("%s   -%s%n", buy, sell);
            }
        }
    }
}