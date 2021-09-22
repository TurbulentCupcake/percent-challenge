package com.percent.checkoutservice.api.model;

import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.util.List;

public class CheckoutRequest implements Serializable {

    @Getter @Setter
    private List<String> products;

}
