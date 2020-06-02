package com.penchev.springintroapp.entities;

import javax.persistence.*;

@Entity
public class Car {
    private long id;
    private String model;

    public Car() {
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    @Column(name = "car_model")
    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }
}
