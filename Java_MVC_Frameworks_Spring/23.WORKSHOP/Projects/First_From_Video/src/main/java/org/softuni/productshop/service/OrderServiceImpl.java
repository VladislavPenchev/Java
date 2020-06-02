package org.softuni.productshop.service;

import org.modelmapper.ModelMapper;
import org.softuni.productshop.domain.entities.Order;
import org.softuni.productshop.domain.models.service.OrderServiceModel;
import org.softuni.productshop.repository.OrderRepository;
import org.softuni.productshop.repository.ProductRepository;
import org.softuni.productshop.validation.ProductValidationService;
import org.softuni.productshop.validation.UserValidationService;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class OrderServiceImpl implements OrderService {
    private final OrderRepository orderRepository;
    private final ProductRepository productRepository;
    private final UserService userService;
    private final ModelMapper modelMapper;
    private final UserValidationService userValidation;
    private final ProductValidationService productValidation;

    public OrderServiceImpl(
            OrderRepository orderRepository,
            ProductRepository productRepository,
            UserService userService,
            UserValidationService userValidation,
            ProductValidationService productValidation,
            ModelMapper mapper
    ) {
        this.orderRepository = orderRepository;
        this.productRepository = productRepository;
        this.userService = userService;
        this.userValidation = userValidation;
        this.productValidation = productValidation;
        this.modelMapper = mapper;
    }

    @Override
    public void createOrder(OrderServiceModel orderServiceModel) {
        orderServiceModel.setFinishedOn(LocalDateTime.now());

        this.orderRepository.saveAndFlush(this.modelMapper.map(orderServiceModel, Order.class));
    }

    @Override
    public List<OrderServiceModel> findAllOrders() {
        return orderRepository.findAll()
                .stream()
                .map(o -> modelMapper.map(o, OrderServiceModel.class))
                .collect(Collectors.toList());
    }

    @Override
    public List<OrderServiceModel> findOrdersByCustomer(String username) {
//        return orderRepository.findAllByUser_Username(username)
//                .stream()
//                .map(o -> mapper.map(o, OrderServiceModel.class))
//                .collect(Collectors.toList());

        return new LinkedList<>();
    }
}
