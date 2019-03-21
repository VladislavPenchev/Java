package Test_fd_0;

import com.sun.corba.se.impl.orb.PrefixParserAction;

import java.sql.*;

public class Main {
    public static void main(String[] args) throws SQLException {
        String connectionString = "jdbc:mysql://localhost:3306/soft_uni";

        Connection connection =
                DriverManager.getConnection(connectionString, "vladislav", "");

        PreparedStatement preparedStatement = connection.prepareStatement( "" +
                        "SELECT *\n" +
                        "FROM employees\n" +
                        "WHERE salary > ?\n" +
                        "ORDER BY ?");

        preparedStatement.setDouble(1, 50000);
        preparedStatement.setString(2, "first_name");

        ResultSet resultSet = preparedStatement.executeQuery();

        while(resultSet.next()){
            System.out.println(resultSet.getString("first_name"));
        }

        connection.close();
    }
}
