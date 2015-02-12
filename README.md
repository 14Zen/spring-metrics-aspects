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

    @SuccessCounter("myservice.myendpoint")
    @MetricTimer("myservice.myendpoint")
    public MyObject getMyObject(.....);

##Capturing Docker Container ID
Docker Container runtime environments include the truncated ContainerID as a HOSTNAME environmental variable. This project leverages the Spring Environment to determine if the process environment variables container a HOSTNAME variable it will be captured and added to the end of the StatsD prefix. 

For example if the ContainerID is 5825f8bd516f the metric prefix based on the configuration above would be 
<code>your.prefix.5825f8bd516f.myservice.myendpoint</code> . 

This will allow for the use of * wildcard in graphite/grafana queries 

<code>stats.counters.your.prefix.*.myservice.myendpoint</code>

and the display of metrics PER CONTAINER and allow for you use the aggregation/sum functions as well to get an overall view of the container environment.


