package ru.job4j.sql.jdbctask;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import javax.xml.stream.XMLOutputFactory;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.XMLStreamWriter;
import javax.xml.transform.*;
import javax.xml.transform.stream.StreamResult;
import javax.xml.transform.stream.StreamSource;
import java.io.*;
import java.sql.*;

/** MainClass.
 * @author Arseniy Kulkiov
 * @since 20.01.2018
 * @version 1
 */

public class MainClass {
    /**
     * Class field.
     */
    private int count;
    /**
     * Class field.
     */
    private long result = 0;
    /**
     * Class field.
     */
    private String dbPath;
    /**
     * Class field.
     */
    private Connection co;
    /**
     * Class field.
     */
    private Statement statm;
    /**
     * Class field.
     */
    private ResultSet resultSet;

    /**
     * Constructor.
     * @param count - N количество.
     * @param dbPath - путь к базе данных.
     */
    public MainClass(int count, String dbPath) {
        this.count = count;
        this.dbPath = dbPath;
    }

    /**
     * Main method.
     * @param args - параметры командной строки.
     * @throws SQLException - исключение.
     */
    public static void main(String[] args) throws SQLException {
        long timeStart = System.currentTimeMillis();
        MainClass mc = new MainClass(1000000, "C:\\projects\\akulikov\\chapter_003_2\\src\\main\\java\\ru\\job4j\\sql\\jdbctask\\Test.db");
        mc.open();
        mc.insert();
        mc.xmlGenerate();
        mc.xmlTransform();
        mc.xmlCount();
        System.out.printf("Result: %s \n", mc.result);
        mc.statm.close();
        mc.resultSet.close();
        mc.close();
        long timeFinish = System.currentTimeMillis();
        long time = timeFinish - timeStart;
        int second = (int) (time / 1000);
        System.out.printf("Execution time (in second): %s seconds \n", second);

    }

    /**
     * Метод создающий (при отсутствии) таблицу TEST в базе данных.
     */
    public void open() {
        try {
            Class.forName("org.sqlite.JDBC");
            String data = String.format("jdbc:sqlite:%s", this.dbPath);
            co = DriverManager.getConnection(data);
            statm = co.createStatement();
            statm.execute("CREATE TABLE IF NOT EXISTS 'TEST' ('FIELD' INTEGER);");
            statm.execute("DELETE FROM TEST;");
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    /**
     * Метод вставляющий N значений в таблицу базы данных.
     */
    public void insert() {
        try {
            co.setAutoCommit(false);
            PreparedStatement pStatm = co.prepareStatement("INSERT INTO TEST (FIELD) VALUES (?);");
            for (int i = 1; i <= count; i++) {
                pStatm.setInt(1, i);
                pStatm.execute();
            }
            co.commit();
            resultSet = statm.executeQuery("SELECT * FROM TEST;");
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    /**
     * Метод создающий файл .xml на основе записей таблицы базы данных.
     */
    public void xmlGenerate() {
        XMLOutputFactory xmlOutputFactory = XMLOutputFactory.newInstance();
        try {
            XMLStreamWriter streamWriter = xmlOutputFactory.createXMLStreamWriter(new FileWriter("C:\\projects\\akulikov\\chapter_003_2\\src\\main\\java\\ru\\job4j\\sql\\jdbctask\\1.xml"));
            streamWriter.writeStartDocument();
            streamWriter.writeStartElement("entries");
            while (resultSet.next()) {
                streamWriter.writeStartElement("entry");
                streamWriter.writeStartElement("field");
                streamWriter.writeCharacters(String.format("%s", resultSet.getInt("FIELD")));
                streamWriter.writeEndElement();
                streamWriter.writeEndElement();
            }
            streamWriter.writeEndElement();
            streamWriter.writeEndDocument();
            streamWriter.flush();
            streamWriter.close();
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (XMLStreamException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * Метод преобразующий "кривой" xml в нормальный.
     */
    public void xmlTransform() {
        TransformerFactory tf = TransformerFactory.newInstance();
        try {
            Source xmlSource = new StreamSource(new FileInputStream("C:\\projects\\akulikov\\chapter_003_2\\src\\main\\java\\ru\\job4j\\sql\\jdbctask\\1.xml"));
            Source xslTrans = new StreamSource(new FileInputStream("C:\\projects\\akulikov\\chapter_003_2\\src\\main\\java\\ru\\job4j\\sql\\jdbctask\\2.xsl"));
            Result xmlOutput = new StreamResult(new FileOutputStream("C:\\projects\\akulikov\\chapter_003_2\\src\\main\\java\\ru\\job4j\\sql\\jdbctask\\2.xml"));

            Transformer transformer = tf.newTransformer(xslTrans);
            transformer.transform(xmlSource, xmlOutput);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (TransformerConfigurationException e) {
            e.printStackTrace();
        } catch (TransformerException e) {
            e.printStackTrace();
        }
    }

    /**
     * Метод складывающий все значения атрибутов field из таблицы xml.
     */
    public void xmlCount() {
        try {
            SAXParserFactory factory = SAXParserFactory.newInstance();
            SAXParser saxParser = factory.newSAXParser();

            DefaultHandler handler = new DefaultHandler() {
                @Override
                public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
                    int index = attributes.getIndex("field");

                    if (index >= 0) {
                        int value = Integer.valueOf(attributes.getValue(index));
                        result = result + value;
                    }
                }
            };
            saxParser.parse(new File("C:\\projects\\akulikov\\chapter_003_2\\src\\main\\java\\ru\\job4j\\sql\\jdbctask\\2.xml"), handler);
        } catch (SAXException e) {
            e.printStackTrace();
        } catch (ParserConfigurationException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * Метод закрывающий все что нужно.
     */
    public void close() {
        try {
            co.close();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }
}
