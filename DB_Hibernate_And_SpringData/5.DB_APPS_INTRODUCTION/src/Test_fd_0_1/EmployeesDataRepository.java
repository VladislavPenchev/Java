package Test_fd_0_1;

import Test_fd_0_1.repositories.JdbcDataRepository;
import Test_fd_0_1.repositories.base.Employee;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;

public class EmployeesDataRepository extends JdbcDataRepository<Employee> {

    public EmployeesDataRepository(Connection connection) {
        super(connection);
    }


    @Override
    protected Employee parseRow(ResultSet resultSet) throws SQLException {

        long id = resultSet.getLong("id");
        String firstName = resultSet.getString("first_name");
        String lastName = resultSet.getString("last_name");
        return new Employee(id, firstName, lastName);


    }

    @Override
    protected String getTableName() {
        return "employees";
    }


    @Override
    protected String getValues(Employee object) {
        return object.getFirstName() + ", " + object.getLastName();
    }

    @Override
    protected String getColums() {
        return "first_name, last_name";
    }
}
