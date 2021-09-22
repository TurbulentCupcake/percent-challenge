package com.percent.checkoutservice.testrunner;

import com.percent.checkoutservice.CheckoutServiceApplication;
import org.jsmart.zerocode.core.runner.ZeroCodeUnitRunner;
import org.junit.runners.model.InitializationError;

public class ZerocodeSpringBootRunner extends ZeroCodeUnitRunner {

    public static boolean appRunning = false;

    public ZerocodeSpringBootRunner(Class<?> klass) throws InitializationError {
        super(klass);
        if(!appRunning){
            CheckoutServiceApplication.start();
            appRunning = true;
        }
    }
}
