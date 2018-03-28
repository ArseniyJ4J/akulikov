package ru.job4j.jsp.crud;

import org.apache.log4j.Logger;

import java.sql.*;

/** Class UserStore.
 * @author Arseniy Kulkiov
 * @since 19.03.2017
 * @version 1
 */
public enum  UserStore {
    /**
     * Field Class.
     */
    INSTANCE;
    /**
     * Field Class.
     */
    private static final Logger LOGGER = Logger.getLogger(UserStore.class);
    /**
     * Field Class.
     */
    private Connection connection;
    /**
     * Field Class.
     */
    private PreparedStatement ps;
    /**
     * Field Class.
     */
    private ResultSet rs;

    /**
     * Constructor.
     */
    UserStore() {
        this.init();
    }
    /**
     * getInstance method.
     * @return - return statement.
     */
    public static UserStore getInstance() {
        return INSTANCE;
    }
    /**
     * init method.
     */

    private void init() {
        try {
            Class.forName("org.postgresql.Driver");
            connection = DriverManager.getConnection("jdbc:postgresql://localhost:5432/users_db?user=postgres&password=password");
            connection.setAutoCommit(false);
            if (connection != null) {
                connection.createStatement().execute("CREATE TABLE IF NOT EXISTS users (id SERIAL PRIMARY KEY, name VARCHAR(20), login VARCHAR(15) UNIQUE, email VARCHAR (30), date_creation VARCHAR (50));");
                connection.commit();
            } else {
                LOGGER.info("Connect failed!");
            }
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    /**
     * createUser method.
     * @param user - parameter.
     * @return - return statement.
     */
    //POST Method.
    public boolean createUser(User user) {
        boolean result = false;
        try (PreparedStatement prs = this.ps) {
            ps = INSTANCE.connection.prepareStatement("INSERT INTO users (name, login, email, date_creation) VALUES (?, ?, ?, ?)");
            ps.setString(1, user.getName());
            ps.setString(2, user.getLogin());
            ps.setString(3, user.getEmail());
            ps.setString(4, user.getCreateDate());
            ps.execute();
            connection.commit();
//            ps.close();
            result = true;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return result;
    }

    /**
     * updateUser method.
     * @param user - parameter.
     * @return - return statement.
     */
    //PUT Method.
    public boolean updateUser(User user) {
        boolean result = false;
        try (PreparedStatement prs = this.ps) {
            ps = INSTANCE.connection.prepareStatement("UPDATE users SET name=(?), email=(?), date_creation=(?) WHERE login=(?);");
            ps.setString(1, user.getName());
            ps.setString(2, user.getEmail());
            ps.setString(3, user.getCreateDate());
            ps.setString(4, user.getLogin());
            ps.execute();
            connection.commit();
//            ps.close();
            result = true;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return result;
    }

    /**
     * getUser method.
     * @param login - parameter.
     * @return - return statement.
     */
    //GET Method.
    public User getUser(String login) {
        User user = null;
        try (PreparedStatement prs = this.ps; ResultSet rst = this.rs) {
            ps = connection.prepareStatement("SELECT name, login, email, date_creation FROM users WHERE login=(?);");
            ps.setString(1, login);
            rs = ps.executeQuery();
            if (rs.isBeforeFirst()) {
                rs.next();
                user = new User(rs.getString(1), rs.getString(2), rs.getString(3));
            } else {
                LOGGER.info("No such user!");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return user;
    }

    /**
     * deleteUser method.
     * @param login - parameter.
     */
    //DELETE Method.
    public void deleteUser(String login) {
        try (PreparedStatement prs = this.ps) {
            ps = connection.prepareStatement("DELETE FROM users WHERE login=(?)");
            ps.setString(1, login);
            ps.execute();
            connection.commit();
//            ps.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    /**
     * allUsers Method.
     * @return - return statement.
     */
    public ResultSet allUsers() {
        ResultSet rs = null;
        try {
            rs = connection.createStatement().executeQuery("SELECT * FROM users;");
            connection.commit();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return rs;
    }
}
