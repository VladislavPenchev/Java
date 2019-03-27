package GetVillainsName_fd_2;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Engine implements Runnable {

    private Connection connection;

    public Engine(Connection connection){
        this.connection = connection;
    }

    private void GetVillainsName() throws SQLException {
        String query = "SELECT v.name, count(m.name) FROM villains v INNER JOIN minions_villains mv  ON mv.villain_id = v.id INNER JOIN minions m ON m.id = mv.minion_id GROUP BY v.name HAVING count(m.name) > 3 ORDER BY v.name DESC";

        PreparedStatement preparedStatement = this.connection.prepareStatement(query);

        ResultSet resultSet = preparedStatement.executeQuery();

        while(resultSet.next()){

            String villainsName = resultSet.getString(1);
            String countOfMinions = resultSet.getString(2);

            System.out.println(String.format("%s %s", villainsName,countOfMinions));
        }

    }

    public void run() {
        try {
            this.GetVillainsName();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
