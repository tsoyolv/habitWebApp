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
        String parameter = req.getParameter(MESSAGE_KEY);
        resp.getOutputStream().print(Internationalization.getInstance().getResource(parameter));
    }
}
