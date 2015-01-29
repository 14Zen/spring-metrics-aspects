package com.ftzen.spring.services;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by  <a href="mailto:ranbir.chawla@14zen.com">Ranbir Chawla</a> on 1/27/15.
 */

public class CounterStoreImpl implements CounterStore {

    private Map<String,Integer> counterMap = new HashMap<String, Integer>();

    @Override
    public void increment(String s) {
        Integer counter = counterMap.get(s);
        if(counter == null) {
            counter = new Integer(0);
        }
        counter++;
        counterMap.put(s,counter);
    }

    @Override
    public void decrement(String s) {
        Integer counter = counterMap.get(s);
        if(counter == null) {
            counter = new Integer(0);
        }
        counter--;
        counterMap.put(s,counter);
    }

    @Override
    public void reset(String s) {
        counterMap.put(s,0);

    }

    public int getCounterValue(String s) {
        Integer count = counterMap.get(s);
        if(count == null) return 0;
        else return count;
    }
}
