package com.habit.custom.server.api;

import java.sql.Connection;
import java.sql.DriverManager;

/**
 * OLTS on 01.12.2016.
 */
public class ConnectionWrapper {

    public static <T> T exec(Action<T> action) {
        synchronized (ConnectionWrapper.class) {
            String userName = getUserName();
            String password = getUserPassword();
            String url = getUrlConnection();

            Connection conn = null;
            try {
                Class.forName(getDriverClassName()).newInstance();
                conn = DriverManager.getConnection(url, userName, password);
                return action.exec(conn);
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
        return null;
    }

    private static String getDriverClassName() {
        return "com.mysql.cj.jdbc.Driver";
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
