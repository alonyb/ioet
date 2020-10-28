package com.ioet.acme.service;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.junit.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
public class WorkTimeTest {

    @InjectMocks
    WorkTime workTime;

    @Test
    public void getSalary() {
        String test = "RENE=MO10:00-12:00,TU10:00-12:00,TH01:00-03:00,SA14:00-18:00,SU20:00-21:00";
        workTime.getSalary(test);
    }

    @Test
    public void weekend() {
    }

    @Test
    public void timeOfDay() {
    }
}