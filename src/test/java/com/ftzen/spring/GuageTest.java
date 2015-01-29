package com.ftzen.spring;

import com.ftzen.spring.services.GuageStore;
import com.ftzen.spring.services.TestGuageService;
import org.junit.Test;
import org.junit.runner.RunWith;
import static org.junit.Assert.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

/**
 * Created by  <a href="mailto:ranbir.chawla@14zen.com">Ranbir Chawla</a> on 1/28/15.
 */

@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = { TestConfiguration.class})
@ActiveProfiles(profiles = "unittest")
public class GuageTest {


    @Autowired
    private TestGuageService testGuageService;

    @Autowired
    private GuageStore guageStore;

    @Autowired
    private TestService testService;

    @Test
    public void timerGuageOneRunTest() throws Exception {

        assertNotNull("testGuageService is null",testGuageService);
        testService.sitAndSleepThenReturnString();
        List<Double> returnValueList = guageStore.getTimeByMetricName("test.metric.counter");
        assertNotNull("not value list returned",returnValueList);
    }
}
