package org.softuni.productshop.repository;

import org.softuni.productshop.domain.entities.Order;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderRepository extends JpaRepository<Order, String> {
}
