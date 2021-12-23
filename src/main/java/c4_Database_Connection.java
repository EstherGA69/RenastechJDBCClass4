import java.sql.*;

public class c4_Database_Connection {

    public static void main(String[] args) throws SQLException {
        // define the connectionstring
        String connectionUrl = "jdbc:oracle:thin:@ec2-3-91-68-37.compute-1.amazonaws.com:1521:XE";
        String userName = "hr";
        String password = "hr";

        // create connection
        Connection connection = DriverManager.getConnection(connectionUrl, userName, password);

        Statement statement= connection.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_READ_ONLY);

        ResultSet resultSet = statement.executeQuery("SELECT * FROM countries");

        System.out.println(resultSet.isAfterLast());
        System.out.println(resultSet.isBeforeFirst());

        resultSet.afterLast();
        System.out.println(resultSet.isAfterLast());
        System.out.println(resultSet.isBeforeFirst());
        //close connection
        resultSet.close();
        statement.close();
        connection.close();
    }
}
