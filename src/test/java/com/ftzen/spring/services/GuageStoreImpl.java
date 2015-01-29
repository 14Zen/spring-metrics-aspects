package com.ftzen.spring.services;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by  <a href="mailto:ranbir.chawla@14zen.com">Ranbir Chawla</a> on 1/27/15.
 */

public class GuageStoreImpl implements  GuageStore {

    private Map<String,List<Double>> guageMap = new HashMap<String,List<Double>>();

    @Override
    public void submit(String s, double v) {
        List<Double> valueList = guageMap.get(s);
        if(valueList == null) {
            valueList = new ArrayList<Double>();
        }
        valueList.add(v);
        guageMap.put(s,valueList);
    }

    public List<Double> getTimeByMetricName(String s) {
        return guageMap.get(s);
    }
}
