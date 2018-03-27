package ru.job4j.servlets.servlethtml;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/** Class DeleteServlet.
 * @author Arseniy Kulkiov
 * @since 27.03.2017
 * @version 1
 */
public class DeleteServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doGet(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html");
        String name = req.getParameter("name");
        String login = req.getParameter("login");
        String email = req.getParameter("email");
        MenuServlet.USER_STORE.deleteUser(login);
        PrintWriter writer = new PrintWriter(resp.getOutputStream());
        writer.append("<!DOCTYPE html>"
                + "<html lang=\"en\">"
                + "<head>"
                + "    <meta charset=\"UTF-8\">"
                + "    <title></title>"
                + "</head>"
                + "<body>"
                + "<form action='" + req.getContextPath() + "/menu' method='get'>"
                + "<p>User with parameters:</p>"
                + "<p>Name : " + name + " </p>"
                + "<p>Login : " + login + "</p>"
                + "<p>Email : " + email + "</p>"
                + "<p><font color='red'>Sucsessfully Deleted!</font></p>"
                + "<p><input type='submit' value='To Main Menu...'></p>"
                + "</form>"
                + "</body>"
                + "</html>");
        writer.flush();
    }
}
