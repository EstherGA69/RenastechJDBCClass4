package renastech.jdbc.day02;

import renastech.jdbc.utils.DatabaseUtil;

import javax.xml.crypto.Data;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

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

        // ResultSetMetaData provide insight of resultset
        ResultSetMetaData rsmd = resultSet.getMetaData();

        // getColumnCount will return the number of column in employee table
        int columnCount = rsmd.getColumnCount();

        //print columnCount
        System.out.println("Number of Columns in table = "+columnCount);

        // getColumnName will return the name of column at number 3 which is LAST_NAME
        String columnName = rsmd.getColumnName(3);

        // print name of column i.e. LAST_NAME
        System.out.println("Column Name = "+columnName);

        System.out.println("------------------- PRINT ALL COLUMN NAMES---------------------");

        // print all the columns of a table
        for (int i=1;i<columnCount;i++){
            System.out.print(rsmd.getColumnName(i)+"\t");
        }
        System.out.println("\n");
        List<String> employeesColumnNames = new ArrayList<>();

        System.out.println("------------------- PRINT ALL COLUMN NAMES FROM LIST ---------------------");

        for(int i=1;i<columnCount;i++){
            employeesColumnNames.add(rsmd.getColumnName(i));
        }

        System.out.println("Employee names in List = "+employeesColumnNames);

        DatabaseUtil.closeDatabase();

    }

}
