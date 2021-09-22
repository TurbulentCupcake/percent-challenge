package com.percent.checkoutservice.integrationtests.post;

import com.percent.checkoutservice.testrunner.ZerocodeSpringBootRunner;
import org.jsmart.zerocode.core.domain.Scenario;
import org.jsmart.zerocode.core.domain.TargetEnv;
import org.junit.Test;
import org.junit.runner.RunWith;

@TargetEnv("checkoutservice_zerocode.properties")
@RunWith(ZerocodeSpringBootRunner.class)
public class VerifyExamples {

    @Test
    @Scenario("integration_tests/post/post_example1.json")
    public void testExample1() throws Exception {
    }

    @Test
    @Scenario("integration_tests/post/post_example2.json")
    public void testExample2() throws Exception {
    }

    @Test
    @Scenario("integration_tests/post/post_example3.json")
    public void testExample3() throws Exception {
    }

    @Test
    @Scenario("integration_tests/post/post_example4.json")
    public void testExample4() throws Exception {
    }

    @Test
    @Scenario("integration_tests/post/post_example5.json")
    public void testExample5() throws Exception {
    }

    @Test
    @Scenario("integration_tests/post/post_example6.json")
    public void testExample6() throws Exception {
    }


}
