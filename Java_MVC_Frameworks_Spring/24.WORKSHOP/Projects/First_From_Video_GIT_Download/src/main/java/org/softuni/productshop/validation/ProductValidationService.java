package org.softuni.productshop.validation;

import org.softuni.productshop.domain.entities.Product;
import org.softuni.productshop.domain.models.service.ProductServiceModel;

public interface ProductValidationService {
    boolean isValid(Product product);

    boolean isValid(ProductServiceModel product);
}
