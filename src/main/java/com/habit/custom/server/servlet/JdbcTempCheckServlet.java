package com.habit.custom.server.servlet;

import com.habit.custom.server.WebContext;
import com.habit.custom.server.api.model.Habit;
import org.apache.commons.dbcp2.BasicDataSource;
import org.springframework.jdbc.core.simple.AbstractJdbcCall;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;
import java.util.Map;

/**
 * OLTS on 25.12.2016.
 */
@WebServlet("/jdbcTCheck")
public class JdbcTempCheckServlet extends HttpServlet {


    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String selectQuery = "SELECT * FROM `habitdb`.`habit`";
        AbstractJdbcCall jdbcCall = WebContext.<AbstractJdbcCall>getBean("jdbcCall");
        List<Map<String, Object>> queryForList = jdbcCall.getJdbcTemplate().queryForList(selectQuery);
        for (Map row : queryForList) {
            Habit habit = new Habit();
            habit.setName((String) (row.get("name")));
            habit.setScore((Integer) row.get("score"));
            habit.setId(Integer.parseInt(row.get("idhabit").toString()));
            resp.getWriter().println(habit);
        }
        //oldCheck(resp);
    }

    private void oldCheck(HttpServletResponse resp) throws IOException {
        try {
            BasicDataSource datasource = WebContext.<BasicDataSource>getBean("dataSource");
            String selectQuery = "SELECT `name`, score FROM `habitdb`.`habit`";
            Statement statement = datasource.getConnection().createStatement();
            ResultSet rs = statement.executeQuery(selectQuery);
            while (rs.next()) {
                String name = rs.getString("name");
                int score = rs.getInt("score");
                Habit habit = new Habit();
                habit.setName(name);
                habit.setScore(score);
                resp.getWriter().println(habit);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
