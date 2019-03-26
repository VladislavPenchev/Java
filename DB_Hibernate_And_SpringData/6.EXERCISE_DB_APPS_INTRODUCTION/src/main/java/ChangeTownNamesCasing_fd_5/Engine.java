package ChangeTownNamesCasing_fd_5;

import java.io.BufferedReader;
import java.io.IOException;
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


    public void run() {
        try {
            this.updateTownsToUppercase();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private boolean checksIfCountryExists(String name) throws SQLException {
        String query = String.format("SELECT * FROM towns WHERE country = '%s'",name);

        PreparedStatement preparedStatement = this.connection.prepareStatement(query);

        ResultSet resultSet = preparedStatement.executeQuery();

        if(resultSet.next()){
            return true;
        }

        return false;
    }

    private void rowsCountryAffected(String country) throws SQLException {
        String query = String.format("SELECT COUNT(country) FROM towns WHERE country = '%s'",country);

        PreparedStatement preparedStatement = this.connection.prepareStatement(query);

        ResultSet resultSet = preparedStatement.executeQuery();

        while(resultSet.next()){

            String numberOfTownsWereAffected = resultSet.getString(1);

            System.out.println(String.format("%s town names were affected.",numberOfTownsWereAffected));
        }
    }

    private void showUpdatedCountry(String country) throws SQLException {
        String query = String.format("SELECT name, country FROM towns WHERE country = '%s'", country);

        PreparedStatement preparedStatement = this.connection.prepareStatement(query);

        ResultSet resultSet = preparedStatement.executeQuery();

        String printAffectedTowns = "";

        while(resultSet.next()){

            printAffectedTowns += resultSet.getString(1) + ", ";
        }

        printAffectedTowns = printAffectedTowns.substring(0,printAffectedTowns.length() - 2);

        printAffectedTowns = "[" + printAffectedTowns + "]";

        System.out.println(String.format(printAffectedTowns));

    }

    private void updateTownsToUppercase() throws IOException, SQLException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        String country = reader.readLine();

        if(!this.checksIfCountryExists(country)){
            System.out.println("No town names were affected.");
        }else {

            this.rowsCountryAffected(country);

            this.showUpdatedCountry(country);

            String query = String.format("UPDATE towns SET name = UPPER(name) WHERE country = '%s'",country);

            PreparedStatement preparedStatement = this.connection.prepareStatement(query);

            preparedStatement.execute();

        }

    }


}
