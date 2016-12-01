package com.habit.custom.server.database.model.habit;

import java.sql.Connection;

/**
 * OLTS on 01.12.2016.
 */
// todo generic
public interface Action {

    void exec(Connection connection);
}
