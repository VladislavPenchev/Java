package org.softuni.productshop.web.controllers;

import org.softuni.productshop.domain.models.rest.ProductOrderRequesModel;
import org.softuni.productshop.service.OrderService;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;

@RestController
@RequestMapping("/api/order")
public class OrdersApiController {

    private final OrderService orderService;

    public OrdersApiController(OrderService orderService) {
        this.orderService = orderService;
    }

    @PostMapping("/submit")
    public void submitOrder(@RequestBody ProductOrderRequesModel model, Principal principal){
        String name = principal.getName();
        orderService.createOrder(model.getId(), name);
    }
}
