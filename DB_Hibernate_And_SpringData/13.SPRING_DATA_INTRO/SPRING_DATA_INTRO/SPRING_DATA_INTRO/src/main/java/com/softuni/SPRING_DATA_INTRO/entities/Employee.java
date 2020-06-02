package com.softuni.SPRING_DATA_INTRO.entities;

import javax.persistence.*;

@Entity(name = "employees")
public class Employee {

    private long id;
    private String firstName;
    private String lastName;
    private Department department;


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public long getId(){
        return id;
    }

    public void setId(long id){
        this.id = id;
    }

    @Column(name = "first_name")
    public String getFirstName() {
        return this.firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    @Column(name = "last_name")
    public String getLastName() {
        return this.lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    @ManyToOne(targetEntity = Department.class)
    public Department getDepartment() {
        return this.department;
    }

    public void setDepartment(Department department) {
        this.department = department;
    }
}
