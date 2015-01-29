package com.ftzen.spring;

import com.ftzen.spring.services.CounterStore;
import com.ftzen.spring.services.CounterStoreImpl;
import com.ftzen.spring.services.GuageStore;
import com.ftzen.spring.services.GuageStoreImpl;
import com.ftzen.spring.services.TestCounterService;
import com.ftzen.spring.services.TestGuageService;
import org.springframework.boot.actuate.metrics.CounterService;
import org.springframework.boot.actuate.metrics.GaugeService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

/**
 * Created by  <a href="mailto:ranbir.chawla@14zen.com">Ranbir Chawla</a> on 1/27/15.
 */

@Configuration
@EnableAspectJAutoProxy
@ComponentScan("com.ftzen.spring")
public class TestConfiguration {

    @Bean
    public CounterService counterService() {
        return new TestCounterService();
    }

    @Bean
    public GaugeService guageService() {
        return  new TestGuageService();
    }

    @Bean
    public GuageStore guageStore() {
        return new GuageStoreImpl();
    }

    @Bean
    public CounterStore counterStore() {
        return new CounterStoreImpl();
    }

}
