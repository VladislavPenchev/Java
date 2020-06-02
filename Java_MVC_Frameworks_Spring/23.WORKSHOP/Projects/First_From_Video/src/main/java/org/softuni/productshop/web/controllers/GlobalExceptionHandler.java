package org.softuni.productshop.web.controllers;

import org.softuni.productshop.error.ProductNotForundException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.ModelAndView;

@ControllerAdvice
public class GlobalExceptionHandler extends BaseController{

    @ExceptionHandler({ProductNotForundException.class})
    public ModelAndView handleProductNotFound(RuntimeException e) {
        ModelAndView modelAndView = new ModelAndView("error");
        modelAndView.addObject("message", e.getMessage());
        return modelAndView;
    }

    @ExceptionHandler({Throwable.class})
    public ModelAndView handleSqlException(Throwable e){
        ModelAndView modelAndView = new ModelAndView("error");

        Throwable throwable = e;
        while(throwable.getCause() != null) {
            throwable = throwable.getCause();
        }

        modelAndView.addObject("message", throwable.getMessage());
        return modelAndView;
    }

}
