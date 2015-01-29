package com.ftzen.spring.services;

/**
 * Created by  <a href="mailto:ranbir.chawla@14zen.com">Ranbir Chawla</a> on 1/27/15.
 */

public interface CounterStore {

    public void increment(String s);

    public void decrement(String s);

    public void reset(String s);

    public int getCounterValue(String s);
}
