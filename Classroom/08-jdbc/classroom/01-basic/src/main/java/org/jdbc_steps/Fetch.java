package main.java.org.jdbc_steps;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Fetch {
    public void fetchData(String sqlQuery){
        CONNECTION db = new CONNECTION();

        try(
                Connection connection = db.connect();
                Statement statement = connection.createStatement();
                ) {

            ResultSet resultSet = statement.executeQuery(sqlQuery);

            if(resultSet.next()){

                do{
                    int id = resultSet.getInt("id");
                    String name = resultSet.getString("name");
                    String sport = resultSet.getString("sports");
                    int age = resultSet.getInt("age");

                    System.out.println("ID: " + id);
                    System.out.println("Name: "+ name);
                    System.out.println("Age: "+ age);
                    System.out.println("Sport: " +sport);

                }while(resultSet.next());

            }else{
                System.out.println("No data found");
            }



        }catch (SQLException e){
            e.printStackTrace();
        }
    }
}
