package com.habit.custom.server.servlet;

import com.habit.custom.knowledges.Knowledge;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 *  OLTS on 29.11.2016.
 */
@WebServlet("/knowledge")
public class KnowledgeServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Knowledge k = new Knowledge();
        resp.getWriter().print(k.find());
    }
}
