package com.ioet.acme.service;

import com.ioet.acme.enums.Compensation;
import com.ioet.acme.enums.Schedules;
import com.ioet.acme.repository.InEmployeeRepository;
import com.ioet.acme.util.TimeUtil;

import java.time.LocalTime;

public class WorkTime {

    private InEmployeeRepository repository;

    private TimeUtil timeUtil;

    public WorkTime(InEmployeeRepository repository) {
        this.repository = repository;
    }

    public void getSalary(String value) {
        String[] info = value.split("=");
        String nameEmployee = info[0];
        String[] timeString = info[1].split("[,]", 0);
        int salary = 0;
        for (String s : timeString) {
            String day = s.substring(0, 2);
            String hours = s.substring(2);
            LocalTime start = timeUtil.localTime(hours, "start");
            LocalTime end = timeUtil.localTime(hours, "end");
            String schedule = getSchedule(start, end);
            int payment = Compensation.getBySchedule(weekend(day), schedule);
            payment = timeUtil.getHoursElapsed(end, start) * payment;
            salary += payment;
        }
        repository.employee(nameEmployee, salary);
    }

    private String getSchedule(LocalTime start, LocalTime end) {
        if (start.isAfter(Schedules.MORNING.getStart()) && end.isBefore(Schedules.MORNING.getEnd())) {
            return Schedules.MORNING.name();
        } else if (start.isAfter(Schedules.AFTER_NOON.getStart()) && end.isBefore(Schedules.AFTER_NOON.getEnd())) {
            return Schedules.AFTER_NOON.name();
        } else {
            return Schedules.NIGHT.name();
        }
    }

    public boolean weekend(String day) {
        return day.equals("SA") || day.equals("SU");
    }

}
