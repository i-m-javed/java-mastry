package main.java.org.jdbc_steps;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

public class Update {
    public void updateData(String sqlQuery){
        CONNECTION db = new CONNECTION();

        try (
                Connection connection = db.connect();
                Statement statement = connection.createStatement();
                ){
            int updateRow = statement.executeUpdate(sqlQuery);

            if(updateRow > 0) System.out.println("Row updated");
            else System.out.println("No row Updated");

        }catch (SQLException e){
            e.printStackTrace();
        }
    }
}
