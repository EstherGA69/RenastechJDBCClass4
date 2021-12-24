package renastech.jdbc.day02;

import renastech.jdbc.utils.DatabaseUtil;

import java.sql.ResultSet;
import java.sql.SQLException;

public class c1_ResultsetMetaData {

    public static void main(String[] args) throws SQLException {
        //following code is calling the Utility class i.e DatabaseUtil which have the utility methods
        // call createConnection of DatabaseUtil class to create connection
        DatabaseUtil.createConnection();
        //call runQuery method of DatabaseUtil class to get the resultset
        ResultSet resultSet = DatabaseUtil.runQuery("SELECT * FROM Employees");
        //move the cursor to forward on first row of resultset
        resultSet.next();
        //print the first name of employee
        System.out.println(resultSet.getString("first_name"));
    }

}
