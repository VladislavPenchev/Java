package com.vladilav;

import com.vladilav.db.EntityDbContext;
import com.vladilav.db.base.DbContext;
import com.vladilav.entities.Department;
import com.vladilav.entities.User;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class App {

    private static final String CONNECTION_STRING = "jdbc:mysql://localhost:3306/soft_uni_simple";

    public static void main(String[] args) throws SQLException, IllegalAccessException, InstantiationException {

        Connection connection = getConnection();

        EntityDbContext usersDbContext = getDbContext(connection, User.class);

        //DbContext<Department> departmentDbContext = getDbContext(connection, Department.class);


//        System.out.println(usersDbContext.findFirst());
//        System.out.println(usersDbContext.findFirst("first_name LIKE 'P%'"));
//        System.out.println(usersDbContext.findById(1));

//        User user = new User();
//        user.setFirstName("Stamat");
//        user.setLastName("Peshov");
//        usersDbContext.persist(user);
//
//        usersDbContext.find()
//                .forEach(System.out::println);

//        User user = (User) usersDbContext.findById(1);
//        user.setLastName("Wse taq");
//        usersDbContext.persist(user);


        //Create TABLE
        User user = new User("Pesho", "Peshev");

        //departments
//        DbContext<Department> departmentDbContext = getDbContext(connection, Department.class);
//
//        departmentDbContext.find()
//                        .forEach(System.out::println);

        //connection.close();

    }

    private static <T> EntityDbContext getDbContext(Connection connection, Class<T> klass) throws SQLException {
        return new EntityDbContext<T>(connection, klass);
    }

    private static Connection getConnection() throws SQLException {
        return DriverManager.getConnection(CONNECTION_STRING,"vladislav", "");
    }
}
