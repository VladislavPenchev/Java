package org.softuni.demo.web.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.websocket.server.PathParam;

@Controller
@RequestMapping("/users")
public class HomeController {

    @GetMapping("/")
    public ModelAndView index(ModelAndView model) {
        model.addObject("user", new User("pesho"));
        model.setViewName("index");

        return model;
    }

    @GetMapping(value = "/home", produces = "text/html")
    @ResponseBody
    public String home(@RequestParam(name = "name") String name) {
        return "<h1>Hello, " + name + "</h1>";
    }

}
