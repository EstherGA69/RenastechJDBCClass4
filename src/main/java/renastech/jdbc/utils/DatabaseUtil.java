package renastech.jdbc.utils;

import java.sql.*;

public class DatabaseUtil {

    private static Connection connection;
    private static Statement statement;
    private static ResultSet resultSet;

    public static void createConnection() throws SQLException {

        String url = ConfigurationReader.getProperty("database.url");
        String username = ConfigurationReader.getProperty("database.username");
        String password = ConfigurationReader.getProperty("database.password");
        try {
            connection = DriverManager.getConnection(url, username, password);
            System.out.println("Connection created successfully");
        }
        catch (SQLException throwables){
            System.out.println("Connection Failed!.....");
        }
    }

    public static ResultSet runQuery(String query) throws SQLException {
        try {
            statement = connection.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
            resultSet = statement.executeQuery(query);
        }
        catch (SQLException throwables){
            System.out.println("An error occurred while executeQuery");
        }
        return resultSet;
    }
}
