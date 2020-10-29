package com.ioet.acme.util;

import java.time.LocalTime;

public class TimeUtil {

    public static LocalTime localTime(String hours, String status) {
        String[] tim = hours.split("[-]", 0);
        if (status.equals("start")){
            LocalTime start = LocalTime.parse(tim[0]);
            return start;
        } else {
            LocalTime end = LocalTime.parse(tim[1]);
            return end;
        }
    }

    public static int getHoursElapsed(LocalTime end, LocalTime start) {
        int hoursWorked = end.getHour() - start.getHour();
        return hoursWorked;
    }

}
