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

        String query = "SELECT v.id ,v.name, m.name, m.age FROM villains v INNER JOIN minions_villains mv ON mv.villain_id = v.id INNER JOIN minions m ON m.id = mv.minion_id WHERE v.id = ?";
        PreparedStatement preparedStatement = this.connection.prepareStatement(query);

        int id = Integer.parseInt(reader.readLine());
        preparedStatement.setInt(1, id);

        ResultSet resultSet = preparedStatement.executeQuery();

        boolean flag = true;

        while(resultSet.next()){

            if(flag){
                System.out.println(String.format("Villain: %s", resultSet.getString(2)));
                flag = false;
            }

            System.out.println(resultSet.getString(1));

            if(resultSet.getString(1) == "\n"){
                System.out.println(String.format("No villain with ID %d exists in the database.",id));
            }else if(resultSet.getString(3) == "NULL"){
                System.out.println("<no minions>");
            }else{
                System.out.println(String.format("%s %d", resultSet.getString(3), resultSet.getInt(4)));
            }
        }

    }
}
