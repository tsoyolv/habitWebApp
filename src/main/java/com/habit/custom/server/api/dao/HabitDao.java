package com.habit.custom.server.api.dao;

import com.habit.custom.server.api.model.Habit;

/**
 * OLTS on 21.12.2016.
 */
public interface HabitDao {

    Habit get(int habitId);

    Habit create(Habit templateHabit);

    void delete(int habitId);
}
