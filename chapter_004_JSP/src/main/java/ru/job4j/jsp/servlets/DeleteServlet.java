package ru.job4j.jsp.servlets;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

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
        String login = req.getParameter("login");
        MenuServlet.USER_STORE.deleteUser(login);
        RequestDispatcher rd = req.getRequestDispatcher("/pages/delete.jsp");
        rd.forward(req, resp);
    }
}
