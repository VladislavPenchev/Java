package org.softuni.productshop.domain.models.view;

import org.softuni.productshop.domain.entities.Category;

import java.math.BigDecimal;
import java.util.List;

public class ProductDetailsViewModel {
    private String id;
    private String name;
    private String description;
    private BigDecimal price;
    private String imageUrl;

    public ProductDetailsViewModel() {
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }
}
