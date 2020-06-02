package org.softuni.demo.web.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class HomeController {

    @GetMapping("/")
    public ModelAndView index(ModelAndView model){
        model.addObject("user", new User("pesho", "pesho@pesho.pesho", 3));

        model.setViewName("index");

        return model;
    }

    @GetMapping("/home")
    @ResponseBody
    public String home(){
        return "HI FROM HOME";
    }
}
