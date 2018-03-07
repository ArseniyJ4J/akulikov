package ru.job4j.sql.tracker;

import java.io.IOException;
import java.io.InputStream;
import java.sql.*;
import java.util.Properties;

/** Class TrackerDataBase..
 * @author Arseniy Kulkiov
 * @since 07.03.2017
 * @version 2
 */
public class TrackerDataBase {
    /**
     * Class field.
     */
    private Properties prop = new Properties();
    /**
     * Class field.
     */
    private Statement statement;
    /**
     * Class field.
     */
    private Connection connection;
    /**
     * Getter.
     * @return - return statement.
     */
    public Statement getStatement() {
        return statement;
    }

    /**
     * Setter.
     * @param statement - param.
     */
    public void setStatement(Statement statement) {
        this.statement = statement;
    }
    /**
     * Getter.
     * @return - return statement.
     */
    public Properties getProp() {
        return prop;
    }

    /**
     * Setter.
     * @param prop - param.
     */
    public void setProp(Properties prop) {
        this.prop = prop;
    }

    /**
     * Getter.
     * @return - return statement.
     */
    public Connection getConnection() {
        return connection;
    }

    /**
     * Setter.
     * @param connection - connection.
     */
    public void setConnection(Connection connection) {
        this.connection = connection;
    }

    /**
     * Constructor.
     */
    public TrackerDataBase() {
        this.init();
    }

    /**
     * Start method.
     */
    public void start() {
        try {
            Class.forName(prop.getProperty("driveManagerInit"));
            String data = String.format("%s%s", prop.getProperty("connectionData"), prop.getProperty("dbPath"));
            connection = DriverManager.getConnection(data);
            connection.setAutoCommit(false);
            statement = connection.createStatement();
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
    }

    /**
     * first method.
     */
    private void first() {
        String propFileName = "app.properties";
        InputStream inputStream = getClass().getClassLoader().getResourceAsStream(propFileName);
        try {
            prop.load(inputStream);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * checkEmpty method.
     */
    public void checkEmpty() {
        try {
            statement.execute(prop.getProperty("checkItemsQ"));
            statement.execute(prop.getProperty("checkCommentsQ"));
            statement.execute(prop.getProperty("checkDelItemsQ"));
            statement.execute(prop.getProperty("checkDelCommentsQ"));
//            statement.execute("SELECT * FROM sqlite_master where type='table'");
//            System.out.println();
            this.connection.commit();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    /**
     * init method.
     */
    public void init() {
        this.first();
        this.start();
        this.checkEmpty();
    }

    /**
     * main method.
     * @param args - param cmd line.
     */
    public static void main(String[] args) {
        TrackerDataBase tdb = new TrackerDataBase();
//        tdb.init();
        tdb.first();
        tdb.start();
        tdb.checkEmpty();
    }
}
