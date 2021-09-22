package com.percent.checkoutservice.service;

import com.percent.checkoutservice.api.model.CheckoutRequest;
import com.percent.checkoutservice.data.ProductPriceInfo;
import com.percent.checkoutservice.exception.ValidationException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class ValidationService {

    @Autowired
    private ProductPriceInfo productPriceInfo;

    /**
     * Performs request cleanup
     * @param checkoutRequest
     */
    public void cleanRequest(CheckoutRequest checkoutRequest) {

        // convert all product codes to upper case
        List<String> ucProductCodes = checkoutRequest.getProducts().stream().map(String::toUpperCase).collect(Collectors.toList());
        checkoutRequest.setProducts(ucProductCodes);
    }

    /**
     * Validates a checkout request to ensure it can be processed by application
     * @param checkoutRequest
     * @param requestId
     * @throws ValidationException
     */
    public void validateRequest(CheckoutRequest checkoutRequest, String requestId) throws ValidationException {

        if(requestId.isEmpty())
            throw new ValidationException("Provide a non-empty request id");

        if(checkoutRequest.getProducts().size() == 0)
            throw new ValidationException("Product list provided is empty", requestId);

        if(checkoutRequest.getProducts().size() > 100)
            throw new ValidationException("Please limit number of products to 100 or below", requestId);

        // if product code is not contained within set list of product codes, throw exception
        for(String productCode : checkoutRequest.getProducts()) {
            if(!validateProductCode(productCode.toUpperCase()))
                throw new ValidationException("Invalid products in product list. Acceptable products are [A, B, C, D]", requestId);
        }

    }

    /**
     * Returns true if valid productCode, otherwise false
     * @param productCode
     * @return
     */
    public boolean validateProductCode(String productCode)  {
        return productCode != null && !productCode.isEmpty() && productPriceInfo.getProducts().containsKey(productCode);
    }

}
