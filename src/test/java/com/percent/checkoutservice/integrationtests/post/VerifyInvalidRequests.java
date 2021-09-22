package com.percent.checkoutservice.integrationtests.post;

import com.percent.checkoutservice.testrunner.ZerocodeSpringBootRunner;
import org.jsmart.zerocode.core.domain.Scenario;
import org.jsmart.zerocode.core.domain.TargetEnv;
import org.junit.Test;
import org.junit.runner.RunWith;

@TargetEnv("checkoutservice_zerocode.properties")
@RunWith(ZerocodeSpringBootRunner.class)
public class VerifyInvalidRequests {

    @Test
    @Scenario("integration_tests/post/verifyInvalidProductCode.json")
    public void test_verifyInvalidProductCode() throws Exception {
    }

    @Test
    @Scenario("integration_tests/post/verifyEmptyProductList.json")
    public void test_verifyEmptyProductList() throws Exception {
    }

    @Test
    @Scenario("integration_tests/post/verifyExceededProductList.json")
    public void test_verifyExceededProductList() throws Exception {
    }

    @Test
    @Scenario("integration_tests/post/verifyMissingHeader.json")
    public void test_verifyMissingHeader() throws Exception {
    }

}
