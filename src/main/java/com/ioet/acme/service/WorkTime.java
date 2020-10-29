package com.ioet.acme.service;

import com.ioet.acme.repository.InEmployeeRepository;
import org.springframework.util.StringUtils;

import java.time.LocalTime;

public class WorkTime {

    private static final LocalTime MORNING = LocalTime.of(0, 1, 0);
    private static final LocalTime AFTER_NOON = LocalTime.of(9, 1, 0);
    private static final LocalTime EVENING = LocalTime.of(18, 1, 0);
    private static final LocalTime END_DAY = LocalTime.of(23, 59, 59);

    private InEmployeeRepository repository;

    public WorkTime(InEmployeeRepository repository) {
        this.repository = repository;
    }

    public void getSalary(String value) {
        String[] info = StringUtils.split(value, "=");
        String nameEmployee = info[0];
        String[] timeString = info[1].split("[,]", 0);
        int salary = 0;
        for (String s : timeString) {
            String day = s.substring(0, 2);
            String hours = s.substring(2);
            String[] tim = hours.split("[-]", 0);
            LocalTime start = LocalTime.parse(tim[0]);
            LocalTime end = LocalTime.parse(tim[1]);

            int startTime = timeOfDay(start);
            int endtTime = timeOfDay(end);

            int payment = 0;
            if (startTime == endtTime) {
                if (startTime == 1 && !weekend(day)) {
                    payment = 25;
                } else if (startTime == 2 && !weekend(day)) {
                    payment = 15;
                } else if (startTime == 3 && !weekend(day)) {
                    payment = 20;
                } else if (startTime == 1 && weekend(day)) {
                    payment = 30;
                } else if (startTime == 2 && weekend(day)) {
                    payment = 20;
                } else if (startTime == 3 && weekend(day)) {
                    payment = 25;
                }
            } else {
                System.out.println("There exist a invalid time to " + nameEmployee);
                break;
            }
            int hoursWorked = end.getHour() - start.getHour();
            payment = hoursWorked * payment;
            salary += payment;
        }
        repository.employee(nameEmployee, salary);
    }

    public boolean weekend(String day) {
        return day.equals("SA") || day.equals("SU");
    }

    public int timeOfDay(LocalTime time) {
        if (between(time, MORNING, AFTER_NOON)) {
            return 1;
        } else if (between(time, AFTER_NOON, EVENING)) {
            return 2;
        } else if (between(time, EVENING, END_DAY)) {
            return 3;
        }
        return 0;
    }

    private boolean between(LocalTime time, LocalTime start, LocalTime end) {
        return (!time.isBefore(start)) && time.isBefore(end);
    }
}
