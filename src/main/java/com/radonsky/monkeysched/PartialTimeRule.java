package com.radonsky.monkeysched;

import static org.joda.time.DateTimeFieldType.*;

import javax.annotation.Nullable;

import org.joda.time.DateTime;
import org.joda.time.DateTimeFieldType;
import org.joda.time.Partial;

public class PartialTimeRule implements TimeRule {

    private final Partial partial;
    
    public PartialTimeRule(Partial partial) {
        this.partial = partial;
    }
    
    public PartialTimeRule(int monthOfYear, int dayOfMonth) {
        this(new Partial(new DateTimeFieldType[] {
                monthOfYear(), dayOfMonth(), 
        }, new int[] {monthOfYear, dayOfMonth}));
    }
    
    public PartialTimeRule(int year, int monthOfYear, int dayOfMonth) {
        this(new Partial(new DateTimeFieldType[] {
                year(), monthOfYear(), dayOfMonth()
        }, new int[] {year, monthOfYear, dayOfMonth}));
    }

    @Override
    public boolean apply(@Nullable DateTime input) {
        return partial.isMatch(input);
    }

    public Partial getPartial() {
        return partial;
    }
    
}
