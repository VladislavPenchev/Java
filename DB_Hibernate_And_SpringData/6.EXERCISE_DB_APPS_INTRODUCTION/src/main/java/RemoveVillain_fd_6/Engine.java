package RemoveVillain_fd_6;

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
            this.removeVillain();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private void removeVillain() throws IOException, SQLException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        String id = reader.readLine();

            String query = String.format("SELECT v.id, v.name , COUNT(v.name) FROM villains v INNER JOIN minions_villains mv ON mv.villain_id = v.id INNER JOIN minions m ON m.id = mv.minion_id WHERE v.id = %s ORDER BY v.name",id);

            PreparedStatement preparedStatement = this.connection.prepareStatement(query);

            ResultSet resultSet = preparedStatement.executeQuery();

            while(resultSet.next()) {

                String idOfVillaon = resultSet.getString(1);
                String nameOfVillain = resultSet.getString(2);
                String countOfVillain = resultSet.getString(3);

                if(!(idOfVillaon == null)){
                    System.out.println(String.format("%s was deleted", nameOfVillain));
                    System.out.println(String.format("%s minions released", countOfVillain));
                }else{
                    System.out.println("No such villain was found");
                }
            }

    }

}
