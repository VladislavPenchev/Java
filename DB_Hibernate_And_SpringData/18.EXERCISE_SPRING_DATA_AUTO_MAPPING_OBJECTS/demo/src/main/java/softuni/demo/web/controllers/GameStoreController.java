package softuni.demo.web.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Controller;
import softuni.demo.domain.dtos.UserLoginDto;
import softuni.demo.domain.dtos.UserRegisterDTO;
import softuni.demo.service.UserService;

import java.util.Scanner;

@Controller
public class GameStoreController implements CommandLineRunner {

    private String loggedInUser;

    private final UserService userService;

    @Autowired
    public GameStoreController(UserService userService){
        this.userService = userService;
    }


    @Override
    public void run(String... args) throws Exception {
        Scanner scanner = new Scanner(System.in);

        while (true){
            String inputLine = scanner.nextLine();

            String[] inputParams = inputLine.split("\\|");
            switch (inputParams[0]){
                case "RegisterUser":
                    UserRegisterDTO userRegisterDTO =
                            new UserRegisterDTO(inputParams[1], inputParams[2], inputParams[3], inputParams[4]);
                    System.out.println(this.userService.registerUser(userRegisterDTO));
                    break;
                case "LoginUser":
                    if(this.loggedInUser == null){
                        UserLoginDto userLoginDto =
                                new UserLoginDto(inputParams[1], inputParams[2]);

                        String loginResult = this.userService.loginUser(userLoginDto);

                        if(loginResult.contains("Successfully logged in")){
                            this.loggedInUser = userLoginDto.getEmail();
                        }

                        System.out.println(loginResult);

                    }else{
                        System.out.println("Session is taken.");
                    }


                    break;
                case "Logout":
                    break;
            }
        }
    }
}
