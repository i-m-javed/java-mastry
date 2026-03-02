package main.java.org.example;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class CONNECTION {

    public Connection connect() throws SQLException {

        String url = "jdbc:postgresql://localhost:5432/Company";
        String username = "mohammadjaved";
        String password = "12345";

        return DriverManager.getConnection(url, username, password);

    }
}
