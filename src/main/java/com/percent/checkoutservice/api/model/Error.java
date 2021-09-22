package com.percent.checkoutservice.api.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

@AllArgsConstructor
public class Error implements Serializable {

    @Getter
    @Setter
    private String message;

}
