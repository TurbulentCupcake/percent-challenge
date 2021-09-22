package com.percent.checkoutservice.service;

import com.percent.checkoutservice.data.ProductCode;
import com.percent.checkoutservice.data.ProductPriceInfo;
import com.percent.checkoutservice.data.VolumePrice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 *  Service to compute total price for set of products
 */

@Component
public class CalculationService {

    @Autowired
    private ProductPriceInfo productPriceInfo;

    /**
     * Calculates total price for a list of products.
     * @param productList
     * @return total
     */
    public Double calculateTotal(List<String> productList) {

        if(productList.size() == 0)
            return 0.0;

        // create map to track counts of each product
        Map<String, Integer> productCounts = new HashMap<>();

        // populate map with counts
        for(String code : productList) {
            productCounts.putIfAbsent(code, 0);
            productCounts.put(code, productCounts.get(code) + 1);
        }

        double total = 0.0;

        for(String code : productCounts.keySet()) {

            int pCount = productCounts.get(code);
            ProductCode productCode = productPriceInfo.getProducts().get(code);
            VolumePrice pVolPrice = productPriceInfo.getProducts().get(code).getVolumePrice();

            // provide volume pricing if customer orders quantity
            // at least equal to volume pricing quantity
            if(pVolPrice.getIsVolumePricingAvailable() && pCount >= pVolPrice.getQty()) {

                // determine number of times to provide volume pricing
                int vFactor = pCount / pVolPrice.getQty();

                // add to total pricing
                total += vFactor * pVolPrice.getPrice();

                // deduct count for product already accounted for in volume pricing
                pCount -= vFactor * pVolPrice.getQty();

            }

            // provide unit pricing for product not accounted for in volume pricing
            total += pCount * productCode.getUnitPrice();

        }

        return total;
    }



}

