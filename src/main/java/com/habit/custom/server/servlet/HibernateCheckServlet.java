package com.habit.custom.server.servlet;

import com.habit.custom.server.WebContext;
import com.habit.custom.server.api.dao.HabitDao;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * OLTS on 25.12.2016.
 */
@WebServlet("/hiberCheck")
public class HibernateCheckServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HabitDao hibHabDao = WebContext.<HabitDao>getBean("hibHabDao");
        resp.getWriter().println(hibHabDao.get(1));
    }
}
