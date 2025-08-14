import helper.DBHandler;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Main {
    static private DBHandler dbHandler;
    static private Connection connection;
    static private PreparedStatement preparedStatement;

    public static void main(String[] args) throws ClassNotFoundException, SQLException {
        dbHandler = new DBHandler();
        connection = dbHandler.getDbConnection();

//        writeToDb();
        readFromDb();
        updateDb("firstname", "lastname", "username", "addresss", 0, 1);
        deleteUser(1);
    }

    public static void writeToDb() throws SQLException {
        String insert = "INSERT INTO users(firstName, lastName, username, address, age)"
                + "VALUES (?, ?, ?, ?, ?)";

        preparedStatement = connection.prepareStatement(insert);

        preparedStatement.setString(1, "James");
        preparedStatement.setString(2, "Bond");
        preparedStatement.setString(3, "jamesb");
        preparedStatement.setString(4, "342 Home street");
        preparedStatement.setInt(5, 33);


        // executing
        int rowInserted = preparedStatement.executeUpdate();
        System.out.println("Row inserted into table users: " + rowInserted);
    }

    public static void readFromDb() throws SQLException {
        String query = "SELECT * FROM users";

        PreparedStatement preparedStatement = (PreparedStatement) connection.prepareStatement(query);
        ResultSet resultSet = preparedStatement.executeQuery();

        while(resultSet.next()) {
            String firstName = resultSet.getString("firstName");
            String lastName = resultSet.getString("lastName");
            String username = resultSet.getString("username");
            String address = resultSet.getString("address");
            int age = resultSet.getInt("age");
            System.out.println(firstName + " " + lastName + " " + username + " " + address + " " + age);
        }
    }

    public static void updateDb(
            String firstName, String lastName, String username, String address, int age, int id
    ) throws SQLException {
        String query = "UPDATE users SET firstName = ?, lastName = ?, username = ?,  address = ?, age = ? WHERE userid = ?";

        PreparedStatement preparedStatement = connection.prepareStatement(query);
        preparedStatement.setString(1, firstName);
        preparedStatement.setString(2, lastName);
        preparedStatement.setString(3, username);
        preparedStatement.setString(4, address);
        preparedStatement.setInt(5, age);
        preparedStatement.setInt(6, id);

        preparedStatement.executeUpdate();
        preparedStatement.close();
    }

    public static void deleteUser(int id) throws SQLException {
        String query = "DELETE FROM users WHERE userid = ?";
        PreparedStatement preparedStatement = connection.prepareStatement(query);
        preparedStatement.setInt(1, id);
        preparedStatement.executeUpdate();
        preparedStatement.close();
    }
}
