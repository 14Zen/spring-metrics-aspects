package com.ftzen.spring.metrics.config;

/**
 * Created by ranbir on 2/11/15.
 */
public class ContainerPrefix {

    private String prefixValue = "";
    private boolean hasPrefix = false;

    public ContainerPrefix() { }

    public String getPrefixValue() {
        return prefixValue;
    }

    public String fullMetricName(String metricName) {
        return (hasPrefix) ?  String.format("%s.%s", prefixValue,metricName) : metricName;
    }

    public void setPrefixValue(String prefixValue) {
        this.prefixValue = prefixValue;
    }

    public boolean isHasPrefix() {
        return hasPrefix;
    }

    public void setHasPrefix(boolean hasPrefix) {
        this.hasPrefix = hasPrefix;
    }
}
