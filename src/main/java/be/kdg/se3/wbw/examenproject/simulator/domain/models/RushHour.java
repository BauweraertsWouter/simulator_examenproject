package be.kdg.se3.wbw.examenproject.simulator.domain.models;

import java.time.LocalTime;

public class RushHour {
    private final LocalTime begin;
    private final LocalTime end;

    public RushHour(LocalTime begin, LocalTime end) {
        this.begin = begin;
        this.end = end;
    }

    public boolean isRushHour(LocalTime time) {
        return !(time.isBefore(begin) || time.isAfter(end));
    }
}
