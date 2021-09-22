package com.percent.checkoutservice.api.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;

@NoArgsConstructor
@AllArgsConstructor
public class CheckoutFailure implements Serializable {

    @Getter @Setter
    private String Id;

    @Getter @Setter
    private String message;


}
