# spring-metrics-aspects
Standardized Annotations and Aspects to add AOP metrics point cuts to services methods supporting metrics platform in spring boot

## Leveraging StatsD
This project includes the <a href="https://github.com/tim-group/java-statsd-client">java-statsd-client</a> to communicate with a standard StatsD server. 

To incorporate the statsDClient and all the aspects import MetricsConfig.class in your main project configuration.

	@Import("MetricsConfig")

To configure the statsD host and metrics prefix information set the following properties:


	statsd.prefix=<your prefix>
	statsd.host=<statsD host name>

The statsD client will use the standard UDP port of 8125 by default. There is no method at this point to override that.

## Exporting Spring System Metrics to StatsD
By importing MetricsConfig you are also configuring the MetricsExportScheduler bean. This bean will fire every 30 seconds and retrieve all the System level metrics exposed by Spring Boot. These metrics will be sent as Gauges to StatsD using the prefix configured above.

## Using StatsD aspects
### Counters
To add a counter for a method using the @SuccessCounter or @FailureCounter annotation with the appropriate StatsD metric name as the value. The annotations both increment the value at this point. They are named this was to distinguish them from the Spring Boot Actuator Counter annotation.

Metric naming is key, a good guide can be found in Matt Aimonetti's well known <a href="http://matt.aimonetti.net/posts/2013/06/26/practical-guide-to-graphite-monitoring/">blog post</a>.

###Timer
To add a method timer using Spring AOP Around advice use the @MetricTimer annotation with the metric name as the value. 

###Example

    @SuccessCounter("svcs.myservice.myendpoint")
    @MetricTimer("svcs.myservice.myendpoint")
    public MyObject getMyObject(.....);




