package com.percent.checkoutservice.api.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

@AllArgsConstructor
public class ProductPrice implements Serializable {

    @Getter @Setter
    private double unitPrice;

    @Getter @Setter
    private double volumePrice;

    @Getter @Setter
    private int volumeQty;

}
