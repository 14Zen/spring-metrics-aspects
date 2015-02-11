package com.ftzen.spring;

import com.ftzen.spring.metrics.config.MetricsConfig;
import com.ftzen.spring.metrics.test.support.TimerStore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

/**
 * Created by  <a href="mailto:ranbir.chawla@14zen.com">Ranbir Chawla</a> on 1/28/15.
 */

@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = {TestConfiguration.class})
@ActiveProfiles(profiles = "unittest")
public class TimerTest {

    @Autowired
    private TimerStore timerStore;

    @Autowired
    private TestService testService;

    @Test
    public void timerGuageTwoRunTest() throws Exception {
        testService.sitAndSleepThenReturnString();
        testService.sitAndSleepThenReturnString();
        Long duration = timerStore.getTimeByMetricName("test.metric.counter");
        assertNotNull("duration not returned",duration);
        assertTrue("metric value not large enough",(duration > 1500D && duration < 3000D));
    }
}
