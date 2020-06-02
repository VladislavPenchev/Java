package com.penchev.springintroapp.services.Implementations;

import com.penchev.springintroapp.services.CarsService;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Service;



@Service
public class CarsServiceImpl implements CarsService {


    private final String[] cars;

    public CarsServiceImpl(ApplicationContext context){
        this.cars = context.getBean(String[].class);
    }

    @Override
    public String[] getAllCars() {
        return null;
    }
}
