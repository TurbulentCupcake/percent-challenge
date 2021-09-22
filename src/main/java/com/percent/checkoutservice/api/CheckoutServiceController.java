package com.percent.checkoutservice.api;

import com.percent.checkoutservice.api.model.*;
import com.percent.checkoutservice.api.model.Error;
import com.percent.checkoutservice.data.ProductCode;
import com.percent.checkoutservice.data.ProductPriceInfo;
import com.percent.checkoutservice.exception.ValidationException;
import com.percent.checkoutservice.service.CalculationService;
import com.percent.checkoutservice.service.ValidationService;
import org.apache.commons.lang3.exception.ExceptionUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MissingRequestHeaderException;
import org.springframework.web.bind.annotation.*;

@RestController
public class CheckoutServiceController {

    @Autowired
    private ValidationService validationService;

    @Autowired
    private CalculationService calculationService;

    @Autowired
    private ProductPriceInfo productPriceInfo;

    @PostMapping("/calculatetotal")
    public ResponseEntity calculateTotal (
            @RequestHeader(value = "Id") String requestId,
            @RequestBody CheckoutRequest checkoutRequest
    ) {

        double total;
        try {

            validationService.validateRequest(checkoutRequest, requestId);

            validationService.cleanRequest(checkoutRequest);

            total = calculationService.calculateTotal(checkoutRequest.getProducts());

        } catch (ValidationException validationException) {

            return new ResponseEntity(new CheckoutFailure(requestId, validationException.getMessage()),
                    HttpStatus.BAD_REQUEST);

        } catch (Exception ex) {

            return new ResponseEntity(new Error("Unexpected error occured. More info: " + ExceptionUtils.getStackTrace(ex)),
                    HttpStatus.INTERNAL_SERVER_ERROR);

        }

        return new ResponseEntity(new CheckoutSuccessful(requestId, total), HttpStatus.OK);

    }

    @GetMapping("/price/{productCode}")
    public ResponseEntity getProductPrice(@PathVariable String productCode) {

        if(!validationService.validateProductCode(productCode.toUpperCase())) {
            return new ResponseEntity(new Error("Invalid product code. Acceptable products are [A, B, C, D]"), HttpStatus.BAD_REQUEST);
        }

        ProductCode pCode = productPriceInfo.getProducts().get(productCode.toUpperCase());

        return new ResponseEntity(
                new ProductPrice(
                        pCode.getUnitPrice(),
                        pCode.getVolumePrice().getPrice(),
                        pCode.getVolumePrice().getQty()),
                HttpStatus.OK);

    }

    @ExceptionHandler(MissingRequestHeaderException.class)
    public ResponseEntity handleMissingId(MissingRequestHeaderException ex) {
        return new ResponseEntity(new Error(ex.getMessage()), HttpStatus.BAD_REQUEST);
    }

}
