package util;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnUtil {
    public static Connection getConnection(String connectionString) {
        try {
            // Load the JDBC driver
            Class.forName("com.mysql.cj.jdbc.Driver");

            // Establish a database connection
            return DriverManager.getConnection(connectionString);
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace(); // Handle connection errors appropriately
            return null;
        }
    }

    public static void closeConnection(Connection connection) {
        if (connection != null) {
            try {
                // Close the connection
                connection.close();
            } catch (SQLException e) {
                e.printStackTrace(); // Handle closure errors appropriately
            }
        }
    }
}
