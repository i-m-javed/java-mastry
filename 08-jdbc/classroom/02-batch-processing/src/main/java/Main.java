package main.java;

import main.java.org.dao.PlayerDAO;
import main.java.org.dao.PlayerDAOImpl;
import main.java.org.entity.Player;

import java.sql.SQLException;
import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args) throws SQLException {

        PlayerDAO dao = new PlayerDAOImpl();

        List<Player> players = Arrays.asList(
                new Player("virat", "india"),
                new Player("Babar", "pakistan"),
                new Player("Joe", "England")
        );

//        if(dao.insertBatch(players)){
//            System.out.println("Players Inserted");
//        }else {
//            System.out.println("Failed to insert");
//        }

        List<Player> players1 = Arrays.asList(
                new Player("Mohammad", "London" ),
                new Player( "Ali", "Canada")
        );

        if(dao.updateBatch(players1)){
            System.out.println("Players details Updated ");
        }else {
            System.out.println("Failed to update");
        }

    }
}
