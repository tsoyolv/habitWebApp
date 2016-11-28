package com.habit.custom.server.servlet;

import com.habit.custom.server.i18n.Internationalization;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * OLTS on 28.11.2016.
 */

@WebServlet("/dev/refreshLocaleConfig")
public class RefreshLocaleServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Internationalization.getInstance()._devRefreshLocale();
        resp.getWriter().print("Locale refreshed successfully!");
    }
}
