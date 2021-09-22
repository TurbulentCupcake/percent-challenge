package com.percent.checkoutservice.data;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@ToString
public class VolumePrice {

    @Getter @Setter
    private Boolean isVolumePricingAvailable;

    @Getter @Setter
    private Double price;

    @Getter @Setter
    private Integer qty;

}
