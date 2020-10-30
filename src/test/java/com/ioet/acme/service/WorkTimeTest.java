package com.ioet.acme.service;

import com.ioet.acme.repository.InEmployeeRepository;
import org.hamcrest.CoreMatchers;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ErrorCollector;
import org.junit.runner.RunWith;
import org.mockito.*;
import org.mockito.junit.MockitoJUnitRunner;


@RunWith(MockitoJUnitRunner.class)
public class WorkTimeTest {

    @InjectMocks
    WorkTime workTime;

    @Mock
    InEmployeeRepository repository;

    @Captor
    ArgumentCaptor<String> employeeCaptor;

    @Rule
    public ErrorCollector errorCollector = new ErrorCollector();

    @Test
    public void getSalary() {

        // ARRANGE
        String testValue = "RENE=MO10:00-12:00,TU10:00-12:00,TH01:00-03:00,SA14:00-18:00,SU20:00-21:00";

        // ACT
        workTime.getSalary(testValue);
        Mockito.verify(repository).employee(employeeCaptor.capture(), ArgumentMatchers.anyInt());
        String name = employeeCaptor.getValue();

        // ASSERT
        errorCollector.checkThat(name, CoreMatchers.notNullValue());
        errorCollector.checkThat(name, CoreMatchers.equalTo("RENE"));
        errorCollector.checkThat(name, CoreMatchers.instanceOf(String.class));
    }

    @Test
    public void weekend() {

        // ARRANGE
        Boolean value;
        String dayValue = "SA";

        // ACT
        value = workTime.weekend(dayValue);

        // ASSERT
        errorCollector.checkThat(value, CoreMatchers.notNullValue());
        errorCollector.checkThat(value, CoreMatchers.equalTo(true));
        errorCollector.checkThat(value, CoreMatchers.instanceOf(Boolean.class));
    }
}