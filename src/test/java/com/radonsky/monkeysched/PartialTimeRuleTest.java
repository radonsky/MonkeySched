package com.radonsky.monkeysched;

import static org.joda.time.DateTimeConstants.*;
import static org.junit.Assert.*;

import org.joda.time.DateTime;
import org.junit.Test;

public class PartialTimeRuleTest {

    @Test
    public void testTwoParameterConstructor() {
        PartialTimeRule rule = new PartialTimeRule(DECEMBER, 25);
        assertTrue(rule.apply(new DateTime(2013, DECEMBER, 25, 12, 00)));
        assertTrue(rule.apply(new DateTime(2014, DECEMBER, 25, 12, 00)));
        assertFalse(rule.apply(new DateTime(2013, DECEMBER, 24, 12, 00)));
        assertFalse(rule.apply(new DateTime(2013, DECEMBER, 24, 23, 59)));
    }

    @Test
    public void testThreeParameterConstructor() {
        PartialTimeRule rule = new PartialTimeRule(2013, DECEMBER, 25);
        assertTrue(rule.apply(new DateTime(2013, DECEMBER, 25, 12, 00)));
        assertFalse(rule.apply(new DateTime(2014, DECEMBER, 25, 12, 00)));
        assertFalse(rule.apply(new DateTime(2013, DECEMBER, 24, 12, 00)));
        assertFalse(rule.apply(new DateTime(2013, DECEMBER, 26, 00, 00)));
    }

}
