package com.ftzen.spring.metrics.config;

import com.timgroup.statsd.StatsDClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.condition.ConditionalOnClass;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.scheduling.annotation.EnableScheduling;

/**
 * Created by ranbir on 2/10/15.
 */

@Configuration
@EnableConfigurationProperties(MetricsProperties.class)
@ConditionalOnClass(com.timgroup.statsd.StatsDClient.class)
@EnableAspectJAutoProxy
@EnableScheduling
@ComponentScan("com.ftzen.spring.metrics")
public class MetricsConfig {

    @Autowired
    private MetricsProperties metricsProperties;

    @Bean
    public StatsDClient statsDClient() {
        return metricsProperties.createStatDClient();
    }
}
