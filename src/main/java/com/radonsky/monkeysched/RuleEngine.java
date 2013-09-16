package com.radonsky.monkeysched;

import static com.google.common.base.Predicates.*;
import static org.joda.time.DateTimeConstants.*;

import java.util.List;

import org.joda.time.LocalTime;

import com.google.common.collect.ImmutableList;

public class RuleEngine {

    private static final RuleEngine INSTANCE = new RuleEngine();
    
    private final ImmutableList<TimeRule> whiteList;

    private final ImmutableList<TimeRule> blackList;
    
    private RuleEngine() {
        this(
            ImmutableList.of(
                new DayPeriodTimeRule(MONDAY, new LocalTime(9, 00), new LocalTime(15, 00)),
                new DayPeriodTimeRule(TUESDAY, new LocalTime(9, 00), new LocalTime(15, 00)),
                new DayPeriodTimeRule(WEDNESDAY, new LocalTime(9, 00), new LocalTime(15, 00)),
                new DayPeriodTimeRule(THURSDAY, new LocalTime(9, 00), new LocalTime(15, 00)),
                new DayPeriodTimeRule(FRIDAY, new LocalTime(9, 00), new LocalTime(15, 00))
            ),
            ImmutableList.<TimeRule>of(
                new PartialTimeRule(JANUARY, 1),            // New Year's Day
                new PartialTimeRule(2013, NOVEMBER, 28),    // Thanksgiving Day
                new PartialTimeRule(DECEMBER, 25),          // Christmas Day
                new PartialTimeRule(2014, JANUARY, 20),     // Martin Luther King Day
                new PartialTimeRule(2014, FEBRUARY, 17),    // Presidents' Day
                new PartialTimeRule(2014, MAY, 26),         // Memorial Day
                new PartialTimeRule(2014, JULY, 4),         // Independence Day
                new PartialTimeRule(2014, SEPTEMBER, 1),    // Labor Day
                new PartialTimeRule(2014, NOVEMBER, 27)     // Thanksgiving Day
            )
        );
    }
    
    public RuleEngine(List<? extends TimeRule> whiteList, List<? extends TimeRule> blackList) {
        this.whiteList = ImmutableList.copyOf(whiteList);
        this.blackList = ImmutableList.copyOf(blackList);        
    }
    
    public static RuleEngine getDefault() {
        return INSTANCE;
    }
    
    public TimeRule getTimeRule() {
        return new Rule(and(or(whiteList), not(or(blackList))));
    }

    public ImmutableList<TimeRule> getWhiteList() {
        return whiteList;
    }

    public ImmutableList<TimeRule> getBlackList() {
        return blackList;
    }
    
    
    
}
