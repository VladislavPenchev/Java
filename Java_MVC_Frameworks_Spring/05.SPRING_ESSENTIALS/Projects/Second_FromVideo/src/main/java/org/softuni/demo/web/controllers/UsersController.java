package org.softuni.demo.web.controllers;

import com.fasterxml.jackson.databind.ser.Serializers;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpSession;

@Controller
public class UsersController extends BaseController {
    @GetMapping("/login")
    public ModelAndView login(){
        return this.view("login");
    }

    @PostMapping("/login")
    public ModelAndView LoginConfirm(@ModelAttribute User user, HttpSession session){
        session.setAttribute("user", user);

        if(!isLoggedIn(session)) return this.redirect("/users/login");

        return this.redirect("/home");
    }
}
