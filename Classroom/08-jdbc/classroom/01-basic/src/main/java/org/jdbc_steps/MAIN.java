package main.java.org.jdbc_steps;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class MAIN {
    public static void main(String[] args) throws SQLException {

        {
        //==================INSERT===================
        String sqlQuery1 = "INSERT INTO players VAlUES(1, 'Javed', 'Cricket', 23)";
        Insert i = new Insert();
//        i.insertData(sqlQuery1);


        // ================FETCH======================
        String sqlQuery2 = "Select * from players";
        Fetch f = new Fetch();
//        f.fetchData(sqlQuery2);


        //==================UPDATE====================
        String sqlQuery3 = "UPDATE players set age = 24 where id = 1";
        Update u = new Update();
//        u.updateData(sqlQuery3);


        // =================DELETE====================
        String sqlQuery4 = "DELETE FROM players where id = 1";
        Delete d = new Delete();
//        d.deleteData(sqlQuery4);

        }

        //=============PREPARED STATEMENT=========

        PlayerDAO dao = new PlayerDAO();

        // Insert
//        dao.insert(new Player(2, "raj", "Tennis", 26));

        // Read
        List<Player>  players = new ArrayList<>();
        players = dao.getAll();

        if(!players.isEmpty()){
            for(Player p : players){
                System.out.println("Id :"+ p.getId());
                System.out.println("Name :"+p.getName());
                System.out.println("Sport :"+ p.getSport());
                System.out.println("Age :" + p.getAge());
            }
        }else {
            System.out.println("No data found!");
        }



//        dao.delete(1);



    }
}
