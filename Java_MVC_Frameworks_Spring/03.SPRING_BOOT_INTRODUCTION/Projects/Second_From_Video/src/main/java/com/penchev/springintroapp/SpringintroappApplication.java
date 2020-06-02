package com.penchev.springintroapp;

import com.penchev.springintroapp.providers.RandomProvider;
import org.apache.catalina.core.ApplicationContext;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
public class SpringintroappApplication {

    public static void main(String[] args) {
        ConfigurableApplicationContext context = SpringApplication.run(SpringintroappApplication.class, args);

        RandomProvider randomProvider = context.getBean(RandomProvider.class);
        int x = randomProvider.getRandomInt();
        int b = 5;
    }

}
