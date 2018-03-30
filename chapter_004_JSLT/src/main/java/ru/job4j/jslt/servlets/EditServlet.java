package ru.job4j.jslt.servlets;

import ru.job4j.jslt.crud.User;
import ru.job4j.jslt.crud.UserStore;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/** Class EditServlet.
 * @author Arseniy Kulkiov
 * @since 27.03.2017
 * @version 1
 */
public class EditServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html");
        RequestDispatcher rd = req.getRequestDispatcher("/WEB-INF/views/edit.jsp");
        rd.forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html");
        String name = req.getParameter("name");
        String login = req.getParameter("login");
        String email = req.getParameter("email");
        String oldLogin = req.getParameter("oldLogin");
        UserStore.getInstance().deleteUser(oldLogin);
        User user = new User(name, login, email);
        UserStore.getInstance().createUser(user);
        RequestDispatcher rd = req.getRequestDispatcher("/WEB-INF/views/editComplete.jsp");
        rd.forward(req, resp);
    }
}