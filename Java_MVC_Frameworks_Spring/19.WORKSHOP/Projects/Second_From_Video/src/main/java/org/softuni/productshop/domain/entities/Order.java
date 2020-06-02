package org.softuni.productshop.domain.entities;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;

@Entity(name = "orders")
public class Order extends BaseEntity{

    Product product;
    User user;

    public Order() {
    }

    @ManyToOne
    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    @ManyToOne
    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
