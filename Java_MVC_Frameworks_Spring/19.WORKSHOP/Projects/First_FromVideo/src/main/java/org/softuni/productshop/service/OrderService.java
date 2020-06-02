package org.softuni.productshop.service;

import javax.persistence.criteria.Order;

public interface OrderService {


    void createOrder(String productId, String name);
}
