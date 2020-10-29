package com.ioet.acme.util;

import java.time.LocalTime;

public class TimeUtil {

    public static LocalTime localTime(String hours, String status) {
        String[] tim = hours.split("[-]", 0);
        if (status.equals("start")){
            return LocalTime.parse(tim[0]);
        } else {
            return LocalTime.parse(tim[1]);
        }
    }

    public static int getHoursElapsed(LocalTime end, LocalTime start) {
        return end.getHour() - start.getHour();
    }

}
