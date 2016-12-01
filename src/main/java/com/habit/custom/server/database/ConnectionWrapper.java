package com.habit.custom.server.database;

import com.habit.custom.server.database.model.habit.Action;

import java.sql.Connection;
import java.sql.DriverManager;

/**
 * OLTS on 01.12.2016.
 */
public class ConnectionWrapper {

    public static void exec(Action action) {
        String userName = getUserName();
        String password = getUserPassword();
        String url = getUrlConnection();

        Connection conn = null;
        try {

            Class.forName("com.mysql.cj.jdbc.Driver").newInstance();
            conn = DriverManager.getConnection(url, userName, password);
            action.exec(conn);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (conn != null) {
                try {
                    conn.close();
                    System.out.println("Database connection terminated");
                } catch (Exception e) {
                }
            }
        }
    }

    private static String getUserName() {
        return "root";
    }

    private static String getUserPassword() {
        return "1234";
    }

    private static String getUrlConnection() {
        return "jdbc:mysql://localhost/habitdb" + "?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC";
    }
}
