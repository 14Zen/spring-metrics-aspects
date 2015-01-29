package com.ftzen.spring;

import com.ftzen.spring.services.CounterStore;
import com.ftzen.spring.services.TestCounterService;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * Created by  <a href="mailto:ranbir.chawla@14zen.com">Ranbir Chawla</a> on 1/27/15.
 */

@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = { TestConfiguration.class})
@ActiveProfiles(profiles = "unittest")
public class CounterTest {

    @Autowired
    private TestCounterService testCounterService;

    @Autowired
    private CounterStore counterStore;

    @Autowired
    private TestService testService;

    @Before
    public void setup() {

    }

    @Test
    public void counterSuccessTest() {

        testService.oopsIDidItAgain();
        testService.oopsIDidItAgain();
        int retCount = counterStore.getCounterValue("test.metric.brittney.success");
        assertEquals("counter mismatch",2,retCount);
    }

    @Test
    public void failureCountTest() {
        testService.dangNabIt();
        testService.dangNabIt();
        int retCount = counterStore.getCounterValue("test.metric.cbrown.failure");
        assertEquals("counter mismatch",2,retCount);
    }
}
