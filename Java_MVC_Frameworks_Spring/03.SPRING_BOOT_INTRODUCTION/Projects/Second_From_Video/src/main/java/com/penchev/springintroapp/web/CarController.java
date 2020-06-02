package com.penchev.springintroapp.web;

import com.penchev.springintroapp.entities.Car;
import com.penchev.springintroapp.repository.CarsRepository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController("/cars")
public class CarController {

    private final CarsRepository carsRepository;

    public CarController(CarsRepository carsRepository) {
        this.carsRepository = carsRepository;
    }

    @GetMapping("")
    public List<Car> getCars() {
        return carsRepository.findAll();
    }
}
