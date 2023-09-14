package core.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public final class ConnectionJDBC {
    private String url;
    private String user;
    private String password;

    public Connection getConnection(){
        this.url = "jdbc:mysql://localhost:3306/concessionaria";
        this.user = "root";
        this.password = "";
        try {
            Connection connection = DriverManager.getConnection(url, user, password);
            return connection;
        }
        catch(SQLException e){
            System.out.println(e.getMessage());
        }
        return null;
    }
}
