package com.ioet.acme.enums;

public enum Compensation {

    MONDAY_TO_FRIDAY_MORNING(25, Schedules.MORNING.name(), false),
    MONDAY_TO_FRIDAY_AFTERNOON(15, Schedules.AFTER_NOON.name(), false),
    MONDAY_TO_FRIDAY_NIGHT(20, Schedules.NIGHT.name(), false),
    WEEKEND_MORNING(30, Schedules.MORNING.name(), true),
    WEEKEND_EVENING(20, Schedules.AFTER_NOON.name(), true),
    WEEKEND_NIGHT(25, Schedules.NIGHT.name(), true);

    private final int comp;
    private final String schedule;
    private final boolean weekend;

    Compensation(int compensation, String schedule, boolean weekend) {
        this.comp = compensation;
        this.schedule = schedule;
        this.weekend = weekend;
    }

    public int getCompensation() {
        return comp;
    }

    public static int getBySchedule(boolean weekend, String schedule) {
        if (!weekend) {
            if (schedule.equals(Schedules.MORNING.name())) {
                return Compensation.MONDAY_TO_FRIDAY_MORNING.getCompensation();
            } else if (schedule.equals(Schedules.AFTER_NOON.name())) {
                return Compensation.MONDAY_TO_FRIDAY_AFTERNOON.getCompensation();
            } else {
                return Compensation.MONDAY_TO_FRIDAY_NIGHT.getCompensation();
            }
        } else {
            if (schedule.equals(Schedules.MORNING.name())) {
                return Compensation.WEEKEND_MORNING.getCompensation();
            } else if (schedule.equals(Schedules.AFTER_NOON.name())) {
                return Compensation.WEEKEND_EVENING.getCompensation();
            } else {
                return Compensation.WEEKEND_NIGHT.getCompensation();
            }
        }
    }
}
