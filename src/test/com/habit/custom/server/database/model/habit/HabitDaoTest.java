package com.habit.custom.server.database.model.habit;

import com.habit.custom.server.api.dao.HabitDao;
import com.habit.custom.server.api.model.Habit;
import junit.framework.TestCase;

import java.util.Random;

public class HabitDaoTest extends TestCase {

    protected Habit habitTemplate;

    @Override
    public void setUp() throws Exception {
        habitTemplate = new Habit();
        habitTemplate.setName(generateName());
        habitTemplate.setScore(generateScore());
    }

    private int generateScore() {
        return 1;
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
        HabitDao habitDao = new HabitDao();
        Habit createdHabit = habitDao.create(habitTemplate);
        Habit retrievedHabit = habitDao.get(createdHabit.getId());
        System.out.println("Hi");
        assertTrue(createdHabit.equals(retrievedHabit));
    }
}