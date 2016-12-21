package com.habit.custom.server.database.model.habit;

import com.habit.custom.server.api.dao.impl.SqlHabitDao;
import com.habit.custom.server.api.model.Habit;
import junit.framework.TestCase;

import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

public class SqlHabitDaoTest extends TestCase {

    protected Habit habitTemplate;

    @Override
    public void setUp() throws Exception {
        habitTemplate = new Habit();
        habitTemplate.setName(generateName());
        habitTemplate.setScore(generateScore());
    }

    private int generateScore() {
        return ThreadLocalRandom.current().nextInt(1, 100);
    }

    private String generateName() {
        String ALPHABETS = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        StringBuilder builder = new StringBuilder();
        int i;
        for (i = 0; i < 2; i++) {
            builder.append(ALPHABETS.charAt(generateRandomInRange(0, 25)));
        }
        for (i = 0; i < 3; i++) {
            builder.append(generateRandomInRange(0, 9));
        }
        return builder.toString();
    }

    private int generateRandomInRange(int min, int max) {
        return new Random().nextInt((max - min) + 1) + min;
    }

    public void testCreateHabit() throws Exception {
        SqlHabitDao sqlHabitDao = new SqlHabitDao();
        Habit createdHabit = sqlHabitDao.create(habitTemplate);
        Habit retrievedHabit = sqlHabitDao.get(createdHabit.getId());
        System.out.println("Hi");
        assertTrue(createdHabit.equals(retrievedHabit));
        sqlHabitDao.delete(createdHabit.getId());
    }
}