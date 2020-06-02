package GetMinionNames_fd_3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Engine implements Runnable{

    private Connection connection;

    public Engine(Connection connection) {
        this.connection = connection;
    }

    public void run() {
        try {
            this.getMinionsNameAndAge();
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void getMinionsNameAndAge() throws SQLException, IOException {

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        int id = Integer.parseInt(reader.readLine());

        String query = String.format("SELECT m.name, m.age, v.name  FROM villains v INNER JOIN minions_villains mv  ON mv.villain_id = v.id INNER JOIN minions m ON m.id = mv.minion_id WHERE v.id = %s",id);

        PreparedStatement preparedStatement = this.connection.prepareStatement(query);

        ResultSet resultSet = preparedStatement.executeQuery();

        int index = 1;

        boolean flagToVillainName = true;

        while(resultSet.next()){

            String villansName = resultSet.getString(3);
            String minionsName = resultSet.getString(1);
            String minionsAge = resultSet.getString(2);

            if (flagToVillainName) {
                System.out.println(String.format("Villain: %s",villansName));

                flagToVillainName = false;
            }
            System.out.println(String.format("%d. %s %s",index, minionsName, minionsAge));

            index++;


        }

    }
}
