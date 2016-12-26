package com.habit.custom.server.api.dao.impl;

import com.habit.custom.server.api.model.jpa.Habit;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;

/**
 * OLTS on 26.12.2016.
 */

@Repository("jpaHabitService")
//@Transactional(transactionManager = "jpaTransactionManager")
public class HabitService {

    //@PersistenceContext //  <bean class="org.springframework.orm.jpa.support.PersistenceAnnotationBeanPostProcessor"/>
    private EntityManager em;

    public Habit get(int id) {
        return em.find(Habit.class, id);
    }
}
