package com.habit.custom.server.api.action;

import com.habit.custom.server.api.Action;

import java.sql.Connection;
import java.sql.SQLException;

/**
 * OLTS on 05.12.2016.
 */
public class SqlCreateAction<T> implements Action<T> {


    @Override
    public T exec(Connection connection) throws SQLException {
        return null;
    }
}
