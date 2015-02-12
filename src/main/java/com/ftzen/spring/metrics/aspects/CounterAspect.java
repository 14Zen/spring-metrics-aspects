package com.ftzen.spring.metrics.aspects;

import com.ftzen.spring.metrics.annotation.FailureCounter;
import com.ftzen.spring.metrics.annotation.SuccessCounter;
import com.ftzen.spring.metrics.config.ContainerPrefix;
import com.timgroup.statsd.StatsDClient;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * Created by  <a href="mailto:ranbir.chawla@14zen.com">Ranbir Chawla</a> on 1/27/15.
 */

@Component
@Aspect
public class CounterAspect {

    @Autowired
    ContainerPrefix containerPrefix;

    @Autowired
    private StatsDClient statsDClient;

    @After("@annotation(successCounter)")
    public void countSuccess(SuccessCounter successCounter) throws Throwable {
        statsDClient.increment(containerPrefix.fullMetricName(successCounter.value()));
    }

    @After("@annotation(failureCounter)")
    public void countFailure(FailureCounter failureCounter) throws Throwable {
        statsDClient.increment(containerPrefix.fullMetricName(failureCounter.value()));
    }

}
