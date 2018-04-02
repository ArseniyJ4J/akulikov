package ru.job4j.servlets.crud;

import org.apache.commons.dbcp.BasicDataSource;
import org.apache.log4j.Logger;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

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
    private PreparedStatement ps;
    /**
     * Field Class.
     */
    private ResultSet rs;
    /**
     * Field Class.
     */
    private BasicDataSource dataSource;

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
        dataSource = new BasicDataSource();
        dataSource.setDefaultAutoCommit(false);
        dataSource.setDriverClassName("org.postgresql.Driver");
        dataSource.setUsername("postgres");
        dataSource.setPassword("password");
        dataSource.setUrl("jdbc:postgresql://localhost:5432/users_db");
        dataSource.setMinIdle(5);
        dataSource.setMaxIdle(20);
        dataSource.setMaxOpenPreparedStatements(180);
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
            Connection con = INSTANCE.dataSource.getConnection();
            ps = con.prepareStatement("INSERT INTO users (name, login, email, date_creation) VALUES (?, ?, ?, ?)");
            ps.setString(1, user.getName());
            ps.setString(2, user.getLogin());
            ps.setString(3, user.getEmail());
            ps.setString(4, user.getCreateDate());
            ps.execute();
            con.commit();
            con.close();
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
            Connection con = INSTANCE.dataSource.getConnection();
            ps = con.prepareStatement("UPDATE users SET name=(?), email=(?), date_creation=(?) WHERE login=(?);");
            ps.setString(1, user.getName());
            ps.setString(2, user.getEmail());
            ps.setString(3, user.getCreateDate());
            ps.setString(4, user.getLogin());
            ps.execute();
            con.commit();
            con.close();
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
            Connection con = INSTANCE.dataSource.getConnection();
            ps = con.prepareStatement("SELECT name, login, email, date_creation FROM users WHERE login=(?);");
            ps.setString(1, login);
            rs = ps.executeQuery();
            if (rs.isBeforeFirst()) {
                rs.next();
                user = new User(rs.getString(1), rs.getString(2), rs.getString(3));
            } else {
                LOGGER.info("No such user!");
            }
            con.close();
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
            Connection con = INSTANCE.dataSource.getConnection();
            ps = con.prepareStatement("DELETE FROM users WHERE login=(?)");
            ps.setString(1, login);
            ps.execute();
            con.commit();
            con.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    /**
     * allUsers Method.
     * @return - return statement.
     */
    public List<User> allUsers() {
        List<User> list = new ArrayList<>();
        try {
            Connection con = INSTANCE.dataSource.getConnection();
            ResultSet rs = con.createStatement().executeQuery("SELECT * FROM users;");
            while (rs.next()) {
                String name = rs.getString("name");
                String login = rs.getString("login");
                String email = rs.getString("email");
                String date = rs.getString("date_creation");
                User user = new User(name, login, email, date);
                list.add(user);
            }
            con.commit();
            con.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }
}
