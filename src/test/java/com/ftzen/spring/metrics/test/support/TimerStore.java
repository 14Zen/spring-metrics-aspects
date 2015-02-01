package com.ftzen.spring.metrics.test.support;

/**
 * Created by  <a href="mailto:ranbir.chawla@14zen.com">Ranbir Chawla</a> on 1/27/15.
 */

public interface TimerStore {

    void recordExecutionTime(String s, long l);
    Long getTimeByMetricName(String s);
}
