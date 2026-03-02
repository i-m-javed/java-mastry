package main.java.org.jdbc_steps;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class PlayerDAO {

    CONNECTION db = new CONNECTION();

    // INSERT
    public void insert(Player player) {

        String sql = "INSERT INTO players(id,name,sports,age) VALUES (?,?,?,?)";

        try(
                Connection connection = db.connect();
                PreparedStatement preparedStatement = connection.prepareStatement(sql);
        ){

            preparedStatement.setInt(1, player.getId());
            preparedStatement.setString(2, player.getName());
            preparedStatement.setString(3, player.getSport());
            preparedStatement.setInt(4, player.getAge());

            int row = preparedStatement.executeUpdate();

            if(row > 0){
                System.out.println("Data Inserted.");
            }else {
                System.out.println("Data Insertion failed.");
            }

        }catch(SQLException e){
            System.out.println(e.getMessage());
        }
    }

    // FETCH ALL
    public List<Player> getAll(){

        List<Player> list = new ArrayList<>();
        String sql = "SELECT * FROM players";

        try(
                Connection con = db.connect();
                PreparedStatement ps = con.prepareStatement(sql);
                ResultSet rs = ps.executeQuery();
        ){

            while(rs.next()){
                Player p = new Player(
                        rs.getInt("id"),
                        rs.getString("name"),
                        rs.getString("sports"),
                        rs.getInt("age")
                );
                list.add(p);
            }

        }catch(SQLException e){
            System.out.println(e.getMessage());
        }

        return list;
    }

    // UPDATE
    public void updateAge(int id,int age){

        String sql = "UPDATE players SET age=? WHERE id=?";

        try(
                Connection con = db.connect();
                PreparedStatement ps = con.prepareStatement(sql);
        ){

            ps.setInt(1, age);
            ps.setInt(2, id);
            ps.executeUpdate();

        }catch(SQLException e){
            System.out.println(e.getMessage());
        }
    }

    // DELETE
    public void delete(int id){

        String sql = "DELETE FROM players WHERE id=?";

        try(
                Connection con = db.connect();
                PreparedStatement ps = con.prepareStatement(sql);
        ){

            ps.setInt(1, id);
            ps.executeUpdate();

            if(ps.execute()){
                System.out.println("data deleted");
            }
            else {
                System.out.println("Data not found");
            }

        }catch(SQLException e){
            System.out.println(e.getMessage());
        }
    }
}