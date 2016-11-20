package com.habit.servlets;

import com.habit.custom.server.i18n.Internationalization;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;

/**
 * Created by Oleg on 20.11.2016.
 */
@WebServlet(loadOnStartup = 0)
public class Localization extends HttpServlet {

    @Override
    public void init() throws ServletException {
        Internationalization i = Internationalization.getInstance();
        i.refreshResources();
        super.init();
    }
}
