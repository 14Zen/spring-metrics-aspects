package com.ftzen.spring.metrics.config;

import com.timgroup.statsd.NonBlockingStatsDClient;
import com.timgroup.statsd.StatsDClient;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.context.properties.ConfigurationProperties;

/**
 * Created by ranbir on 2/11/15.
 */
@ConfigurationProperties(prefix = "statsd")
public class MetricsProperties {

    private static final int DEFAULT_PORT = 8125;

    private String prefix = "svc";

    private String host = "localhost";

    public StatsDClient createStatDClient() {
        return new NonBlockingStatsDClient(prefix, host, DEFAULT_PORT);
    }

    public String getPrefix() {
        return prefix;
    }

    public void setPrefix(String prefix) {
        this.prefix = prefix;
    }

    public String getHost() {
        return host;
    }

    public void setHost(String host) {
        this.host = host;
    }
}
