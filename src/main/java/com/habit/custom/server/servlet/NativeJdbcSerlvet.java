package com.habit.custom.server.servlet;

import com.habit.custom.server.WebContext;
import com.habit.custom.server.api.dao.HabitDao;
import org.springframework.cache.Cache;
import org.springframework.cache.CacheManager;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * OLTS on 27.12.2016.
 */
@WebServlet("/nativeJdbc/get")
public class NativeJdbcSerlvet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String habitId = req.getParameter("habit_id");
        HabitDao habitDao = WebContext.<HabitDao>getBean("habitDao");
        resp.getWriter().println(habitDao.get(Integer.parseInt(habitId)));
        CacheManager cacheManager = WebContext.<CacheManager>getBean("cacheManager");
        Cache habitFindCache = cacheManager.getCache("habitFindCache");
        resp.getWriter().println(habitFindCache.getClass());
        Cache.ValueWrapper valueWrapper = habitFindCache.get(39);
        valueWrapper.get();
    }
}
