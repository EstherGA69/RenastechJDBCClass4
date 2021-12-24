package renastech.jdbc.day01;

import java.sql.*;

public class c1_Database_Connection {

    public static void main(String[] args) throws SQLException {
        //JDBC has DriverManager class to manage connection according to
        //         the url, username , password
        //        url | connection string  (YOU WILL BE GIVE THIS INFORMATION)
        //  jdbc:oracle:thin:@54.88.118.39:1521:XE
        // "jdbc:oracle:thin:@IP_ADDRESS:1521:XE";
        //  jdbc  --  connection using java
        //   oracle -- database vendor , RDBMS
        //    thin  --- one type oracle driver
        // IP_ADDRESS  -- HOSTNAME or IP
        //  1521  ---- port used for oracle database
        //  XE   ----- sid name  unique identifier for your oracle db

        // define the connectionstring
        String connectionUrl = "jdbc:oracle:thin:@ec2-3-91-68-37.compute-1.amazonaws.com:1521:XE";
        String userName = "hr";
        String password = "hr";

        // create connection
        Connection connection = DriverManager.getConnection(connectionUrl, userName, password);

        // create statement
        Statement statement = connection.createStatement();

        //Resultset will store the executeQuery result
        ResultSet resultset = statement.executeQuery("SELECT * FROM countries");

        //System.out.println("First column value:"+resultset.getString(1));
        //System.out.println("First column value:"+resultset.getString("country_id"));

        // cursor will point to the first row of the resultset
        resultset.next();

        // print the 1st column of 1st row by index
        System.out.println("First column value:" + resultset.getString(1));
        // print the 1st column of 1st row by column name
        System.out.println("First column value:" + resultset.getString("country_name"));

        // cursor will move to the 2nd row
        resultset.next();
        //cursor will move to the 3rd row
        resultset.next();
        //cursor will move to the 4th row
        resultset.next();
        // print the results of 4th row
        System.out.println("First column value:" + resultset.getString(1));
        System.out.println("First column value:" + resultset.getString("country_id"));

        //close resultset
        resultset.close();
        //close statement
        statement.close();
        //close connection
        connection.close();

    }
}
