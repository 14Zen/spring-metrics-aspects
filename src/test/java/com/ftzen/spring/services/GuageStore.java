package com.ftzen.spring.services;

import java.util.List;

/**
 * Created by  <a href="mailto:ranbir.chawla@14zen.com">Ranbir Chawla</a> on 1/27/15.
 */

public interface GuageStore {

    void submit(String s, double v);

    List<Double> getTimeByMetricName(String s);
}
