package com.ftzen.spring;

import com.ftzen.spring.metrics.annotation.FailureCounter;
import com.ftzen.spring.metrics.annotation.MetricTimer;
import com.ftzen.spring.metrics.annotation.SuccessCounter;
import org.springframework.stereotype.Component;

/**
 * Created by  <a href="mailto:ranbir.chawla@14zen.com">Ranbir Chawla</a> on 1/27/15.
 */

@Component
public class TestService {

    @SuccessCounter("test.metric.sleep.success")
    @MetricTimer("test.metric.counter")
    public String sitAndSleepThenReturnString() throws Exception {

        String retStr = "HI";
        Thread.sleep(1500);
        return retStr;
    }

    @SuccessCounter("test.metric.brittney.success")
    public void oopsIDidItAgain() {
        int i = 1 + 1;
    }

    @FailureCounter("test.metric.cbrown.failure")
    public void dangNabIt() {
        int i = 0;
    }
}
