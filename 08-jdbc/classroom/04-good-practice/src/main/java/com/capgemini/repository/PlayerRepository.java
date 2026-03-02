package main.java.com.capgemini.repository;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.util.Properties;

public class PlayerRepository {
    private static final Properties properties = new Properties();

    static {
        try (FileInputStream fis = new FileInputStream("/Users/mohammadjaved/Desktop/test/GOOD_PRACTICE/resources/db.properties")) {
            properties.load(fis);
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }


    public static Connection getConnection(){
        try {
            return DriverManager.getConnection(
                    properties.getProperty("db.url"),
                    properties.getProperty("db.username"),
                    properties.getProperty("db.password")
            );
        } catch (Exception e){
            System.out.println(e.getMessage());
            return  null;
        }
    }
}
