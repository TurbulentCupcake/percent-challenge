package com.percent.checkoutservice.unittests;

import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class TestCommons {

    public List<String> generateProductList(String code, int qty) {

        List<String> productCodes = new ArrayList<>();
        for(int i = 0 ; i < qty ; i++) {
            productCodes.add(code);
        }
        return productCodes;

    }

}
