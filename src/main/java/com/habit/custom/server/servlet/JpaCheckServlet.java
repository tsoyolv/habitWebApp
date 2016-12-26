package com.habit.custom.server.servlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * OLTS on 26.12.2016.
 */
@WebServlet("/jpaCheck")
public class JpaCheckServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.getWriter().print("For check this: \n" +
                "1 you must uncomment this servlet\n" +
                "2 you must uncomment @Transactional and @PersistenceContext in com.habit.custom.server.api.dao.impl.HabitService" +
                "\n3 you must uncomment jpaTransactionManager in jpaContext.xml");
       /* HabitService habitService = WebContext.<HabitService>getBean("jpaHabitService");
        resp.getWriter().println(habitService.get(2));*/
    }
}
