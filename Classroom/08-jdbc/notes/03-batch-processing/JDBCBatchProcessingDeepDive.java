import java.sql.*;

public class JDBCBatchProcessingDeepDive {

    private static final String URL =
            "jdbc:mysql://localhost:3306/testdb";
    private static final String USER = "root";
    private static final String PASSWORD = "password";

    public static void main(String[] args) {

        insertEmployeesBatch();
    }

    private static void insertEmployeesBatch() {

        String insertQuery =
                "INSERT INTO employee (name, salary) VALUES (?, ?)";

        try (Connection connection =
                     DriverManager.getConnection(URL, USER, PASSWORD);
             PreparedStatement ps =
                     connection.prepareStatement(insertQuery)) {

            connection.setAutoCommit(false); // Start transaction

            for (int i = 1; i <= 5; i++) {

                ps.setString(1, "Employee-" + i);
                ps.setDouble(2, 30000 + i * 1000);

                ps.addBatch();
            }

            int[] results = ps.executeBatch();

            connection.commit();

            System.out.println("Batch executed successfully.");
            System.out.println("Rows affected per statement:");

            for (int result : results) {
                System.out.println(result);
            }

        } catch (SQLException e) {

            System.out.println("Batch Error: " + e.getMessage());
        }
    }
}