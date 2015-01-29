package com.ftzen.spring.services;

import org.springframework.beans.factory.annotation.Autowired;

/**
 * Created by  <a href="mailto:ranbir.chawla@14zen.com">Ranbir Chawla</a> on 1/27/15.
 */

public class TestCounterService implements  org.springframework.boot.actuate.metrics.CounterService {

    @Autowired
    private CounterStore counterStore;

    @Override
    public void increment(String s) {


        counterStore.increment(s);
    }

    @Override
    public void decrement(String s) {
       counterStore.decrement(s);
    }

    @Override
    public void reset(String s) {
        counterStore.reset(s);
    }

}
