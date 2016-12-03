package com.habit.custom.server.api.dao;

import com.habit.custom.server.api.Action;
import com.habit.custom.server.api.ConnectionWrapper;
import com.habit.custom.server.api.model.Habit;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * OLTS on 01.12.2016.
 */
public class HabitDao {

    public Habit get(int habitId) {
        return ConnectionWrapper.exec(new Action<Habit>() {
            @Override
            public Habit exec(Connection connection) throws SQLException {
                String selectQuery = "SELECT name, score FROM `habitdb`.`habit` WHERE idhabit in (?)";
                PreparedStatement preparedStatement = connection.prepareStatement(selectQuery);
                preparedStatement.setInt(1, habitId);
                ResultSet rs = preparedStatement.executeQuery(selectQuery);
                while (rs.next()) {
                    String name = rs.getString("name");
                    int score = rs.getInt("score");
                    Habit habit = new Habit();
                    habit.setName(name);
                    habit.setScore(score);
                    return habit;
                }
                return null;
            }
        });
    }

    public Habit create(Habit templateHabit) {
        return createByJdbcQuery(templateHabit);
    }

    private Habit createByJdbcQuery(final Habit templateHabit) {
        return ConnectionWrapper.exec(new Action<Habit>() {
            @Override
            public Habit exec(Connection connection) throws SQLException {
                String insertTableSQL = "INSERT INTO `habitdb`.`habit` (name, score) VALUES (?,?)";
                PreparedStatement preparedStatement = connection.prepareStatement(insertTableSQL, PreparedStatement.RETURN_GENERATED_KEYS);
                preparedStatement.setString(1, templateHabit.getName());
                preparedStatement.setInt(2, templateHabit.getScore());
                preparedStatement.executeUpdate();

                ResultSet rs = preparedStatement.getGeneratedKeys();

                if (rs.next()) {
                    // todo create new Habit
                    templateHabit.setId(rs.getInt(1));
                }
                return templateHabit;
            }
        });
    }
}
