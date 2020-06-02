package softuni.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import softuni.demo.domain.entities.Shampoo;
import softuni.demo.domain.entities.Size;
import softuni.demo.repository.ShampooRepository;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class ShampooServiceImpl implements ShampooService{

    private final ShampooRepository shampooRepository;

    @Autowired
    public ShampooServiceImpl(ShampooRepository shampooRepository) {
        this.shampooRepository = shampooRepository;
    }

    @Override
    public List<String> selectShampoosBySize(String inputSize) {

        Size size = Size.valueOf(inputSize.toUpperCase());

        List<Shampoo> shampoos = this.shampooRepository.findAllBySizeOrderById(size);

        return shampoos.stream()
                .map(shampoo ->
                    String.format("%s %s %.2flv",shampoo.getBrand(), shampoo.getSize().name(), shampoo.getPrice())
                    ).collect(Collectors.toList());



    }
}
