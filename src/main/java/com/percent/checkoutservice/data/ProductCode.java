package com.percent.checkoutservice.data;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@ToString
public class ProductCode {

    @Getter @Setter
    private Double unitPrice;

    @Getter @Setter
    private VolumePrice volumePrice;

}