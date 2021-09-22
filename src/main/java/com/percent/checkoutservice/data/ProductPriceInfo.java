package com.percent.checkoutservice.data;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

import java.util.Map;

@Component
@ConfigurationProperties(prefix = "productpriceinfo")
@ToString
public class ProductPriceInfo {

    @Getter @Setter
    private Map<String, ProductCode> products;



}
