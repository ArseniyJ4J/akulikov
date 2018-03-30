package ru.job4j.jslt.servlets;

import ru.job4j.jslt.crud.UserStore;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/** Class MenuServlet.
 * @author Arseniy Kulkiov
 * @since 20.03.2017
 * @version 1
 */
public class MenuServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException {
        try {
            req.setAttribute("users", UserStore.getInstance().allUsers());
            req.getRequestDispatcher("/WEB-INF/views/start_page.jsp").forward(req, resp);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    }
}
