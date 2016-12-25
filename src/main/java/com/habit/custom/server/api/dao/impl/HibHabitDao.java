package com.habit.custom.server.api.dao.impl;

import com.habit.custom.server.api.dao.HabitDao;
import com.habit.custom.server.api.model.Habit;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.EnableTransactionManagement;

/**
 * OLTS on 25.12.2016.
 */
@Repository("hibHabDao")
@EnableTransactionManagement
public class HibHabitDao implements HabitDao {

    @Autowired
    private SessionFactory sessionFactory;

    public SessionFactory getSessionFactory() {
        return sessionFactory;
    }

    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Override
    public Habit get(int habitId) {
        return getCurrentSession().get(Habit.class, habitId);
    }

    @Override
    public Habit create(Habit templateHabit) {
        return null;
    }

    @Override
    public void delete(int habitId) {

    }

    private Session getCurrentSession() {
        return sessionFactory.getCurrentSession();
    }
}
