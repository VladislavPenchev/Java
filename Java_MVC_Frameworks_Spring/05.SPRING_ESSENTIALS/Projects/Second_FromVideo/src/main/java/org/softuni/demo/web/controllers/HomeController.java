package org.softuni.demo.web.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpSession;


@Controller
public class HomeController extends BaseController {

    @GetMapping("/")
    public ModelAndView index(ModelAndView model){

        return  this.view("index", model);
    }

    @GetMapping(value = "/home", produces = "text/html")

    public ModelAndView home(HttpSession session){
        if(!isLoggedIn(session)) return this.redirect("/users/login");

        return this.view("home");
    }

}
