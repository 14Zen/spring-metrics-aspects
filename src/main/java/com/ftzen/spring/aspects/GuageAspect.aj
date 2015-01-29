package com.ftzen.spring.aspects;

import com.ftzen.spring.annotation.MetricTimer;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.actuate.metrics.GaugeService;
import org.springframework.stereotype.Component;
import org.springframework.util.Assert;

/**
 * Created by  <a href="mailto:ranbir.chawla@14zen.com">Ranbir Chawla</a> on 1/27/15.
 */

@Component
@Aspect
public aspect GuageAspect {

    @Autowired
    private GaugeService guageService;

    @Around("com.ftzen.spring.TestService.sitAndSleepThenReturnString")
    public Object runTimer(ProceedingJoinPoint pjp) throws Throwable {

  //      Assert.notNull(metricTimer);
        Assert.notNull(guageService);
//        String metricName = metricTimer.value();
        long startTime = System.currentTimeMillis();
        Object returnObj = pjp.proceed();
        long endTime = System.currentTimeMillis();
        Long totalTime = endTime - startTime;
 //       guageService.submit(metricName,totalTime.doubleValue());
        return returnObj;
    }

}
