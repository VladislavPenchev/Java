package com.penchev.exodia.web.controllers;

import com.penchev.exodia.domain.models.binding.ScheduleBindingModel;
import com.penchev.exodia.domain.models.sevice.ScheduleServiceModel;
import com.penchev.exodia.service.DocumentService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpSession;

@Controller
public class DocumentController {

    private final DocumentService documentService;
    private final ModelMapper modelMapper;

    @Autowired
    public DocumentController(DocumentService documentService, ModelMapper modelMapper) {
        this.documentService = documentService;
        this.modelMapper = modelMapper;
    }

    @GetMapping("/schedule")
    public ModelAndView schedule(ModelAndView modelAndView, HttpSession session){
        if(session.getAttribute("username") == null){
            modelAndView.setViewName("redirect:/login");
        }else {
            modelAndView.setViewName("schedule");
        }

        return modelAndView;

    }

    @PostMapping("/schedule")
    public ModelAndView scheduleConfirm(@ModelAttribute ScheduleBindingModel model, ModelAndView modelAndView){
        ScheduleServiceModel scheduleServiceModel = this.modelMapper.map(model, ScheduleServiceModel.class);

        this.documentService.scheduleImport(scheduleServiceModel);

        if(scheduleServiceModel == null){
            throw new IllegalArgumentException("Document creation failed!");
        }

        modelAndView.setViewName("redirect:/home");
        return modelAndView;
    }
}
