import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Main {
    public static void main(String[] args) throws ClassNotFoundException, SQLException {
        Class.forName("com.mysql.cj.jdbc.Driver");

        Connection connection =  DriverManager.getConnection(
                "jdbc:mysql://localhost:3306/login", "root", "Missing_Voyager#2441139qwert");

        System.out.println("Connected to the database " + connection.getCatalog() + " successfully");
    }
}
