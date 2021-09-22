package com.percent.checkoutservice.integrationtests.get;

import com.percent.checkoutservice.testrunner.ZerocodeSpringBootRunner;
import org.jsmart.zerocode.core.domain.Scenario;
import org.jsmart.zerocode.core.domain.TargetEnv;
import org.junit.Test;
import org.junit.runner.RunWith;

@TargetEnv("checkoutservice_zerocode.properties")
@RunWith(ZerocodeSpringBootRunner.class)
public class VerifyAllProductPrices {

    @Test
    @Scenario("integration_tests/get/verifyGet_ProductCodeA.json")
    public void verifyGet_ProductCodeA() {

    }

    @Test
    @Scenario("integration_tests/get/verifyGet_ProductCodeB.json")
    public void verifyGet_ProductCodeB() {

    }

    @Test
    @Scenario("integration_tests/get/verifyGet_ProductCodeC.json")
    public void verifyGet_ProductCodeC() {

    }

    @Test
    @Scenario("integration_tests/get/verifyGet_ProductCodeD.json")
    public void verifyGet_ProductCodeD() {

    }

}
