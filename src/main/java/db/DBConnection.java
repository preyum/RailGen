package db;

import java.sql.Connection;
import java.sql.DriverManager;

public class DBConnection {
    private static Connection connection;

    // Database details
    private static final String URL = "jdbc:oracle:thin:@localhost:1521:orcl1";
    private static final String USERNAME = "C##newuser123";
    private static final String PASSWORD = "password";

    public static Connection getConnection() {
        try {
            if (connection == null || connection.isClosed()) {
                // Load the Oracle JDBC Driver
                Class.forName("oracle.jdbc.OracleDriver");
                // Establish the connection
                connection = DriverManager.getConnection(URL, USERNAME, PASSWORD);
                System.out.println("Database connected successfully!");
            }
        } catch (Exception e) {
//            e.printStackTrace();
            System.out.println("Error connecting to database!" + e.getMessage());
        }
        return connection;
    }
}
