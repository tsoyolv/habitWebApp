package com.habit.custom.server.servlet.ex;

import com.habit.custom.server.WebContext;
import com.habit.custom.server.api.dao.HabitDao;
import com.habit.custom.server.api.model.Habit;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * OLTS on 04.12.2016.
 */
@WebServlet("/habit/create")
public class HabitServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String email = req.getParameter("email");
        String pass = req.getParameter("pass");
        Habit habit = new Habit();
        habit.setName(email);
        habit.setScore(Integer.parseInt(pass));
        HabitDao habitDao = WebContext.<HabitDao>getBean("habitDao");
        habit = habitDao.create(habit);
        Habit habit1 = habitDao.get(habit.getId());
        if (habit1.equals(habit)) {
            resp.getWriter().println("Creation is succesfully!");
            resp.getWriter().println(habit1);
        } else {
            resp.getWriter().println("Creation failed!");
        }
    }
}
