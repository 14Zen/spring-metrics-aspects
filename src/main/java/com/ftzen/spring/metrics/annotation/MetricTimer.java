package com.ftzen.spring.metrics.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * Created by  <a href="mailto:ranbir.chawla@14zen.com">Ranbir Chawla</a> on 1/27/15.
 */

@Target(value = {ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
public @interface MetricTimer {
    String value();
}
