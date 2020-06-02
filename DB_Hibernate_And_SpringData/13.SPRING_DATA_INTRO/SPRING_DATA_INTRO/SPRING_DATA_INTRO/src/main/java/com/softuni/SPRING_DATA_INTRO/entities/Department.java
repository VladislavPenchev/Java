package com.softuni.SPRING_DATA_INTRO.entities;

import javax.persistence.*;
import java.util.Set;

@Entity(name = "departments")
public class Department {

    private long id;
    private String name;
    private Set<Employee> employees;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public long getId() {
        return this.id;
    }

    public void setId(long id) {
        this.id = id;
    }

    @Column
    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @OneToMany(targetEntity = Employee.class, mappedBy = "department")
    public Set<Employee> getEmployees() {
        return this.employees;
    }

    public void setEmployees(Set<Employee> employees) {
        this.employees = employees;
    }
}
