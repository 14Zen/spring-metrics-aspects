package com.ftzen.spring.metrics.export;

import com.timgroup.statsd.StatsDClient;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.actuate.endpoint.SystemPublicMetrics;
import org.springframework.boot.actuate.metrics.Metric;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.util.Collection;

/**
 * Created by ranbir on 1/30/15.
 */
@Component
public class MetricsExportScheduler {

    private static final Logger logger = LoggerFactory.getLogger(MetricsExportScheduler.class);

    @Autowired
    private StatsDClient statsDClient;

    @Scheduled(fixedDelay=30000)
    public void exportMetrics() {
        logger.debug("exporting metrics");
        SystemPublicMetrics publicMetrics = new SystemPublicMetrics();
        Collection<Metric<?>> metrics = publicMetrics.metrics();
        for(Metric<?> metric: metrics) {
            statsDClient.recordGaugeValue(metric.getName(), metric.getValue().longValue());
        }
    }
}
