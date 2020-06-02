package com.minkov.springintroapp.web;


import com.minkov.springintroapp.viewmodels.WhiskeyModel;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;
import java.util.Date;


@Controller
public class WhiskeyController {
    @GetMapping("/dates")
    public ModelAndView getDate(ModelAndView modelAndView) {
        Date today = new Date();
        Date tomorrow = new Date(new Date().getTime() + (1000 * 60 * 60 * 24));
        modelAndView.addObject("dates", new Date[]{
                today,
                tomorrow
        });
        modelAndView.addObject("date", today);
        modelAndView.setViewName("dates");

        modelAndView.addObject("numbers", new int[]{1, 2, 3});

        modelAndView.addObject("username", "Doncho");

        return modelAndView;
    }

//    @GetMapping("/whiskey")
//    public String getAddWhiskeyForm(@ModelAttribute WhiskeyModel whiskey) {
//        return "add";
//    }

    @ModelAttribute("whiskey")
    public WhiskeyModel returnWhiskeyModel(){
        return new WhiskeyModel();
    }

    @GetMapping("/whiskey")
    public ModelAndView getAddWhiskeyForm(){
        return new ModelAndView("add", "whiskey", new WhiskeyModel());
    }

    @PostMapping("/whiskey")
    public String addWhiskey(@Valid @ModelAttribute("whiskey") WhiskeyModel whiskey, BindingResult bindingResult){
        boolean hasErrors = bindingResult.hasErrors();
        if(hasErrors){
            modelAndView.setViewName("add");
        }

        int b = 5;
        return new ModelAndView("redirect:/");
    }

}
