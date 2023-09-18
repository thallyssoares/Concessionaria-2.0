package core.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public final class ConnectionJDBC {
    private static String url;
    private static String user;
    private static String password;

    public static Connection getConnection(){
        url = "jdbc:mysql://localhost:3306/concessionaria";
        user = "root";
        password = "";
        try {
            Connection connection = DriverManager.getConnection(url, user, password);
            return connection;
        }
        catch(SQLException e){
            System.out.println(e.getMessage());
        }
        return null;
    }
    public static void close(Connection connection) {
        try {
            connection.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
    public static void close(Connection connection, Statement stmt){
        close(connection);
        try {
            stmt.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

}
