package Test_fd_0_1.repositories;

import Test_fd_0_1.repositories.base.DataRepository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public abstract class JdbcDataRepository<T> implements DataRepository {

    private final Connection connection;

    public JdbcDataRepository(Connection connection){
        this.connection = connection;
    }

    @Override
    public List<T> getAll() throws SQLException {
        String queryString = "SELECT * FROM  " + this.getTableName();

        PreparedStatement query = connection.prepareStatement(queryString);

        ResultSet resultSet = query.executeQuery();

        return toList(resultSet);
    }

//    @Override
//    public void insert(T object) {
//
//    }


    @Override
    public void insert(Object object) throws SQLException {

        String queryString = "INSERT INTO" +
                                    this.getTableName() +
                                    "(" +
                                    this.getColums() +
                                    ")" +
                                    " VALUES (?)";

        PreparedStatement query = connection.prepareStatement(queryString);

        query.setString(1, this.getValues(object));

        query.executeUpdate();

    }

    protected abstract String getValues(Object object);

    protected abstract String getColums();

    private List<T> toList(ResultSet resultSet) throws SQLException {

        List<T> list = new ArrayList<>();

        while(resultSet.next()){
            T object = this.parseRow(resultSet);

            list.add(object);
        }

        return list;
    }

    protected abstract T parseRow(ResultSet resultSet) throws SQLException;

    protected abstract String getTableName();
}
