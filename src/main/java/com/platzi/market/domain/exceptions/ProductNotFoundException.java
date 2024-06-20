package com.platzi.market.domain.exceptions;

public class ProductNotFoundException extends RuntimeException {

    public ProductNotFoundException(long id) {
        super(String.format("Item with id %d not found in database.", id));
    }

}
