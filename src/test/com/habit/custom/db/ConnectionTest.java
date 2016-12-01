package com.habit.custom.db;

import org.junit.Test;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

/**
 * OLTS on 23.11.2016.
 */
public class ConnectionTest {

    @Test
    public void test() {
        String query = "select * from user";
        Connection conn = null;
        try {
            String userName = "root";
            String password = "1234";
            String url = "jdbc:mysql://localhost/habitdb" + "?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC";
            Class.forName("com.mysql.cj.jdbc.Driver").newInstance();
            conn = DriverManager.getConnection(url, userName, password);
            Statement stmt;
            ResultSet rs;
            stmt = conn.createStatement();

            // executing SELECT query
            rs = stmt.executeQuery(query);

            while (rs.next()) {
                String count = rs.getString(2);
                System.out.println("s" + count);
            }
            System.out.println("Database connection established");
        } catch (Exception e) {
            System.err.println("Cannot connect to database server");
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
}
