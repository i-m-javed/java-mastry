package main.java.callable_and_storedprocedure;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class EmployeeService {
    public boolean insertEmployee(String name, double salary) {
        String sql = "{CALL insertEmployee(?, ?)}";
        try (
                Connection connection = DatabaseUtil.getConnection();
                CallableStatement statement = connection.prepareCall(sql)
        ) {
            statement.setString(1, name);
            statement.setDouble(2, salary);
            return statement.execute();

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return false;
    }


    public List<Employees> getAllEmployees() {
        String sql = "{CALL getEmployees()}";

        List<Employees> list = new ArrayList<>();

        try (
                Connection connection = DatabaseUtil.getConnection();
                CallableStatement statement = connection.prepareCall(sql)
        ) {
            ResultSet rs = statement.executeQuery();
            while (rs.next()) {
                Employees e = new Employees(
                        rs.getInt("id"),
                        rs.getString("name"),
                        rs.getDouble("sal")
                );

                list.add(e);
            }

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return list;
    }
}
