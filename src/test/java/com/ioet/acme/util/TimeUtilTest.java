package com.ioet.acme.util;

import org.hamcrest.CoreMatchers;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ErrorCollector;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.junit.MockitoJUnitRunner;

import java.time.LocalTime;

import static org.junit.Assert.*;

@RunWith(MockitoJUnitRunner.class)
public class TimeUtilTest {

    @InjectMocks
    TimeUtil timeUtil;

    @Rule
    public ErrorCollector errorCollector = new ErrorCollector();

    @Test
    public void localTime() {
        // ARRANGE
        String hour = "10:00-12:00";
        String status = "start";

        // ACT
        LocalTime value = timeUtil.localTime(hour, status);

        // ASSERT
        errorCollector.checkThat(value, CoreMatchers.notNullValue());
        errorCollector.checkThat(value, CoreMatchers.equalTo(LocalTime.of(10, 0)));
        errorCollector.checkThat(value, CoreMatchers.instanceOf(LocalTime.class));
    }

    @Test
    public void getHoursElapsed() {
        // ARRANGE
        LocalTime start = LocalTime.of(12,0);
        LocalTime end = LocalTime.of(10,0);

        // ACT
        int value = timeUtil.getHoursElapsed(start, end);

        // ASSERT
        errorCollector.checkThat(value, CoreMatchers.notNullValue());
        errorCollector.checkThat(value, CoreMatchers.equalTo(2));
        errorCollector.checkThat(value, CoreMatchers.instanceOf(Integer.class));
    }
}