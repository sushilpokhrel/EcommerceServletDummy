package utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 * Created by anish on 7/18/17.
 */
public class DatabaseConnection {
    final String URL = "jdbc:mysql://localhost:3306/ecommerce";
    final String USERNAME = "root";
    final String PASSWORD = "root";

    Connection conn = null;

    public DatabaseConnection() throws ClassNotFoundException, SQLException {
        Class.forName("com.mysql.jdbc.Driver");
        conn = DriverManager.getConnection(URL,USERNAME,PASSWORD);
        System.out.println("Database Connected");
    }

    public PreparedStatement getPreparedStatement(String query) throws SQLException {
        PreparedStatement pstm = null;

        return conn.prepareStatement(query);

    }
}
