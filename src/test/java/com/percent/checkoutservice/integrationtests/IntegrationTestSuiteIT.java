package com.percent.checkoutservice.integrationtests;


import com.percent.checkoutservice.testrunner.ZerocodeSpringBootSuite;
import org.jsmart.zerocode.core.domain.TargetEnv;
import org.jsmart.zerocode.core.domain.TestPackageRoot;
import org.junit.runner.RunWith;


@TargetEnv("checkoutservice_zerocode.properties")
@TestPackageRoot("integration_tests") //picks all tests from this folder and subfolders
@RunWith(ZerocodeSpringBootSuite.class)
public class IntegrationTestSuiteIT {

}
