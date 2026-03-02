import java.sql.*;

public class JDBCTransactions{

    private static final String URL =
            "jdbc:mysql://localhost:3306/testdb";
    private static final String USER = "root";
    private static final String PASSWORD = "password";

    public static void main(String[] args) {

        transferMoney(1, 2, 500);
    }

    private static void transferMoney(int fromAccount,
                                      int toAccount,
                                      double amount) {

        String debitQuery =
                "UPDATE accounts SET balance = balance - ? WHERE id = ?";
        String creditQuery =
                "UPDATE accounts SET balance = balance + ? WHERE id = ?";

        try (Connection connection =
                     DriverManager.getConnection(URL, USER, PASSWORD)) {

            connection.setAutoCommit(false); // Start transaction

            try (PreparedStatement debitStmt =
                         connection.prepareStatement(debitQuery);
                 PreparedStatement creditStmt =
                         connection.prepareStatement(creditQuery)) {

                // Debit
                debitStmt.setDouble(1, amount);
                debitStmt.setInt(2, fromAccount);
                debitStmt.executeUpdate();

                // Simulate failure for demonstration
                if (amount > 1000) {
                    throw new RuntimeException("Simulated failure");
                }

                // Credit
                creditStmt.setDouble(1, amount);
                creditStmt.setInt(2, toAccount);
                creditStmt.executeUpdate();

                connection.commit();
                System.out.println("Transaction committed successfully.");

            } catch (Exception e) {

                connection.rollback();
                System.out.println("Transaction rolled back: " + e.getMessage());
            }

        } catch (SQLException e) {
            System.out.println("SQL Error: " + e.getMessage());
        }
    }
}