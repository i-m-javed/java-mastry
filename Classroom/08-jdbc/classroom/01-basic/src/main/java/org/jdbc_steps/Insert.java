package main.java.org.jdbc_steps;

import java.sql.*;

public class Insert {

    public void insertData(String sqlQuery) {

        CONNECTION db = new CONNECTION();

        try(
                Connection con = db.connect();
                Statement statement = con.createStatement();
        ) {

            int rows = statement.executeUpdate(sqlQuery);
            System.out.println("Successfully inserted!!!");

        } catch (SQLException e){

            if("23505".equals(e.getSQLState())) {
                System.out.println("Data Exists!!!!");
            } else {
                System.out.println(e.getSQLState());
            }
        }
    }
}