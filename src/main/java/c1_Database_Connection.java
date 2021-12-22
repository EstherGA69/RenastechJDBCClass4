import java.sql.*;

public class c1_Database_Connection {
    public static void main(String[] args) throws SQLException {

        //JDBC has DriverManager class to manage connection according to
        //  		the url, username , password
        //
        //  	url | connection string  (YOU WILL BE GIVE THIS INFORMATION)
        //  	jdbc:oracle:thin:@54.88.118.39:1521:XE
        //  	"jdbc:oracle:thin:@IP_ADDRESS:1521:XE";
        //  	jdbc  --  connection using java
        //  	oracle -- database vendor , RDBMS
        //  	thin  --- one type oracle driver
        //  	IP_ADDRESS  -- HOSTNAME or IP
        //  	1521  ---- port used for oracle database
        //  	XE   ----- sid name  unique identifier for your oracle db

        String connectiobUrl="jdbc:oracle:thin:@ec2-3-91-68-37.compute-1.amazonaws.com:1521:XE";

        String userName="hr";
        String password="hr";

        //connection comes from library sql import java.sql.* ;
        Connection connection= DriverManager.getConnection(connectiobUrl,userName,password);
        //anytime you call sql methods,classes ,interfaces you also need to handle sql exception


        //statment will be created through with connection that you have
        Statement statement=connection.createStatement();


        //third step is being able to pass and excute query
        ResultSet resultSet=statement.executeQuery("SELECT * FROM countries");


        //database cursor is on before each data
        //to be able to move on inside countries table
        //we need move the cursor

        //cursor was on top table

        resultSet.next();//now cursor is row one


        //to be able to print data from table :
        // you will need to use getString() method

        //rs.getString(1) --->> return the first column cell value at this row
        //		rs.getString("column name") --->> return the cell value at this column at this row


        //there will be 2 way to print data from database first by passing index number of column
        // or you need to pass column name .
        System.out.println("First column value  row 1: " +resultSet.getString(1));
        System.out.println("First column value  row 1 : " +resultSet.getString("country_id"));


        System.out.println("Second column value at row 1 :" + resultSet.getString(2));
        System.out.println("Second column value at row 1 :" + resultSet.getString("country_name"));


        //System.out.println(resultSet.getString(0));Invalid column index


        //IF I WANT TO PRINT SECOND ROW  DATAS
        //i will need to move cursor

        resultSet.next();//cursor is on 2 row

        resultSet.next();//cursor is on 3 row

        System.out.println("Third column value at row 3 :" +resultSet.getString(3));
        System.out.println("Third column value at row 3 :" +resultSet.getString("region_id"));



        //closing connection
        resultSet.close();
        statement.close();
        connection.close();

        //since wwe close everyting you wont be able to run new query
        // System.out.println("Third column value at row 3 :" +resultSet.getString(3));//Closed Resultset: getString
}
}
