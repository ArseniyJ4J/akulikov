package ru.job4j.jsp.servlets;

import ru.job4j.jsp.crud.UserStore;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

/** Class MenuServlet.
 * @author Arseniy Kulkiov
 * @since 20.03.2017
 * @version 1
 */
public class MenuServlet extends HttpServlet {
    /**
     * Class field.
     */
    public static final UserStore USER_STORE = UserStore.getInstance();
    /**
     * Class field.
     */
    private List<String> users = new CopyOnWriteArrayList<>();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException {
        ResultSet rs = USER_STORE.allUsers();
        resp.setContentType("text/html");
        PrintWriter writer = null;
        StringBuilder sb = new StringBuilder("<table border='1'>");
        try {
            writer = new PrintWriter(resp.getOutputStream());
            sb.append("<tr>"
                    + "<th>Name:</th>"
                    + "<th>Login:</th>"
                    + "<th>Email:</th>"
                    + "<th>Date creation:</th>"
                    + "<tr>");
            while (rs.next()) {
                String name = rs.getString("name");
                String login = rs.getString("login");
                String email = rs.getString("email");
                String date = rs.getString("date_creation");
                sb.append("<tr>"
                        + "<td>" + name + "</td>"
                        + "<td>" + login + "</td>"
                        + "<td>" + email + "</td>"
                        + "<td>" + date + "</td>"
                        + "<td>"
                            + "<form action='" + req.getContextPath() + "/edit' method='get'>"
                                + "<input type='hidden' name='name' value='" + name + "'>"
                                + "<input type='hidden' name='login' value='" + login + "'>"
                                + "<input type='hidden' name='email' value='" + email + "'>"
                                + "<input type='submit' value='Edit User...'>"
                        + "</form>"
                        + "</td>"
                        + "<td>"
                            + "<form action='" + req.getContextPath() + "/delete' method='post'>"
                                + "<input type='hidden' name='name' value='" + name + "'>"
                                + "<input type='hidden' name='login' value='" + login + "'>"
                                + "<input type='hidden' name='email' value='" + email + "'>"
                                + "<input type='submit' value='Delete User'>"
                            + "</form>"
                        + "</td>"
                        + "</tr>");
            }
            sb.append("</table>");
        } catch (IOException | SQLException e) {
            e.printStackTrace();
        }

        writer.append("<!DOCTYPE html>"
                + "<html lang=\"en\">"
                + "<head>"
                + "    <meta charset=\"UTF-8\">"
                + "    <title></title>"
                + "</head>"
                + "<body>"
                + "</br>"
                + ""
                + sb.toString()
                + "</br>"
                + "<form action='" + req.getContextPath() + "/add' method='get'>"
                + "<input type='submit' value='Add new User...'>"
                + "</form>"
                + "</body>"
                + "</html>");
        writer.flush();
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html");
        this.users.add(req.getParameter("login"));
        doGet(req, resp);
    }
}
