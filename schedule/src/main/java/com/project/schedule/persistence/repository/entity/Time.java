package com.project.schedule.persistence.repository.entity;

public enum Time {
    FIRST("8:30 - 9:50"), SECOND("10:00 - 11:20"), THIRD("11:40 - 13:00"),
    FOURTH("13:30 - 14:50"), FIFTH("15:00 - 16:20"), SIXTH("16:30 - 17:50");

    String value;

    Time(String value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return value;
    }
}
