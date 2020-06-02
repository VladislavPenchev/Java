package com.penchev.springintroapp.repository;

import com.penchev.springintroapp.entities.Car;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CarsRepository extends JpaRepository<Car, Long> {
    List<Car> findAllByModel(String model);
}
