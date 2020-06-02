package app;

import app.entities.Address;
import app.entities.Employee;
import app.entities.Town;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.List;
import java.util.Scanner;

public class Engine implements Runnable {

    private final EntityManager entityManager;

    public Engine(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    public void run() {
        //this.containsEmployee(); //3
        //this.empoloyeeWithSalaryOver50000(); //4
        this.employeesFromDepartment();
        //this.addingNewAddressAndUpdatingEmployee(); //6
    }

    /*
    * 3.Contains Employee
    */
    private void containsEmployee() {
        Scanner scanner = new Scanner(System.in);

        String name = scanner.nextLine();

        this.entityManager.getTransaction().begin();

        try {
            Employee employee = this.entityManager
                    .createQuery("FROM Employee WHERE concat(first_name, ' ', last_name) = :name", Employee.class)
                    .setParameter("name", name)
                    .getSingleResult();
            System.out.println("Yes");
        } catch(NoResultException nre){
            System.out.println("No");
        }

        this.entityManager.getTransaction().commit();
    }

    /*/
    4.	Employees with Salary Over 50 000
     */

    private void empoloyeeWithSalaryOver50000(){

        this.entityManager.getTransaction().begin();

        try {
            List<Employee> employees = this.entityManager.createQuery("FROM Employee WHERE salary > 50000",Employee.class)
                    .getResultList();

            employees.forEach(emp -> {
                String name = emp.getFirstName();
                System.out.println(name);
            });

        }catch(NoResultException nre){
            System.out.println(nre.getMessage());
        }

        this.entityManager.getTransaction().commit();
    }


    /*SELECT emp.first_name,
emp.last_name,
d.name,
emp.salary
FROM employees AS emp
INNER JOIN departments AS d
ON d.department_id = emp.department_id
WHERE d.name = 'Research and Development'
ORDER BY emp.salary ASC,
emp.employee_id ASC;*/
    private void employeesFromDepartment(){

        this.entityManager.getTransaction().begin();

        try{
            List<Employee> employees = this.entityManager
                    .createQuery("SELECT emp.first_name, emp.last_name, d.name, emp.salary FROM Employee emp " +
                            "INNER JOIN emp.departments AS d WHERE d.name = 'Research and Development' " +
                            "ORDER BY emp.salary ASC")
                    .getResultList();

            System.out.println();

            employees.forEach(emp -> {
                //tring reuslt = String.format("%s %s from %s - $%.2f",emp.getFirstName(),emp.getLastName(), );
                System.out.println();
            });

        }catch (NoResultException nse){

        }
    }




    /*
    * 6.	Adding a New Address and Updating Employee*/
    private void addingNewAddressAndUpdatingEmployee(){
        Scanner scanner = new Scanner(System.in);
        String lastName = scanner.nextLine();

        this.entityManager.getTransaction().begin();

        Address address = new Address();

        address.setText("Vitoshka 15");

        Town town = this.entityManager
                .createQuery("FROM Town WHERE name = 'Sofia'", Town.class)
                .getSingleResult();

        address.setTown(town);

        this.entityManager.persist(address);

        Employee employee = this.entityManager
                .createQuery("FROM Employee WHERE last_name = :name", Employee.class)
                .setParameter("name", lastName)
                .getSingleResult();

        this.entityManager.detach(employee.getAddress());

        employee.setAddress(address);

        this.entityManager.merge(employee);

        this.entityManager.getTransaction().commit();

        //this.entityManager.getTransaction().commit();
    }


}
