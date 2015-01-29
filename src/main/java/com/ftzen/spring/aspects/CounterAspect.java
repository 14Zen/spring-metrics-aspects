package com.ftzen.spring.aspects;

import com.ftzen.spring.annotation.FailureCounter;
import com.ftzen.spring.annotation.SuccessCounter;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.actuate.metrics.CounterService;
import org.springframework.stereotype.Component;
import org.springframework.util.Assert;

/**
 * Created by  <a href="mailto:ranbir.chawla@14zen.com">Ranbir Chawla</a> on 1/27/15.
 */

@Component
@Aspect
public class CounterAspect {

    @Autowired
    private CounterService counterService;

    @After("@annotation(successCounter)")
    public void countSuccess(SuccessCounter successCounter) throws Throwable {

        Assert.notNull(successCounter);
        String metricName = successCounter.value();
        counterService.increment(metricName);

    }

    @After("@annotation(failureCounter)")
    public void countFailure(FailureCounter failureCounter) throws Throwable {

        Assert.notNull(failureCounter);
        String metricName = failureCounter.value();
        counterService.increment(metricName);

    }

}
