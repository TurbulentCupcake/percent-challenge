package com.percent.checkoutservice.integrationtests.get;

import com.percent.checkoutservice.testrunner.ZerocodeSpringBootRunner;
import org.jsmart.zerocode.core.domain.Scenario;
import org.jsmart.zerocode.core.domain.TargetEnv;
import org.junit.Test;
import org.junit.runner.RunWith;

@TargetEnv("checkoutservice_zerocode.properties")
@RunWith(ZerocodeSpringBootRunner.class)
public class VerifyInvalidGetRequests {

    @Test
    @Scenario("integration_tests/get/verifyGet_InvalidProductCode.json")
    public void testGet_verifyInvalidProductCode() {
    }

    @Test
    @Scenario("integration_tests/get/verifyGet_emptyProductCode.json")
    public void testGet_verifyEmptyProductCode() {
    }

}
