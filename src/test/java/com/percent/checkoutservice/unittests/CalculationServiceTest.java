package com.percent.checkoutservice.unittests;

import com.percent.checkoutservice.CheckoutServiceApplication;
import com.percent.checkoutservice.service.CalculationService;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = {CheckoutServiceApplication.class}, webEnvironment = SpringBootTest.WebEnvironment.DEFINED_PORT)
public class CalculationServiceTest {

    @Autowired
    private CalculationService calculationService;

    @Autowired
    private TestCommons testCommons;

    @Test
    public void testEmptyProductList() {
        double total = calculationService.calculateTotal(new ArrayList<>());
        Assert.assertEquals(0.0, total, 0.0);
    }

    @Test
    public void testVolumePricingForProductA() {

        List<String> productCodes = testCommons.generateProductList("A", 39);
        double total = calculationService.calculateTotal(productCodes);
        Assert.assertEquals(39.00, total, 0.0);
    }

    @Test
    public void testMultipleForProductB() {

        List<String> productCodes = testCommons.generateProductList("B", 3);
        double total = calculationService.calculateTotal(productCodes);
        Assert.assertEquals(12.75, total, 0.0);
    }

    @Test
    public void testVolumePricingForProductC() {

        List<String> productCodes = testCommons.generateProductList("C", 18);
        double total = calculationService.calculateTotal(productCodes);
        Assert.assertEquals(15.00, total, 0.0);
    }

    @Test
    public void testVolumePricingForProductD() {

        List<String> productCodes = testCommons.generateProductList("D", 10);
        double total = calculationService.calculateTotal(productCodes);
        Assert.assertEquals(7.5, total, 0.0);
    }

    @Test
    public void testMixOfProductCodes() {

        List<String> pcA = testCommons.generateProductList("A", 13);
        List<String> pcB = testCommons.generateProductList("B", 15);
        List<String> pcC = testCommons.generateProductList("C", 30);
        List<String> pcD = testCommons.generateProductList("D", 12);
        List<String> combinedList = Stream.of(pcA, pcB, pcC, pcD).flatMap(Collection::stream).collect(Collectors.toList());

        double total = calculationService.calculateTotal(combinedList);
        Assert.assertEquals(111.0, total, 0.0);

    }



}
