import java.sql.*;

public class c2_Database_Connection {
    public static void main(String[] args) throws SQLException {
        // define the connectionstring
        String connectionUrl = "jdbc:oracle:thin:@ec2-3-91-68-37.compute-1.amazonaws.com:1521:XE";
        String userName = "hr";
        String password = "hr";

        // create connection
        Connection connection = DriverManager.getConnection(connectionUrl, userName, password);

        // create statement
        Statement statement = connection.createStatement();

        //Resultset will store the executeQuery result
        ResultSet resultset = statement.executeQuery("SELECT * FROM Employees");

        resultset.next();
        resultset.next();
        System.out.println("First Employee name:"+resultset.getString("first_name"));

        System.out.println("-------------- ResultSet1--------------");
        while(resultset.next()){
            System.out.println("Employee Name: "+resultset.getString("first_name"));
            System.out.println("Employee Email: "+resultset.getString("email"));
        }

        // resultset2 can be created to execute other statement
        ResultSet resultSet2=statement.executeQuery("SELECT * FROM countries");
        //resultSet2.next();
        //System.out.println("-------------- ResultSet2--------------");
        //System.out.println("Employee Name: "+resultSet2.getString("country_id"));
        //System.out.println("Employee Email: "+resultSet2.getString("country_name"));
        resultSet2.next();
        while(resultSet2.next()){
            System.out.println("Employee Name: "+resultset.getString("country_id"));
            System.out.println("Employee Email: "+resultset.getString("country_name"));
        }

        resultSet2.close();
        resultset.close();
        statement.close();
        connection.close();


    }
}
