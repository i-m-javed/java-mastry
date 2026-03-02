package main.java.com.capgemini.dao;

import main.java.com.capgemini.entity.Player;
import main.java.com.capgemini.repository.PlayerRepository;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class PlayerDAOImplementation implements PlayerDAO{

    @Override
    public boolean insertPlayer(Player player) {

        String sql = "INSERT INTO players(playerName, playerCountry) VALUES (?, ?)";

        try (Connection connection = PlayerRepository.getConnection()) {

            assert connection != null : "Connection failed";
            try (PreparedStatement ps = connection.prepareStatement(sql);
            ) {


                ps.setString(1, player.getPlayerName());
                ps.setString(2, player.getPlayerCountry());
                return ps.executeUpdate() > 0;

            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return false;
    }

    @Override
    public List<Player> getAllPlayer() {
        String sql = "select * from players";
        List<Player> list = new ArrayList<>();

        try (Connection connection = PlayerRepository.getConnection()) {
            assert connection != null : "Connection Failed!";
            try (
                    PreparedStatement preparedStatement = connection.prepareStatement(sql);
                    ResultSet resultSet = preparedStatement.executeQuery()){
                        while (resultSet.next()) {
                            Player p = new Player(
                                    resultSet.getInt("playerid"),
                                    resultSet.getString("playername"),
                                    resultSet.getString("playercountry"));

                            list.add(p);
                        }
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return list;
    }

    @Override
    public boolean updatePlayer(Player player) {

        String sql = "UPDATE players SET playerName=?, playerCountry=? WHERE playerId=?";

        try (Connection connection = PlayerRepository.getConnection()) {

            assert connection != null : "connection Failed!!!";

            try (PreparedStatement preparedStatement = connection.prepareStatement(sql)) {

                preparedStatement.setString(1, player.getPlayerName());
                preparedStatement.setString(2, player.getPlayerCountry());
                preparedStatement.setInt(3, player.getPlayerId());

                int rows = preparedStatement.executeUpdate();

                return rows > 0;
            }

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }

        return false;
    }


    @Override
    public boolean deletePlayer(int playerId) {
        String sql = "Delete from players where playerId =?";

        try(Connection connection = PlayerRepository.getConnection()){
            assert connection != null : "Connection Failed!!!!";
            try(PreparedStatement preparedStatement = connection.prepareStatement(sql)){
                preparedStatement.setInt(1, playerId);
                return preparedStatement.execute();
            }
        }catch (SQLException e){
            System.out.println(e.getMessage());
        }
        return false;
    }


    @Override
    public Player getPlayer(int id) {

        String sql = "SELECT * FROM players WHERE playerId = ?";

        try (Connection connection = PlayerRepository.getConnection()) {

            assert connection != null : "Connection failed!!!!";

            try (PreparedStatement preparedStatement = connection.prepareStatement(sql)) {

                preparedStatement.setInt(1, id);

                try (ResultSet resultSet = preparedStatement.executeQuery()) {

                    if (resultSet.next()) {
                        Player p = new Player();

                        p.setPlayerId(resultSet.getInt("playerId"));
                        p.setPlayerName(resultSet.getString("playerName"));
                        p.setPlayerCountry(resultSet.getString("playerCountry"));

                        return p;
                    }
                }
            }

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }

        return null; // player not found
    }
}
