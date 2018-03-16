package ru.job4j.sql.jsouparsing;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

/** JsoupDataBase.
 * @author Arseniy Kulkiov
 * @since 16.03.2017
 * @version 1
 */
public class JsoupDataBase {
    /**
     * Class field.
     */
    private Properties prop;
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
     * @return - retern statement.
     */
    public Statement getStatement() {
        return statement;
    }

    /**
     * Setter.
     * @param statement - parameter.
     */
    public void setStatement(Statement statement) {
        this.statement = statement;
    }
    /**
     * Getter.
     * @return - retern statement.
     */
    public Connection getConnection() {
        return connection;
    }
    /**
     * Setter.
     * @param connection - parameter.
     */
    public void setConnection(Connection connection) {
        this.connection = connection;
    }

    /**
     * Constructor.
     * @param prop - parameter.
     */
    public JsoupDataBase(Properties prop) {
        this.prop = prop;
        this.init();
    }

    /**
     * inint method.
     */
    public void init() {
        try {
            Class.forName(prop.getProperty("driveManagerInit"));
            String data = String.format("%s%s", prop.getProperty("connectionData"), prop.getProperty("dbPath"));
            connection = DriverManager.getConnection(data);
            connection.setAutoCommit(false);
            statement = connection.createStatement();
            statement.execute(prop.getProperty("checkAuthorQ"));
            statement.execute(prop.getProperty("checkVacanciesQ"));
            statement.execute(prop.getProperty("checkDelAuthorQ"));
            statement.execute(prop.getProperty("checkDelVacanciesQ"));
            this.connection.commit();
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
    }
}

