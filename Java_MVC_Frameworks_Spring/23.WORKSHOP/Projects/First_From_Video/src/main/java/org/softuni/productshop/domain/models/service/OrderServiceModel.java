package org.softuni.productshop.domain.models.service;

import org.modelmapper.ModelMapper;
import org.softuni.productshop.domain.entities.Order;
import org.softuni.productshop.domain.entities.Product;
import org.softuni.productshop.domain.entities.User;
import org.softuni.productshop.mappings.IHaveCustomMappings;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

public class OrderServiceModel extends BaseServiceModel{
    private List<ProductServiceModel> products;
    private UserServiceModel cutomer;
    private BigDecimal totalPrice;
    private LocalDateTime finishedOn;

    public OrderServiceModel() {
    }

    public List<ProductServiceModel> getProducts() {
        return products;
    }

    public void setProducts(List<ProductServiceModel> products) {
        this.products = products;
    }

    public UserServiceModel getCutomer() {
        return cutomer;
    }

    public void setCutomer(UserServiceModel cutomer) {
        this.cutomer = cutomer;
    }

    public BigDecimal getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(BigDecimal totalPrice) {
        this.totalPrice = totalPrice;
    }

    public LocalDateTime getFinishedOn() {
        return finishedOn;
    }

    public void setFinishedOn(LocalDateTime finishedOn) {
        this.finishedOn = finishedOn;
    }
}
