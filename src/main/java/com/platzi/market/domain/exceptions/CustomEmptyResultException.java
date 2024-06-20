package com.platzi.market.domain.exceptions;

public class CustomEmptyResultException extends RuntimeException {
    public CustomEmptyResultException(long id) {
        super(String.format("Item with id %d not found in database.", id));
    }

    public CustomEmptyResultException(String message, Throwable cause) {
        super(message, cause);
    }

}
