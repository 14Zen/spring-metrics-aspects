package com.ftzen.spring.metrics.test.support;

import com.timgroup.statsd.StatsDClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * Created by ranbir on 1/30/15.
 */
@Component
public class MockStatsDClient implements StatsDClient {

    @Autowired
    private CounterStore counterStore;

    @Autowired
    TimerStore timerStore;

    @Override
    public void stop() {

    }

    @Override
    public void count(String s, long l) {

    }

    @Override
    public void count(String s, long l, double v) {

    }

    @Override
    public void incrementCounter(String s) {

    }

    @Override
    public void increment(String s) {
        counterStore.increment(s);

    }

    @Override
    public void decrementCounter(String s) {

    }

    @Override
    public void decrement(String s) {
        counterStore.decrement(s);
    }

    @Override
    public void recordGaugeValue(String s, long l) {

    }

    @Override
    public void recordGaugeDelta(String s, long l) {

    }

    @Override
    public void gauge(String s, long l) {

    }

    @Override
    public void recordSetEvent(String s, String s1) {

    }

    @Override
    public void set(String s, String s1) {

    }

    @Override
    public void recordExecutionTime(String s, long l) {
        timerStore.recordExecutionTime(s,l);
    }

    @Override
    public void recordExecutionTime(String s, long l, double v) {

    }

    @Override
    public void recordExecutionTimeToNow(String s, long l) {

    }

    @Override
    public void time(String s, long l) {

    }
}
