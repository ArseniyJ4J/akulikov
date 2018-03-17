package ru.job4j.servlets;


import org.apache.log4j.Logger;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/** Class EchoServlet.
 * @author Arseniy Kulkiov
 * @since 17.03.2017
 * @version 1
 */
public class EchoServlet extends HttpServlet {

    /**
     * Field Class.
     */
    private static final Logger LOGGER = Logger.getLogger(EchoServlet.class);

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html");
        PrintWriter writer = new PrintWriter(resp.getOutputStream());
        writer.append("hello world!");
        writer.flush();
    }
}
