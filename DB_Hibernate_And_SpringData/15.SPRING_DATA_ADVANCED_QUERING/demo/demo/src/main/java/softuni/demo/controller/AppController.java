package softuni.demo.controller;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Controller;
import softuni.demo.service.ShampooService;
import softuni.demo.service.ShampooServiceImpl;

import java.util.List;
import java.util.Scanner;

@Controller
public class AppController implements CommandLineRunner {

    private final ShampooService shampooService;


    public AppController(ShampooService shampooService) {
        this.shampooService = shampooService;
    }


    @Override
    public void run(String... args) throws Exception {
        Scanner scanner = new Scanner(System.in);
        String inputSize = scanner.nextLine();

        List<String> result = this.shampooService.selectShampoosBySize(inputSize);

        result.forEach(r -> System.out.println(r));
    }
}
