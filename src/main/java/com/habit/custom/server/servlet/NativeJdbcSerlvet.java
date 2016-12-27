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
        CacheManager cacheManager = WebContext.<CacheManager>getBean("cacheManager");
        beforeGet(resp, habitId, cacheManager);
        resp.getWriter().println(habitDao.get(Integer.parseInt(habitId)));
        afterGet(resp, habitId, cacheManager);
    }

    private void beforeGet(HttpServletResponse resp, String habitId, CacheManager cacheManager) throws IOException {
        try {
            resp.getWriter().println("Cache start.\n");
            Cache habitFindCache = cacheManager.getCache("habitFindCache");
            Cache.ValueWrapper valueWrapper = habitFindCache.get(Integer.parseInt(habitId));
            resp.getWriter().println("before obj: " + valueWrapper.get());
        } catch (Exception e) {
            resp.getWriter().println("Cache exception in before");
        }
    }

    private void afterGet(HttpServletResponse resp, String habitId, CacheManager cacheManager) throws IOException {
        Cache habitFindCache = cacheManager.getCache("habitFindCache");
        resp.getWriter().println(habitFindCache.getClass());
        Cache.ValueWrapper valueWrapper = habitFindCache.get(Integer.parseInt(habitId));
        resp.getWriter().println("Cache end.\nCache is working: " + valueWrapper.get());
    }
}
