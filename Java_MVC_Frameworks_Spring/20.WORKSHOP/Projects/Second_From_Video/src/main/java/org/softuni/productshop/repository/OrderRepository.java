package org.softuni.productshop.repository;

import org.softuni.productshop.domain.entities.Order;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface OrderRepository extends JpaRepository<Order, String> {
    List<Order> findAllByUser_Username(String username);
}
