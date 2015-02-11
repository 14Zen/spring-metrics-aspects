package com.ftzen.spring.metrics.aspects;

import com.ftzen.spring.metrics.annotation.MetricTimer;
import com.timgroup.statsd.StatsDClient;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * Created by ranbir on 1/30/15.
 */

@Component
@Aspect
public class TimerAspect {

    @Autowired
    private StatsDClient statsDClient;

    @Around("@annotation(metricTimer)")
    public Object runTimer(ProceedingJoinPoint pjp,MetricTimer metricTimer) throws Throwable {
        long startTime = System.currentTimeMillis();
        Object returnObj = pjp.proceed();
        Long totalTime = System.currentTimeMillis() - startTime;
        statsDClient.recordExecutionTime( metricTimer.value(),totalTime);
        return returnObj;
    }
}
