package main.java.org.jdbc_steps;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class CONNECTION {

    public Connection connect() throws SQLException {

        String url = "jdbc:postgresql://localhost:5432/JDBC";
        String username = "mohammadjaved";
        String password = null;

        return DriverManager.getConnection(url, username, password);
    }
}
