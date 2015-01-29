package com.ftzen.spring.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.actuate.metrics.GaugeService;
import org.springframework.stereotype.Component;

/**
 * Created by  <a href="mailto:ranbir.chawla@14zen.com">Ranbir Chawla</a> on 1/27/15.
 */

@Component
public class TestGuageService implements GaugeService {

    @Autowired
    private GuageStore guageStore;

    @Override
    public void submit(String s, double v) {
        guageStore.submit(s,v);
    }

}
