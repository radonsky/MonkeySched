package com.radonsky.monkeysched;

import static org.joda.time.DateTime.*;
import static org.junit.Assert.*;

import java.util.Collections;

import org.joda.time.DateTime;
import org.junit.Test;

import com.google.common.base.Predicates;
import com.google.common.collect.ImmutableList;

public class RuleEngineTest {

    @Test
    public void testDefault() {
        assertNotNull(RuleEngine.getDefault());
    }
    
    @Test
    public void testRuleEngineConstructor() {
        ImmutableList<TimeRule> whiteList = ImmutableList.of();
        ImmutableList<TimeRule> blackList = ImmutableList.of();
        RuleEngine engine = new RuleEngine(whiteList, blackList);
        assertSame(whiteList, engine.getWhiteList());
        assertSame(blackList, engine.getBlackList());
    }

    @Test
    public void testTimeRuleWhiteListing() {
        RuleEngine re = new RuleEngine(
                ImmutableList.of(new Rule(Predicates.<DateTime>alwaysTrue())),
                Collections.<TimeRule>emptyList()
        );
        assertTrue(re.getTimeRule().apply(now()));
    }

    @Test
    public void testTimeRuleBlackListing() {
        RuleEngine re = new RuleEngine(
                Collections.<TimeRule>emptyList(),
                ImmutableList.of(new Rule(Predicates.<DateTime>alwaysTrue()))
        );
        assertFalse(re.getTimeRule().apply(now()));
    }

    @Test
    public void testTimeRulePreference() {
        RuleEngine re = new RuleEngine(
                ImmutableList.of(new Rule(Predicates.<DateTime>alwaysTrue())),
                ImmutableList.of(new Rule(Predicates.<DateTime>alwaysTrue()))
        );
        assertFalse(re.getTimeRule().apply(now()));
    }

    @Test
    public void testTimeRuleEmptyLists() {
        RuleEngine re = new RuleEngine(
                Collections.<TimeRule>emptyList(),
                Collections.<TimeRule>emptyList()
        );
        assertFalse(re.getTimeRule().apply(now()));
    }
    
}
