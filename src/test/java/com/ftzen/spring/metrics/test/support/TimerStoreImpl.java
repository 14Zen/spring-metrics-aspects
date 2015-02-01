package com.ftzen.spring.metrics.test.support;

import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by  <a href="mailto:ranbir.chawla@14zen.com">Ranbir Chawla</a> on 1/27/15.
 */
@Component
public class TimerStoreImpl implements TimerStore {

    private Map<String,Long> timerMap = new HashMap<String, Long>();

    public void recordExecutionTime(String s, long l) {
        timerMap.put(s, l);
    }

    public Long getTimeByMetricName(String s) {
        return timerMap.get(s);
    }
}
