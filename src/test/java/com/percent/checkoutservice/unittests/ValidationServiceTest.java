package com.percent.checkoutservice.unittests;

import com.percent.checkoutservice.CheckoutServiceApplication;
import com.percent.checkoutservice.api.model.CheckoutRequest;
import com.percent.checkoutservice.exception.ValidationException;
import com.percent.checkoutservice.service.ValidationService;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.tukaani.xz.check.Check;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = {CheckoutServiceApplication.class}, webEnvironment = SpringBootTest.WebEnvironment.DEFINED_PORT)
public class ValidationServiceTest {

    @Autowired
    private ValidationService validationService;

    @Autowired
    private TestCommons testCommons;

    @Test
    public void testCleanRequest() {

        CheckoutRequest checkoutRequest = new CheckoutRequest();
        checkoutRequest.setProducts(Arrays.asList("a", "b", "c"));
        validationService.cleanRequest(checkoutRequest);
        Assert.assertTrue(checkoutRequest.getProducts().containsAll(Arrays.asList("A","B","C")));

    }

    @Test(expected = ValidationException.class)
    public void testEmptyList() throws ValidationException {

        CheckoutRequest checkoutRequest = new CheckoutRequest();
        checkoutRequest.setProducts(new ArrayList<>());
        validationService.validateRequest(checkoutRequest,  "1234");

    }

    @Test(expected = ValidationException.class)
    public void testMaxListSize() throws ValidationException {

        List<String> productCodes = testCommons.generateProductList("B", 101);

        CheckoutRequest checkoutRequest = new CheckoutRequest();
        checkoutRequest.setProducts(productCodes);
        validationService.validateRequest(checkoutRequest,  "1234");

    }

    @Test(expected = ValidationException.class)
    public void testInvalidProductCode() throws ValidationException {

        List<String> productCodes = testCommons.generateProductList("X", 99);

        CheckoutRequest checkoutRequest = new CheckoutRequest();
        checkoutRequest.setProducts(productCodes);
        validationService.validateRequest(checkoutRequest,  "1234");

    }


}
