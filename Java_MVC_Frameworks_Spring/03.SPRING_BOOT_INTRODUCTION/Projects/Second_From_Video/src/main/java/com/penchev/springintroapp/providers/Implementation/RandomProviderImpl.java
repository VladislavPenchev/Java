package com.penchev.springintroapp.providers.Implementation;

import com.penchev.springintroapp.providers.RandomProvider;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
public class RandomProviderImpl implements RandomProvider {

    private static RandomProviderImpl instance;

    public static RandomProviderImpl getInstance() {
        if(instance == null){
            instance = new RandomProviderImpl();
        }
        return instance;
    }

    @Override
    public int getRandomInt() {
        return (int) (Math.random() * 1000);
    }
}
