package com.penchev.springintroapp.web;

import com.penchev.springintroapp.entities.Car;
import com.penchev.springintroapp.repositories.CarsRepository;
import com.penchev.springintroapp.services.CarsService;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController("/cars")
public class CarsController {

    private final CarsRepository carsRepository;

    private CarsService carsService;

    public CarsController(CarsRepository carsRepository) {
        this.carsRepository = carsRepository;
    }


    @GetMapping("")
    public List<Car> getCars(){
        return carsRepository.findAll();
    }
}
