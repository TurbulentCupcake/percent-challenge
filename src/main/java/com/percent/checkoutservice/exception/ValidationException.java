package com.percent.checkoutservice.exception;

import lombok.Getter;
import lombok.Setter;

public class ValidationException extends Exception {

    @Getter
    @Setter
    private String id;

    public ValidationException(String message, String id) {
        super(message);
        this.id = id;
    }

    public ValidationException(String message) {
        super(message);
    }
}
