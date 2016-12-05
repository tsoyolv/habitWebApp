package com.habit.custom.server.api;

import java.sql.Connection;
import java.sql.SQLException;

/**
 * OLTS on 01.12.2016.
 */

public interface Action<T> {

    T exec(Connection connection) throws SQLException;
}
