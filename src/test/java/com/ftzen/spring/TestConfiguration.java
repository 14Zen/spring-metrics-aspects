package com.ftzen.spring;

import com.ftzen.spring.metrics.test.support.MockStatsDClient;
import com.timgroup.statsd.StatsDClient;
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
    public StatsDClient statsDClient() {
        StatsDClient statsd = new MockStatsDClient();
        return statsd;
    }

}
