package main.java.org.dao;

import main.java.org.entity.Player;
import main.java.org.repository.PlayerRepo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

public class PlayerDAOImpl implements PlayerDAO{
    @Override
    public boolean insertBatch(List<Player> players) throws SQLException {

        String sql = "INSERT INTO players(playername, playercountry) values (?, ?)";
        Connection connection = PlayerRepo.getConnection();
        PreparedStatement preparedStatement = connection.prepareStatement(sql);

        for(Player p : players){
            preparedStatement.setString(1, p.getPlayerName());
            preparedStatement.setString(2, p.getPlayerCountry());
            preparedStatement.addBatch();
        }

        int[] result = preparedStatement.executeBatch();
        System.out.println("Inserted Rows: "+ result.length);
        connection.close();


        return result.length > 0;
    }

//
//    @Override
//    public List<Player> fetchAll()throws SQLException {
//        return List.of(null);
//    }

    @Override
    public boolean updateBatch(List<Player> player) throws SQLException{
        String sql = "UPDATE players SET playername = ? , playercountry = ? Where playerid=?";

        Connection connection = PlayerRepo.getConnection();

        PreparedStatement preparedStatement = connection.prepareStatement(sql);

        for(Player p: player){
            preparedStatement.setString(1, p.getPlayerName());
            preparedStatement.setString(2, p.getPlayerCountry());
            preparedStatement.setInt(3, p.getPlayerId());
            preparedStatement.addBatch();
        }

        int[] result = preparedStatement.executeBatch();
        System.out.println("Updated Rows: "+result.length);

        connection.close();
        return result.length > 0;
    }

    @Override
    public boolean deleteBatch(List<Integer> playerIds) throws SQLException{
        return false;
    }
}
