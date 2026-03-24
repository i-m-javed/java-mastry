import java.sql.*;

public class StatementVsPreparedStatement {

    private static final String URL =
            "jdbc:mysql://localhost:3306/testdb";
    private static final String USER = "root";
    private static final String PASSWORD = "password";

    public static void main(String[] args) {

        String userInput = "' OR '1'='1"; // Simulated malicious input

        System.out.println("=== Using Statement (Vulnerable) ===");
        executeWithStatement(userInput);

        System.out.println("\n=== Using PreparedStatement (Safe) ===");
        executeWithPreparedStatement(userInput);
    }

    private static void executeWithStatement(String userInput) {

        String query =
                "SELECT id, username FROM users WHERE username = '"
                        + userInput + "'";

        try (
                Connection con =
                        DriverManager.getConnection(URL, USER, PASSWORD);
                Statement stmt = con.createStatement();
                ResultSet rs = stmt.executeQuery(query)
        ) {

            while (rs.next()) {
                System.out.println(
                        rs.getInt("id") + " - " +
                                rs.getString("username")
                );
            }

        } catch (SQLException e) {
            System.out.println("Statement Error: " + e.getMessage());
        }
    }

    private static void executeWithPreparedStatement(String userInput) {

        String query =
                "SELECT id, username FROM users WHERE username = ?";

        try (
                Connection con =
                        DriverManager.getConnection(URL, USER, PASSWORD);
                PreparedStatement ps = con.prepareStatement(query)
        ) {

            ps.setString(1, userInput);

            try (ResultSet rs = ps.executeQuery()) {
                while (rs.next()) {
                    System.out.println(
                            rs.getInt("id") + " - " +
                                    rs.getString("username")
                    );
                }
            }

        } catch (SQLException e) {
            System.out.println("PreparedStatement Error: " + e.getMessage());
        }
    }
}