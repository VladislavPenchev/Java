package com.penchev.springintroapp.services.impl;

import com.penchev.springintroapp.services.CarsService;
import org.apache.catalina.core.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.stereotype.Service;


@Service
public class CarsServiceImpl implements CarsService {

    private final String[] cars;

//    //Service allocator IoC
//    public CarsServiceImpl(ConfigurableApplicationContext context) {
//        this.cars = context.getBean(String[].class);
//    }

    //Dep injection IoC
    public CarsServiceImpl(String[] cars){
        this.cars = cars;
    }

    @Override
    public String[] getAllCars() {
        return null;
    }
}
