package com.habit.custom.server.api.model.jpa;

import javax.persistence.*;

/**
 * OLTS on 26.12.2016.
 */
@Entity
@Table(name = "habit")
public class Habit {

    @Id
    @Column(name = "idhabit")
    private int id;

    @Column(name = "name")
    private String name;

    @Column(name = "score")
    private int score;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }

    @Override
    public String toString() {
        return "Habit{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", score=" + score +
                '}';
    }
}
