import helper.DBHandler;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class Main {
    static private DBHandler dbHandler;
    static private Connection connection;
    static private PreparedStatement preparedStatement;

    public static void main(String[] args) throws ClassNotFoundException, SQLException {
        dbHandler = new DBHandler();
        connection = dbHandler.getDbConnection();

        String insert = "INSERT INTO users(firstName, lastName, username, address, age)"
                + "VALUES (?, ?, ?, ?, ?)";

        preparedStatement = connection.prepareStatement(insert);

        preparedStatement.setString(1, "Paulo");
        preparedStatement.setString(2, "Dichone");
        preparedStatement.setString(3, "paulod");
        preparedStatement.setString(4, "1234 South Beach");
        preparedStatement.setInt(5, 31);


        // executing
        int rowInserted = preparedStatement.executeUpdate();
        System.out.println("Row inserted into table users: " + rowInserted);
    }
}
