package renastech.jdbc.day01;

import java.sql.*;

public class c4_Database_Connection {

    public static void main(String[] args) throws SQLException {
        // define the connectionstring
        String connectionUrl = "jdbc:oracle:thin:@ec2-3-91-68-37.compute-1.amazonaws.com:1521:XE";
        String userName = "hr";
        String password = "hr";

        // create connection
        Connection connection = DriverManager.getConnection(connectionUrl, userName, password);

        // create statements. TYPE_SCROLL_INSENSITIVE will make our cursor free
        Statement statement= connection.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_READ_ONLY);

        ResultSet resultSet = statement.executeQuery("SELECT * FROM countries");

        // check if cursor is after last row
        System.out.println(resultSet.isAfterLast());

        // check if cursor is before first row
        System.out.println(resultSet.isBeforeFirst());

        // move cursor to after last row
        resultSet.afterLast();
        // this will print true since cursor is after last
        System.out.println(resultSet.isAfterLast());
        // print false since cursor is after last
        System.out.println(resultSet.isBeforeFirst());

        // move cursor to specific row:15
        resultSet.absolute(15);
        // print the country name from 15th row i.e. Japan
        System.out.println("Fifteenth row: "+ resultSet.getString("country_name"));

        //close connection
        resultSet.close();
        statement.close();
        connection.close();
    }
}
