package com.ioet.acme.enums;

import java.time.LocalTime;

public enum Schedules {
    MORNING(LocalTime.MIN, LocalTime.of(9, 0)),
    AFTER_NOON(LocalTime.of(9, 1), LocalTime.of(18, 1)),
    NIGHT(LocalTime.of(18, 0), LocalTime.MAX);

    Schedules(LocalTime start, LocalTime end) {
        this.start = start;
        this.end = end;
    }

    public LocalTime getStart() {
        return start;
    }

    public LocalTime getEnd() {
        return end;
    }

    private final LocalTime start;
    private final LocalTime end;

}