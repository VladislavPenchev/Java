package org.softuni.productshop.web.controllers;

import org.apache.tomcat.util.net.openssl.ciphers.Authentication;
import org.modelmapper.ModelMapper;
import org.softuni.productshop.domain.models.rest.ProductOrderRequesModel;
import org.softuni.productshop.domain.models.service.ProductServiceModel;
import org.softuni.productshop.domain.models.view.ProductDetailsViewModel;
import org.softuni.productshop.service.OrderService;
import org.softuni.productshop.service.ProductService;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.security.Principal;


@Controller
@RequestMapping("/orders")
public class OrdersController extends BaseController{

    private final ProductService productService;
    private final ModelMapper modelMapper;
    private final OrderService orderService;

    public OrdersController(ProductService productService, ModelMapper modelMapper, OrderService orderService) {
        this.productService = productService;
        this.modelMapper = modelMapper;
        this.orderService = orderService;
    }

    @GetMapping("/product/{id}")
    @PreAuthorize("isAuthenticated()")
    public ModelAndView orderProduct(@PathVariable String id, ModelAndView modelAndView){

        ProductServiceModel serviceModel = productService.findProductById(id);
        ProductDetailsViewModel viewModel = modelMapper.map(serviceModel, ProductDetailsViewModel.class);

        modelAndView.addObject("product", viewModel);

        return super.view("order/product", modelAndView);
    }

    @PostMapping("/submit")
    public void submitOrder(@ModelAttribute ProductOrderRequesModel model, Principal principal){
        String name = principal.getName();
        orderService.createOrder(model.getId(), name);
    }
}
