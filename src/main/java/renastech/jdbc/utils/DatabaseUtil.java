package renastech.jdbc.utils;

import java.sql.*;

public class DatabaseUtil {

    private static Connection connection; // create a static connection variable
    private static Statement statement; // create a static statement variable
    private static ResultSet resultSet; // create a static resultset variable

    // createConnection() method is responsible to create a database connection which is used be other classes
    public static void createConnection() throws SQLException {

        String url = ConfigurationReader.getProperty("database.url"); // get database url from configuration
        String username = ConfigurationReader.getProperty("database.username"); // get username from configuration
        String password = ConfigurationReader.getProperty("database.password"); // get password from configuration
        try {
            connection = DriverManager.getConnection(url, username, password); // create connection
            System.out.println("Connection created successfully");
        }
        // catch exception
        catch (SQLException throwables){
            System.out.println("Connection Failed!.....");
        }
    }

    // runQuery will create statement and return resultset
    public static ResultSet runQuery(String query) throws SQLException {
        try {
            // create a statment that free the resultset to move cursor any direction
            statement = connection.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
            resultSet = statement.executeQuery(query); // calls executeQuery and set it to resultSet
        }
        // catch exception
        catch (SQLException throwables){
            System.out.println("An error occurred while executeQuery");
        }
        return resultSet;
    }

    // close all the database related objects
    public static void closeDatabase(){
        try {
            if (resultSet != null) {
                resultSet.close();
            }
            if (statement != null) {
                statement.close();
            }
            if (connection != null) {
                connection.close();
            }
        }
        // catch exception
        catch (SQLException exception){
            System.out.println("An exception occurs while coseing database");
        }
    }


}
