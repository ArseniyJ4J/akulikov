package ru.job4j.servlets.servlethtml;

import ru.job4j.servlets.crud.User;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;


/** Class EditServlet.
 * @author Arseniy Kulkiov
 * @since 27.03.2017
 * @version 1
 */
public class EditServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html");
        PrintWriter writer = new PrintWriter(resp.getOutputStream());
        System.out.println(req.getParameter("name"));
        System.out.println(req.getParameter("login"));
        System.out.println(req.getParameter("email"));
        writer.append("<!DOCTYPE html>"
                + "<html lang=\"en\">"
                + "<head>"
                + "    <meta charset=\"UTF-8\">"
                + "    <title></title>"
                + "</head>"
                + "<body>"
                + "<form action='" + req.getContextPath() + "/edit' method='post'>"
                + "<p>Edit User's parameters:</p>"
                + "<p>Name : <input required maxlength='20' type='text' name='name' value='" + req.getParameter("name") + "'></p>"
                + "<p>Login : <input required maxlength='15' type='text' name='login' value='" + req.getParameter("login") + "'></p>"
                + "<p>Email : <input required maxlength='30' type='text' name='email' value='" + req.getParameter("email") + "'></p>"
                + "<input type='hidden' name='oldLogin' value='" + req.getParameter("login") + "'>"
                + "<p><input type='submit' value='Edit'></p>"
                + "</form>"
                + "</body>"
                + "</html>");
        writer.flush();
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html");
        String name = req.getParameter("name");
        String login = req.getParameter("login");
        String email = req.getParameter("email");
        String oldLogin = req.getParameter("oldLogin");
        MenuServlet.USER_STORE.deleteUser(oldLogin);
        User user = new User(name, login, email);
        MenuServlet.USER_STORE.createUser(user);
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
                + "<p><font color='green'>Sucsessfully Edited!</font></p>"
                + "<p><input type='submit' value='To Main Menu...'></p>"
                + "</form>"
                + "</body>"
                + "</html>");
        writer.flush();
    }
}
