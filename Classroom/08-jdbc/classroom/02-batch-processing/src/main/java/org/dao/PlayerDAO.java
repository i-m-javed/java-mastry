package main.java.org.dao;




import main.java.org.entity.Player;

import java.sql.SQLException;
import java.util.List;

public interface PlayerDAO {
    boolean insertBatch(List<Player> players) throws SQLException;
//    List<Player> fetchAll() throws SQLException;
    boolean updateBatch(List<Player> player)throws SQLException;
    boolean deleteBatch(List<Integer> playerIds)throws SQLException;
}
