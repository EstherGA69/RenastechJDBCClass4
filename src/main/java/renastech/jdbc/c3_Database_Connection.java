package renastech.jdbc;

import java.sql.*;

public class c3_Database_Connection {
    public static void main(String[] args) throws SQLException {
        // define the connectionstring
        String connectionUrl = "jdbc:oracle:thin:@ec2-3-91-68-37.compute-1.amazonaws.com:1521:XE";
        String userName = "hr";
        String password = "hr";

        // create connection
        Connection connection = DriverManager.getConnection(connectionUrl, userName, password);

        Statement statement= connection.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_READ_ONLY);

        ResultSet resultSet = statement.executeQuery("SELECT * FROM countries");

        // move cursor to 1st row in resultset
        resultSet.next();

        // print country name of 1st row
        System.out.println("First Country Name: "+resultSet.getString("country_name"));

        // move cursor to 2nd row in resultset
        resultSet.next();
        // print country name from 2nd row
        System.out.println("Second Country Name: "+resultSet.getString("country_name"));

        // row number 3
        resultSet.next();
        // row number 4
        resultSet.next();
        // row number 5
        resultSet.next();
        System.out.println("Fifth Country Name: "+resultSet.getString("country_name"));

        // row number 4
        resultSet.previous();
        System.out.println("Fourth Country Name: "+resultSet.getString("country_name"));

        // row number 3
        resultSet.previous();
        System.out.println("Third Country Name: "+resultSet.getString("country_name"));

        // orw number 2
        resultSet.previous();
        System.out.println("Second Country Name: "+resultSet.getString("country_name"));

        //row number 1
        resultSet.previous();
        System.out.println("First Country Name: "+resultSet.getString("country_name"));

        resultSet.next();
        System.out.println("Second Country Name: "+resultSet.getString("country_name"));

        // move the cursor to first row
        resultSet.first();
        // print first row columns
        System.out.println("First Country Name: "+resultSet.getString("country_name"));

        // cursor is before first row, we need tomove cursor next()
        resultSet.beforeFirst();
        // not print anything
        //System.out.println("First Country Name: "+resultSet.getString("country_name"));

        resultSet.next();
        System.out.println("First Country Name: "+resultSet.getString("country_name"));

        // cursor is after the last row of resultset hence need to do previo
        resultSet.afterLast();
        resultSet.previous();
        System.out.println("Last Country Name: "+resultSet.getString("country_name"));

        System.out.println("--------- Country name from last to first ---------");
        while (resultSet.previous()){
            System.out.println("Country Name: "+resultSet.getString("country_name"));
        }

        //close connection
        resultSet.close();
        statement.close();
        connection.close();
    }

}
