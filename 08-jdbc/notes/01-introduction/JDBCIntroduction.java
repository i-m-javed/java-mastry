import java.sql.*;

public class JDBCIntroduction {

    private static final String URL =
            "jdbc:mysql://localhost:5432/table_name";
    private static final String USER = "*******";
    private static final String PASSWORD = "password";

    public static void main(String[] args) {

        try (
                Connection connection =
                        DriverManager.getConnection(URL, USER, PASSWORD);

                PreparedStatement statement =
                        connection.prepareStatement(
                                "SELECT id, name FROM employee WHERE id > ?"
                        )
        ) {

            statement.setInt(1, 0);

            try (ResultSet resultSet = statement.executeQuery()) {

                while (resultSet.next()) {
                    int id = resultSet.getInt("id");
                    String name = resultSet.getString("name");

                    System.out.println(id + " - " + name);
                }
            }

        } catch (SQLException e) {

            System.out.println("SQL Error: " + e.getMessage());
            System.out.println("SQL State: " + e.getSQLState());
            System.out.println("Error Code: " + e.getErrorCode());
        }
    }
}