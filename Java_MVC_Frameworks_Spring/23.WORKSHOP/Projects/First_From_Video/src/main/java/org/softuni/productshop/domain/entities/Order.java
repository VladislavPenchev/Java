package org.softuni.productshop.domain.entities;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

@Entity
@Table(name = "orders")
public class Order extends BaseEntity {
    private List<Product> products;
    private User cutomer;
    private BigDecimal totalPrice;
    private LocalDateTime finishedOn;

    public Order() {
    }

    @ManyToMany(targetEntity = Product.class)
    @JoinTable(
            name = "orders_products",
            joinColumns = @JoinColumn(name = "order_id", referencedColumnName = "id"),
            inverseJoinColumns = @JoinColumn(name = "product_id", referencedColumnName = "id")
    )
    public List<Product> getProducts() {
        return products;
    }

    public void setProducts(List<Product> products) {
        this.products = products;
    }

    @ManyToOne(targetEntity = User.class)
    @JoinColumn(name = "customer_id", referencedColumnName = "id")
    public User getCutomer() {
        return cutomer;
    }

    public void setCutomer(User cutomer) {
        this.cutomer = cutomer;
    }

    @Column(name = "total_price")
    public BigDecimal getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(BigDecimal totalPrice) {
        this.totalPrice = totalPrice;
    }

    @Column(name = "finished_on")
    public LocalDateTime getFinishedOn() {
        return finishedOn;
    }

    public void setFinishedOn(LocalDateTime finishedOn) {
        this.finishedOn = finishedOn;
    }
}