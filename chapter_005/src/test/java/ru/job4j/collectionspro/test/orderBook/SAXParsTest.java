package ru.job4j.collectionspro.test.orderBook;

import org.junit.Test;
import org.xml.sax.SAXException;
import ru.job4j.collectionspro.orderBook.StartOrderBook;

import javax.xml.parsers.ParserConfigurationException;

import java.io.IOException;

/**
 * SAXParsTest Class.
 * @author Arseniy Kulikov.
 * @since 08.10.2017.
 * @version 1.
 */
public class SAXParsTest {

    /**
     * Test.
     * @throws IOException - exception.
     * @throws SAXException - exception.
     * @throws ParserConfigurationException - exception.
     */
    @Test
    public void testTwo() throws IOException, SAXException, ParserConfigurationException {
        StartOrderBook start = new StartOrderBook();
        start.start();
        System.out.println();
    }
}