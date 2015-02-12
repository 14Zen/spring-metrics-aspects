package com.ftzen.spring.metrics.aspects;

import com.ftzen.spring.metrics.annotation.MetricTimer;
import com.ftzen.spring.metrics.config.ContainerPrefix;
import com.timgroup.statsd.StatsDClient;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
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

    @Autowired
    private ContainerPrefix containerPrefix;

    @Around("@annotation(metricTimer)")
    public Object runTimer(ProceedingJoinPoint pjp,MetricTimer metricTimer) throws Throwable {
        long startTime = System.currentTimeMillis();
        Object returnObj = pjp.proceed();
        Long totalTime = System.currentTimeMillis() - startTime;
        statsDClient.recordExecutionTime( containerPrefix.fullMetricName(metricTimer.value()),totalTime);
        return returnObj;
    }
}
