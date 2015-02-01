# spring-metrics-aspects
Standardized Annotations and Aspects to add AOP metrics point cuts to services methods supporting metrics platform in spring boot

## Leveraging StatsD
This project includes the <a href="https://github.com/tim-group/java-statsd-client">java-statsd-client</a> to communicate with a standard StatsD server. 

At this time there is not yet a Spring AutoConfig, so it will be necessary to create a StatsDClient in the bean factory. An example of a working config is in the example below. This will also include the MetricsExportScheduler. No further configuration is need, as the aspects Autowire the statsDClient bean.

This bean will periodically generate a list of SystemPublicMetrics to export as StatsD Guages to the server. 

<code>
@Configuration

@ComponentScan("com.ftzen.spring.metrics.export")

public class MetricsConfig {

    @Value("${statsd.prefix}")
    
    private String statsDPrefix;

    @Value("${statsd-host}")
    private String statsDHost;

    @Bean
    public StatsDClient statsDClient() {
        StatsDClient statsd = new NonBlockingStatsDClient(statsDPrefix, statsDHost, 8125);
        return statsd;
    }
}
</code>

## Using StatsD aspects
### Counters
To add a counter for a method using the @SuccessCounter or @FailureCounter annotation with the appropriate StatsD metric name as the value. The annotations both increment the value at this point. They are named this was to distinguish them from the Spring Boot Actuator Counter annotation.

Metric naming is key, a good guide can be found in Matt Aimonetti's well known <a href="http://matt.aimonetti.net/posts/2013/06/26/practical-guide-to-graphite-monitoring/">blog post</a>.

###Timer
To add a method timer using Spring AOP Around advice use the @MetricTimer annotation with the metric name as the value. 

###Example
<code>
    @SuccessCounter("svcs.myservice.myendpoint")
    @MetricTimer("svcs.myservice.myendpoint")
    public MyObject getMyObject(.....);
</code>



