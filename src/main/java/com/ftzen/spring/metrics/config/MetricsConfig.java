package com.ftzen.spring.metrics.config;

import com.timgroup.statsd.StatsDClient;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.condition.ConditionalOnClass;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.core.env.Environment;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.util.StringUtils;

import javax.annotation.Resource;

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

    private static final Logger logger = LoggerFactory.getLogger(MetricsConfig.class);

    @Autowired
    private MetricsProperties metricsProperties;

    @Resource
    private Environment env;

    @Bean
    public StatsDClient statsDClient() {
        return metricsProperties.createStatDClient();
    }

    /**
     * here we capture the HOSTNAME env var if it's available. If the service is running in docker it will
     * return the shortened containerId. While there is a remote chance of conflict, even in a large
     * cluster we should have a unique id per container. we can use this in the prefix for metrics to allow for searches
     * like svc..mysvc.*.api.myresource.retrieved and get all the data for each container. But we can also query adhoc
     * into metrics data if needed.
     *
     * we can add more items as we figure out how to find them.
     * @return ContainerInfo
     */
    @Bean
    public ContainerPrefix metricSuffix() {
        ContainerPrefix containerPrefix = new ContainerPrefix();
        String containerId = env.getProperty("HOSTNAME");
        logger.info("HEY--- containerId IS->{}", containerId);
        if(StringUtils.hasText(containerId)) {
            containerPrefix.setPrefixValue(containerId);
            containerPrefix.setHasPrefix(true);
        }
        return containerPrefix;
    }
}
