package org.softuni.productshop.error;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.CONFLICT, reason = "Product name exists.")
public class ProductNameAlreadyExistException extends RuntimeException{
    private int statusCode;

    public ProductNameAlreadyExistException() {
        this.statusCode = 409;
    }

    public ProductNameAlreadyExistException(String message) {
        super(message);
        this.statusCode = 409;
    }

    public int getStatusCode() {
        return statusCode;
    }

    public void setStatusCode(int statusCode) {
        this.statusCode = statusCode;
    }
}
