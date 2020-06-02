package com.penchev.springintroapp.providers.Implementation;

import com.penchev.springintroapp.providers.RandomProvider;
import org.springframework.stereotype.Component;

@Component
public class RandomProviderImpl implements RandomProvider {

    @Override
    public int getRandomInt() {
        return (int) (Math.random() *1000);
    }
}
