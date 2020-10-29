package com.ioet.acme.enums;

public enum Compensation {

    MONDAY_TO_FRIDAY_MORNING(25, Schedules.MORNING.name(), false),
    MONDAY_TO_FRIDAY_AFTERNOON(15, Schedules.AFTER_NOON.name(), false),
    MONDAY_TO_FRIDAY_NIGHT(20, Schedules.NIGHT.name(), false),
    WEEKEND_MORNING(30, Schedules.MORNING.name(), true),
    WEEKEND_EVENING(20, Schedules.AFTER_NOON.name(), true),
    WEEKEND_NIGHT(25, Schedules.NIGHT.name(), true);

    private final int compensation;
    private final String schedule;
    private final boolean weekend;

    Compensation(int compensation, String schedule, boolean weekend) {
        this.compensation = compensation;
        this.schedule = schedule;
        this.weekend = weekend;
    }

    public int getCompensation() {
        return compensation;
    }

    public static Compensation getBySchedule(boolean weekend, String schedule) {
        if (!weekend) {
            if (schedule.equals(Schedules.MORNING.name())) {
                return Compensation.MONDAY_TO_FRIDAY_MORNING;
            } else if (schedule.equals(Schedules.AFTER_NOON.name())) {
                return Compensation.MONDAY_TO_FRIDAY_AFTERNOON;
            } else {
                return Compensation.MONDAY_TO_FRIDAY_NIGHT;
            }
        } else {
            if (schedule.equals(Schedules.MORNING.name())) {
                return Compensation.WEEKEND_MORNING;
            } else if (schedule.equals(Schedules.AFTER_NOON.name())) {
                return Compensation.WEEKEND_EVENING;
            } else {
                return Compensation.WEEKEND_NIGHT;
            }
        }
    }
}
