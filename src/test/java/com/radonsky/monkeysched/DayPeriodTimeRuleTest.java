package com.radonsky.monkeysched;

import static org.joda.time.DateTimeConstants.*;
import static org.junit.Assert.*;

import org.joda.time.DateTime;
import org.joda.time.LocalTime;
import org.junit.Test;

public class DayPeriodTimeRuleTest {

    
    @Test
    public void test() {
        DayPeriodTimeRule rule = new DayPeriodTimeRule(
                MONDAY, 
                new LocalTime(8, 00), 
                new LocalTime(15, 00));
        assertTrue(rule.apply(new DateTime(2013, SEPTEMBER, 16, 10, 00)));
        assertTrue(rule.apply(new DateTime(2013, SEPTEMBER, 16, 8, 00)));
        assertFalse(rule.apply(new DateTime(2013, SEPTEMBER, 16, 7, 59)));
        assertFalse(rule.apply(new DateTime(2013, SEPTEMBER, 16, 15, 00)));
        assertFalse(rule.apply(new DateTime(2013, SEPTEMBER, 17, 10, 00)));
        assertFalse(rule.apply(new DateTime(2013, OCTOBER, 16, 15, 00)));
    }

}
