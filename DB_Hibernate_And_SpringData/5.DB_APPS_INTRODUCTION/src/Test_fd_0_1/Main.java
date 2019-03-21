package Test_fd_0_1;

import Test_fd_0_1.repositories.base.DataRepository;
import Test_fd_0_1.repositories.JdbcDataRepository;
import Test_fd_0_1.repositories.base.Employee;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Main {
    public static void main(String[] args) throws SQLException {
        String connectionString = "jdbc:mysql://localhost/soft_uni_simple";

        Connection connection =
                DriverManager.getConnection(connectionString, "vladislav", "");

        DataRepository<Employee> repository = new EmployeesDataRepository(connection);
        repository.getAll()
                .stream()
                .map(Employee::getFirstName)
                .forEach(System.out::println);

        System.out.println("------------------------");
        repository.insert(new Employee("Goshi","Oeshov"));

        repository.getAll()
                .stream()
                .map(Employee::getFirstName)
                .forEach(System.out::println);

        //repository.insert();




        connection.close();
    }
}
