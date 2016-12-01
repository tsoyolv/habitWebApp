package com.habit.custom.server.database.model.habit;

import com.habit.custom.server.database.ConnectionWrapper;

import java.sql.Connection;

/**
 * OLTS on 01.12.2016.
 */
public class HabitDao {

    public void create(Habit templateHabit) {
        createByJdbcQuery(templateHabit);
    }

    private void createByJdbcQuery(Habit templateHabit) {
        ConnectionWrapper.exec(new Action() {
            @Override
            public void exec(Connection connection) {

            }
        });
    }
}
