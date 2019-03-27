package IncreaseMinionsAge_fd_8;

import javax.xml.transform.Result;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


public class Engine implements Runnable{
    private Connection connection;

    public Engine(Connection connection){
        this.connection = connection;
    }

    private void increaseMininonAgeAndChangeTitleCase() throws IOException, SQLException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        List<Integer> idsInt = new ArrayList();

        //TODO: stream doesn't work
        String[] ids = reader.readLine().split("\\s+");

        for (String id : ids) {
            idsInt.add(Integer.parseInt(id));
        }

        updateAgePlusOne(idsInt);

        toUpperFirstLetter(idsInt);

        printResult(idsInt);

    }

    private String readList(List<Integer> ids){

        String idsString = "";

        for (int id : ids) {
            idsString += id + ", ";
        }

        return idsString = idsString.substring(0,idsString.length() - 2);

    }

    private void updateAgePlusOne(List<Integer> ids) throws SQLException {

        String idsString = readList(ids);

        String query = String.format("UPDATE minions SET age = age + 1 WHERE id IN (%s)", idsString);

        PreparedStatement preparedStatement = this.connection.prepareStatement(query);

        preparedStatement.execute();
    }

    private void toUpperFirstLetter(List<Integer> ids) throws SQLException {
        String idsString = readList(ids);

        String query = String.format("UPDATE minions SET name = REPLACE(name,substring(name,1,1),upper(substring(name,1,1))) WHERE id IN (%s)",idsString);

        PreparedStatement preparedStatement = this.connection.prepareStatement(query);

        preparedStatement.execute();
    }

    private void printResult(List<Integer> ids) throws SQLException {

        String idsString = readList(ids);

        String query = String.format("SELECT name, age FROM minions WHERE id IN (%s)", idsString);

        PreparedStatement preparedStatement = this.connection.prepareStatement(query);

        ResultSet resultSet = preparedStatement.executeQuery();

        while(resultSet.next()){

            String name = resultSet.getString(1);
            String age= resultSet.getString(2);

            System.out.println(String.format("%s %s",name , age));

        }

    }

    public void run() {
        try {
            this.increaseMininonAgeAndChangeTitleCase();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
