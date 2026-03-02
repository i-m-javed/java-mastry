package main.java.com.capgemini.dao;


import main.java.com.capgemini.entity.Player;

import java.util.List;

//CRUD: operation

public interface PlayerDAO {
    boolean insertPlayer(Player player);
    List<Player> getAllPlayer();
    boolean updatePlayer(Player player);
    boolean deletePlayer(int playerId);
    Player getPlayer(int id);
}
