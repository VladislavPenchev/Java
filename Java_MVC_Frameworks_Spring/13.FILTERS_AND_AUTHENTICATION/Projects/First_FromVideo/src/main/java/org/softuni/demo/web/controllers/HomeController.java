package org.softuni.demo.web.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.ArrayList;

@RestController
public class HomeController {
    @GetMapping(value = "/", produces = "application/json")
    public Object index() {
        return new ArrayList<String>() {{
            add("pesho");
            add("gosho");
            add("tosho");

        }};
    }

    @GetMapping("/login")
    public Object home(){

        return "Pesho";
    }

    @GetMapping("/home")
    public Object home(HttpSession session, ModelAndView modelAndView) {

        modelAndView.addObject("username", session.getAttribute("username"));

        return "Hello, " + session.getAttribute("username");
    }

}
