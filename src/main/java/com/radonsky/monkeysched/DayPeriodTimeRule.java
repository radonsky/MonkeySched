package com.radonsky.monkeysched;

import javax.annotation.Nullable;

import org.joda.time.DateTime;
import org.joda.time.DateTimeFieldType;
import org.joda.time.LocalTime;
import org.joda.time.Partial;

public class DayPeriodTimeRule implements TimeRule {

    private final Partial dayOfWeek;
    private final LocalTime startTime;
    private final LocalTime endTime;
    
    public DayPeriodTimeRule(int dayOfWeek, LocalTime startTime, LocalTime endTime) {
        this.dayOfWeek = new Partial(DateTimeFieldType.dayOfWeek(), dayOfWeek);
        this.startTime = startTime;
        this.endTime = endTime;
    }
    
    @Override
    public boolean apply(@Nullable DateTime input) {
        DateTime start = startTime.toDateTime(input);
        DateTime end = endTime.toDateTime(input);
        return dayOfWeek.isMatch(input) 
            && (input.isAfter(start) || input.isEqual(start)) 
            && input.isBefore(end);
    }

}
