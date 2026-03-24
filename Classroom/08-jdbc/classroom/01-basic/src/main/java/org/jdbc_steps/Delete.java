package main.java.org.jdbc_steps;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

public class Delete {
    public void deleteData(String sqlQuery){
        CONNECTION db = new CONNECTION();

        try(
                Connection connection = db.connect();
                Statement statement = connection.createStatement();
                ){
            int deleteRow = statement.executeUpdate(sqlQuery);

            if(deleteRow > 0) System.out.println("Row Deleted: "+ deleteRow);
            else {
                System.out.println("No row deleted!!!");
            }
        }catch (SQLException e){
            e.printStackTrace();
        }
    }
}
