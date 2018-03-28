package ru.job4j.jsp.servlets;

import ru.job4j.jsp.crud.User;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/** Class AddServlet.
 * @author Arseniy Kulkiov
 * @since 27.03.2017
 * @version 1
 */
public class AddServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html");
        String name = req.getParameter("name");
        String login = req.getParameter("login");
        String email = req.getParameter("email");
        User user = new User(name, login, email);
        System.out.println(user.toString());
        MenuServlet.USER_STORE.createUser(user);
        RequestDispatcher rd = req.getRequestDispatcher("/pages/addComplete.jsp");
        rd.forward(req, resp);
    }
}
