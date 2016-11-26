package com.habit.custom.server.servlet;

import com.habit.custom.server.i18n.Internationalization;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * OLTS on 24.11.2016.
 */


public class InternationalizationServlet extends HttpServlet {

    private static final String MESSAGE_KEY = "messagekey";

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setCharacterEncoding(Internationalization.getCharsetName());
        String parameter = req.getParameter(MESSAGE_KEY);
        String resource = Internationalization.getInstance().getResource(parameter);
        resp.getWriter().print(resource);
    }
}
