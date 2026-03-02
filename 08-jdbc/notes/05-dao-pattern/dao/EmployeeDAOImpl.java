package dao;

import entity.Employee;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

// =======================
// DAO IMPLEMENTATION
// =======================
public class EmployeeDAOImpl implements EmployeeDAO {

    private static final String URL =
            "jdbc:mysql://localhost:3306/db";
    private static final String USER = "username";
    private static final String PASSWORD = "password";

    @Override
    public void save(Employee employee) {

        String query =
                "INSERT INTO employee (id, name, salary) VALUES (?, ?, ?)";

        try (Connection con =
                     DriverManager.getConnection(URL, USER, PASSWORD);
             PreparedStatement ps =
                     con.prepareStatement(query)) {

            ps.setInt(1, employee.getId());
            ps.setString(2, employee.getName());
            ps.setDouble(3, employee.getSalary());

            ps.executeUpdate();

        } catch (SQLException e) {
            System.out.println("Save Error: " + e.getMessage());
        }
    }

    @Override
    public Employee findById(int id) {

        String query =
                "SELECT id, name, salary FROM employee WHERE id = ?";

        try (Connection con =
                     DriverManager.getConnection(URL, USER, PASSWORD);
             PreparedStatement ps =
                     con.prepareStatement(query)) {

            ps.setInt(1, id);

            try (ResultSet rs = ps.executeQuery()) {

                if (rs.next()) {
                    return new Employee(
                            rs.getInt("id"),
                            rs.getString("name"),
                            rs.getDouble("salary")
                    );
                }
            }

        } catch (SQLException e) {
            System.out.println("Find Error: " + e.getMessage());
        }

        return null;
    }

    @Override
    public List<Employee> findAll() {

        List<Employee> employees = new ArrayList<>();

        String query = "SELECT id, name, salary FROM employee";

        try (Connection con =
                     DriverManager.getConnection(URL, USER, PASSWORD);
             PreparedStatement ps =
                     con.prepareStatement(query);
             ResultSet rs = ps.executeQuery()) {

            while (rs.next()) {
                employees.add(
                        new Employee(
                                rs.getInt("id"),
                                rs.getString("name"),
                                rs.getDouble("salary")
                        )
                );
            }

        } catch (SQLException e) {
            System.out.println("FindAll Error: " + e.getMessage());
        }

        return employees;
    }

    @Override
    public void delete(int id) {

        String query = "DELETE FROM employee WHERE id = ?";

        try (Connection con =
                     DriverManager.getConnection(URL, USER, PASSWORD);
             PreparedStatement ps =
                     con.prepareStatement(query)) {

            ps.setInt(1, id);
            ps.executeUpdate();

        } catch (SQLException e) {
            System.out.println("Delete Error: " + e.getMessage());
        }
    }
}
