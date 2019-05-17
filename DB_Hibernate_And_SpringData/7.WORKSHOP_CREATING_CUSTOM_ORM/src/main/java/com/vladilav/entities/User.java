package com.vladilav.entities;

import com.vladilav.db.annotations.Column;
import com.vladilav.db.annotations.Entity;
import com.vladilav.db.annotations.PrimaryKey;

@Entity(name = "employees")
public class User {
    @PrimaryKey(name = "id")
    private long id;
    @Column(name = "first_name")
    private String firstName;
    @Column(name = "last_name")
    private String lastName;

    public User(){

    }

    public User(String firstName, String lastName) {
        setFirstName(firstName);
        setLastName(lastName);
    }

    public long getId() {
        return this.id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getFirstName() {
        return this.firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return this.lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    @Override
    public String toString() {
        return String.format("%d | %s | %s",
                getId(), getFirstName(), getLastName());
    }
}
