package AddMinion_fd_4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.*;

public class Engine implements Runnable{
    private Connection connection;

    public Engine(Connection connection) {
        this.connection = connection;
    }

    public void run() {
        try {
            this.addMinion();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private void addMinion() throws IOException, SQLException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        String[] minionParams = reader.readLine().split("\\s+");
        String[] villainParams = reader.readLine().split("\\s+");

        String minionName = minionParams[1];
        int minionAge = Integer.parseInt(minionParams[2]);
        String townName = minionParams[3];

        String villainName = villainParams[1];

        if(!this.checksIfEntityExists(townName,"towns")){
            this.insertTown(townName);
        }

        if(!this.checksIfEntityExists(villainName, "villains")){
            this.insertVillain(villainName);
        }

        int townId = this.getEntityId(townName, "towns");

        this.insertMinion(minionName, minionAge, townId);

        int minionId = this.getEntityId(minionName,"minions");
        int villainId = this.getEntityId(villainName, "villains");

        this.hireMinion(minionId, villainId);

        System.out.println(String.format("Successfully added %s to be minion of %s", minionName, villainName));


    }

    private boolean checksIfEntityExists(String name, String tableName) throws SQLException {
        String query = String.format("SELECT * FROM %s WHERE name = '%s'",tableName,name);

        PreparedStatement preparedStatement = this.connection.prepareStatement(query);

        ResultSet resultSet = preparedStatement.executeQuery();

        if(resultSet.next()){
            return true;
        }

        return false;
    }

    private void insertTown (String townName) throws SQLException {
        String query = "INSERT INTO towns(name, country) VALUES('" + townName + "', NULL)";
        PreparedStatement preparedStatement = this.connection.prepareStatement(query);

        preparedStatement.execute();

        System.out.println(String.format("Town %s was added to the database.", townName));
    }

    private void insertVillain(String villainName) throws SQLException {
        String query = String.format("INSERT INTO villains(name, evilness_factor) VALUES('%s','evil')", villainName);

        PreparedStatement preparedStatement = this.connection.prepareStatement(query);

        preparedStatement.execute();

        System.out.println(String.format("Villain %s was added to the database.", villainName));

    }

    private int getEntityId(String name, String tableName) throws SQLException {
        String query = String.format("SELECT id FROM %s WHERE name ='%s'", tableName, name);

        PreparedStatement preparedStatement = this.connection.prepareStatement(query);

        ResultSet resultSet = preparedStatement.executeQuery();

        resultSet.next();

        return resultSet.getInt(1);
    }

    private void insertMinion(String minionName, int age, int townId) throws SQLException {
        String query = String.format("INSERT INTO minions(name, age, town_id) VALUES('%s', %d, %d)", minionName, age, townId);

        PreparedStatement preparedStatement = this.connection.prepareStatement(query);

        preparedStatement.execute();

    }

    private void hireMinion(int minionId, int villainId) throws SQLException {
        String query = String.format("INSERT INTO minions_villains(minion_id, villain_id) VALUES(%d, %d)", minionId, villainId);

        PreparedStatement preparedStatement = this.connection.prepareStatement(query);

        preparedStatement.execute();
    }

}
